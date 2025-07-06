package ch.orthogonal.yuhnab.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CsvFolderMonitor {
    private static final Logger logger = LogManager.getLogger(CsvFolderMonitor.class);
    private final TransactionPipeline pipeline;
    private final Path monitoredFolder;

    public CsvFolderMonitor(TransactionPipeline pipeline, Path monitoredFolder) {
        this.pipeline = pipeline;
        this.monitoredFolder = monitoredFolder;
    }


    public void run() throws IOException, InterruptedException {
        AtomicBoolean isRunning = new AtomicBoolean(false);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        monitoredFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        logger.info("Watching folder: {}", monitoredFolder.toAbsolutePath());
        logger.info("Press Ctrl+C to exit");
        isRunning.set(true);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down...");
            isRunning.set(false);
            try {
                watchService.close();
            } catch (IOException ignored) {
            }
        }));


        while (isRunning.get()) {
            WatchKey key;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                logger.warn(e.getMessage());
                continue;
            }
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

