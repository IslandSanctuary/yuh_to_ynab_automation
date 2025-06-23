package com.example.csvmonitor;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MockApiClient implements ApiClient {
    private static Logger logger = LogManager.getLogger(MockApiClient.class);

    public void send(List<Map<String, String>> parsedData) {
        if (parsedData.isEmpty()) {
            logger.info("No data to send.");
            return;
        }

        logger.info("Sending data to API...");
        logger.info("Headers: %s", parsedData.get(0).keySet());

        int previewLimit = Math.min(3, parsedData.size());
        for (int i = 0; i < previewLimit; i++) {
            logger.info("Row %d: %s", (i + 1), parsedData.get(i));
        }
    }
}