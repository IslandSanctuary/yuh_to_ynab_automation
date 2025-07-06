package com.example.csvmonitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MockCsvParser implements CsvParser {
    private static final Logger logger = LogManager.getLogger(MockCsvParser.class);

    public List<Map<String, Object>> parse(Path csvFilePath) throws Exception {
        logger.info("Parsing file: {}", csvFilePath.getFileName());
        List<Map<String, Object>> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String[] headers = reader.readLine().split(",");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    row.put(headers[i].trim(), values[i].trim());
                }
                result.add(row);
            }
        }
        return result;
    }
}