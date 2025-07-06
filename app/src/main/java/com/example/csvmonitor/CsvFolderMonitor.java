package com.example.csvmonitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;

public class CsvFolderMonitor {
    private static final Logger logger = LogManager.getLogger(CsvFolderMonitor.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        Path folder = Paths.get(args.length > 0 ? args[0] : System.getProperty("user.home"));
        CsvParser parser = new YuhCsvParser();
        ApiClient apiClient = new MockApiClient();

        WatchService watchService = FileSystems.getDefault().newWatchService();
        folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        logger.info("Watching folder: {}", folder.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path filename = (Path) event.context();
                    Path filePath = folder.resolve(filename);
                    if (filename.toString().endsWith(".csv")) {
                        logger.info("New file detected: {}", filename);
                        try {
                            var parsedData = parser.parse(filePath);
                            apiClient.send(parsedData);
                        } catch (Exception e) {
                            logger.error("Failed to process file: {}", e.getMessage());
                        }
                    }
                }
            }
            key.reset();
        }
    }
}