package com.example.csvmonitor;

import java.util.List;
import java.util.Map;

public interface ApiClient {
    void send(List<Map<String, String>> parsedData);
}