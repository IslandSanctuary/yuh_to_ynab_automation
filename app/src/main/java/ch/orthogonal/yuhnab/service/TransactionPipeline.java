package ch.orthogonal.yuhnab.service;

import ch.orthogonal.yuhnab.client.ApiClient;
import ch.orthogonal.yuhnab.config.ServiceConfig;
import ch.orthogonal.yuhnab.parser.CsvParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

public class TransactionPipeline {
    private static final Logger logger = LogManager.getLogger(TransactionPipeline.class);
    private final CsvParser parser;
    private final ApiClient client;
    private final ServiceConfig config;

    public TransactionPipeline(CsvParser parser, ApiClient client, ServiceConfig config) {
        this.parser = parser;
        this.client = client;
        this.config = config;
    }

    public void processFile(Path path) {
        try {
            var parsedData = parser.parse(path);
            client.send(parsedData, config);
        } catch (Exception e) {
            logger.error("Failed to process file: {}", e.getMessage());
        }
    }
}
