package ch.orthogonal.yuhnab.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;

public class CsvFolderMonitor {
    private static final Logger logger = LogManager.getLogger(CsvFolderMonitor.class);
    private final TransactionPipeline pipeline;
    private final Path monitoredFolder;

    public CsvFolderMonitor(TransactionPipeline pipeline, Path monitoredFolder) {
        this.pipeline = pipeline;
        this.monitoredFolder = monitoredFolder;
    }


    public void run() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        monitoredFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        logger.info("Watching folder: {}", monitoredFolder.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path filename = (Path) event.context();
                    Path filePath = monitoredFolder.resolve(filename);
                    if (filename.toString().endsWith(".csv")) {
                        logger.info("New file detected: {}", filename);
                        pipeline.processFile(filePath);
                    }
                }
            }
            key.reset();
        }
    }
}

