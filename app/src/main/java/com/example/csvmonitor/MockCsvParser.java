package com.example.csvmonitor;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MockCsvParser implements CsvParser {
    private static Logger logger = LogManager.getLogger(MockCsvParser.class);

    public List<Map<String, String>> parse(Path csvFilePath) throws Exception {
        logger.info("Parsing file: {}", csvFilePath.getFileName());
        List<Map<String, String>> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String[] headers = reader.readLine().split(",");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    row.put(headers[i].trim(), values[i].trim());
                }
                result.add(row);
            }
        }
        return result;
    }
}