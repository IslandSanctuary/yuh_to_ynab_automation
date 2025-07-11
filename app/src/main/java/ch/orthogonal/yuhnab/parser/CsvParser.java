package ch.orthogonal.yuhnab.parser;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface CsvParser {
    List<Map<String, Object>> parse(Path csvFilePath) throws Exception;
}