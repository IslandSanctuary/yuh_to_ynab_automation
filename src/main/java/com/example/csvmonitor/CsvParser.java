package com.example.csvmonitor;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface CsvParser {
    List<Map<String, String>> parse(Path csvFilePath) throws Exception;
}