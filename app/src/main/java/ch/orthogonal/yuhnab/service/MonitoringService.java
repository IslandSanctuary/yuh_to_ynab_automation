package ch.orthogonal.yuhnab.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MonitoringService {
    private static final Logger logger = LogManager.getLogger(MonitoringService.class);
    private final CsvFolderMonitor monitor;

    public MonitoringService(CsvFolderMonitor monitor) {
        this.monitor = monitor;
    }

    public void start() {
        try {
            monitor.run();
        } catch (IOException | InterruptedException e) {
            logger.error(e);
        }
    }
}
