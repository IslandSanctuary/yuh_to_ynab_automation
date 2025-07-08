package ch.orthogonal.yuhnab.command;

import ch.orthogonal.yuhnab.client.ApiClient;
import ch.orthogonal.yuhnab.client.YnabTransactionsClient;
import ch.orthogonal.yuhnab.config.ServiceConfig;
import ch.orthogonal.yuhnab.parser.CsvParser;
import ch.orthogonal.yuhnab.parser.YuhCsvParser;
import ch.orthogonal.yuhnab.service.CsvFolderMonitor;
import ch.orthogonal.yuhnab.service.MonitoringService;
import ch.orthogonal.yuhnab.service.TransactionPipeline;
import ch.orthogonal.yuhnab.util.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MonitorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(MonitorCommand.class);
    private final Path folderPath;

    public MonitorCommand(Path folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public void execute() throws CommandException {
        try {
            if (!Files.exists(folderPath) || !Files.isDirectory(folderPath)) {
                throw new CommandException("Invalid folder path: " + folderPath);
            }

            Path home = Paths.get(System.getProperty("user.home"));
            Path configPath = home.resolve(".config").resolve("yuhnab").resolve("config.json");

            if (!Files.exists(configPath)) {
                throw new CommandException("Configuration not found. Run 'yuhnab setup' first.");
            }
            logger.info("Starting monitoring of folder: {}", folderPath);
            ServiceConfig config = JsonUtils.getInstanceFromJson(configPath, ServiceConfig.class);
            CsvParser parser = new YuhCsvParser();
            ApiClient apiClient = new YnabTransactionsClient();
            TransactionPipeline pipeline = new TransactionPipeline(parser, apiClient, config);
            CsvFolderMonitor monitor = new CsvFolderMonitor(pipeline, folderPath);
            MonitoringService service = new MonitoringService(monitor);
            service.start();

        } catch (Exception e) {
            throw new CommandException("Failed to start monitoring", e);
        }
    }

    @Override
    public String getDescription() {
        return "Monitor folder for CSV files (default: home directory)";
    }
}
