package ch.orthogonal.yuhnab;

import ch.orthogonal.yuhnab.client.ApiClient;
import ch.orthogonal.yuhnab.client.YnabTransactionsClient;
import ch.orthogonal.yuhnab.config.ServiceConfig;
import ch.orthogonal.yuhnab.parser.CsvParser;
import ch.orthogonal.yuhnab.parser.YuhCsvParser;
import ch.orthogonal.yuhnab.service.CsvFolderMonitor;
import ch.orthogonal.yuhnab.service.MonitoringService;
import ch.orthogonal.yuhnab.service.TransactionPipeline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws IOException, InterruptedException {
        Path home = Paths.get(System.getProperty("user.home"));
        Path folder = Paths.get(args.length > 0 ? args[0] : System.getProperty("user.home"));
        Path configPath = home.resolve(".config").resolve("yuhnab").resolve("config.json");
        ServiceConfig config = ServiceConfig.fromJson(configPath);
        CsvParser parser = new YuhCsvParser();
        ApiClient apiClient = new YnabTransactionsClient();
        TransactionPipeline pipeline = new TransactionPipeline(parser, apiClient, config);
        CsvFolderMonitor monitor = new CsvFolderMonitor(pipeline, folder);
        MonitoringService service = new MonitoringService(monitor);
        service.start();
    }

}

