package com.example.csvmonitor;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YuhCsvParser implements CsvParser {
    private static final Logger logger = LogManager.getLogger(YuhCsvParser.class);
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final DateTimeFormatter INPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public List<Map<String, String>> parse(Path csvFilePath) throws Exception {
        logger.info("Parsing file: {}", csvFilePath.getFileName());

        List<Map<String, String>> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            // Use semicolon delimiter and enable double quote handling
            CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).setDelimiter(';')
                    .setIgnoreHeaderCase(true).setTrim(true).build();

            try (CSVParser csvParser = new CSVParser(reader, format)) {
                for (CSVRecord record : csvParser) {
                    Map<String, String> transformedRow = transformRow(record);
                    result.add(transformedRow);
                }
            }
        }

        return result;
    }

    private Map<String, String> transformRow(CSVRecord record) {
        // Create a normalized map with cleaned keys and values
        Map<String, String> normalizedRow = new LinkedHashMap<>();

        for (String header : record.getParser().getHeaderNames()) {
            // Normalize header key: strip whitespace, quotes, BOM, and uppercase
            String normalizedKey = normalizeKey(header);
            String value = record.get(header);
            // Clean value: remove quotes, collapse spaces
            String cleanedValue = cleanString(value != null ? value : "");
            normalizedRow.put(normalizedKey, cleanedValue);
        }

        // Transform the row according to YNAB format
        Map<String, String> result = new LinkedHashMap<>();

        // 1) Date: DD/MM/YYYY -> YYYY-MM-DD
        String dateStr = transformDate(normalizedRow.get("DATE"));
        result.put("Date", dateStr);

        // 2) Payee: concatenate RECIPIENT + SENDER
        String payee = createPayee(normalizedRow);
        result.put("Payee", payee);

        // 3) Outflow vs Inflow
        String[] outflowInflow = calculateOutflowInflow(normalizedRow);
        result.put("Outflow", outflowInflow[0]);
        result.put("Inflow", outflowInflow[1]);

        return result;
    }

    private String normalizeKey(String key) {
        if (key == null)
            return "";

        // Remove BOM, strip whitespace and quotes, then uppercase
        return key.replace("\uFEFF", "")
                .trim()
                .replaceAll("^[\"']+|[\"']+$", "")
                .toUpperCase();
    }

    private String cleanString(String s) {
        if (s == null)
            return "";

        // Remove all quotes and collapse whitespace
        String noQuotes = s.replace("\"", "").replace("'", "");
        String collapsed = WHITESPACE_PATTERN.matcher(noQuotes).replaceAll(" ");
        return collapsed.trim();
    }

    private String transformDate(String rawDate) {
        if (rawDate == null || rawDate.isEmpty()) {
            return "";
        }

        try {
            LocalDate date = LocalDate.parse(rawDate, INPUT_DATE_FORMAT);
            return date.format(OUTPUT_DATE_FORMAT);
        } catch (DateTimeParseException e) {
            logger.warn("Failed to parse date: {}, returning as-is", rawDate);
            return rawDate; // leave as-is on parse error
        }
    }

    private String createPayee(Map<String, String> normalizedRow) {
        String recipient = normalizedRow.getOrDefault("RECIPIENT", "");
        String sender = normalizedRow.getOrDefault("SENDER", "");

        String combined = (recipient + " " + sender).trim();
        return cleanString(combined);
    }

    private String[] calculateOutflowInflow(Map<String, String> normalizedRow) {
        String outflow = "";
        String inflow = "";

        String debit = normalizedRow.getOrDefault("DEBIT", "");
        String credit = normalizedRow.getOrDefault("CREDIT", "");
        String activityType = normalizedRow.getOrDefault("ACTIVITY TYPE", "");

        boolean isAutoGoal = "GOAL_AUTO_DEPOSIT".equals(activityType);

        if (!debit.isEmpty()) {
            try {
                double debitValue = Double.parseDouble(debit);
                outflow = String.format("%.2f", Math.abs(debitValue));
            } catch (NumberFormatException e) {
                logger.warn("Failed to parse debit value: {}, using as-is", debit);
                outflow = debit;
            }
        } else if (!credit.isEmpty()) {
            try {
                double creditValue = Double.parseDouble(credit);
                inflow = String.format("%.2f", creditValue);
            } catch (NumberFormatException e) {
                logger.warn("Failed to parse credit value: {}, using as-is", credit);
                inflow = credit;
            }
        }

        // Handle GOAL_AUTO_DEPOSIT case: swap outflow and inflow
        if (isAutoGoal) {
            return new String[] { inflow, outflow };
        } else {
            return new String[] { outflow, inflow };
        }
    }
}