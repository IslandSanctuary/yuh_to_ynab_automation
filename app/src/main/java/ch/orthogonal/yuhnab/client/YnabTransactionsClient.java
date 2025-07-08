package ch.orthogonal.yuhnab.client;

import ch.orthogonal.yuhnab.config.ServiceConfig;
import ch.orthogonal.yuhnab.parser.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class YnabTransactionsClient implements ApiClient {
    // TODO: Move to environment variable
    public final static Logger logger = LogManager.getLogger(YnabTransactionsClient.class);

    @Override
    public void send(List<Map<String, Object>> rawTransactions, ServiceConfig config) {
        // Convert your incoming data
        List<Transaction> transactions = rawTransactions.stream()
                .map(map -> new Transaction(config.getAccountId(),
                        map.get("Date").toString(),
                        (int) map.get("Amount"),
                        map.get("Payee").toString(),
                        "test"
                )).toList();
        TransactionsApi api = new TransactionsApi(config);
        try {
            logger.info("Successfully sent transactions with response {}", api.sendTransactions(transactions));

        } catch (IOException e) {
            logger.error("Failed to send transactions {}", e.getMessage());
        }
    }

}

