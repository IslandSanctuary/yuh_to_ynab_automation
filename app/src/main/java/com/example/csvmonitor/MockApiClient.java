package com.example.csvmonitor;

import java.util.List;
import java.util.Map;

public class MockApiClient implements ApiClient {
    public void send(List<Map<String, String>> parsedData) {
        if (parsedData.isEmpty()) {
            System.out.println("No data to send.");
            return;
        }

        System.out.println("Sending data to API...");
        System.out.println("Headers: " + parsedData.get(0).keySet());

        int previewLimit = Math.min(3, parsedData.size());
        for (int i = 0; i < previewLimit; i++) {
            System.out.println("Row " + (i + 1) + ": " + parsedData.get(i));
        }
    }
}