package ch.orthogonal.yuhnab.client;

import ch.orthogonal.yuhnab.config.ServiceConfig;
import ch.orthogonal.yuhnab.parser.SimpleTransaction;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class TransactionsApi {
    private static final String BASE_URL = "https://api.ynab.com/v1";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();
    private final String budgetId;
    private final String apiToken;
    private final Gson gson = new Gson();

    public TransactionsApi(ServiceConfig config) {
        this.budgetId = Objects.requireNonNull(config.getBudgetId(), "Budget ID cannot be null");
        this.apiToken = Objects.requireNonNull(config.getApiToken(), "API Token cannot be null");
    }

    public String sendTransactions(List<SimpleTransaction> transactions) throws IOException {
        String json = gson.toJson(Collections.singletonMap("transactions", transactions));
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder().url(BASE_URL + "/budgets/" + budgetId + "/transactions").addHeader("accept", "application/json").addHeader("Authorization", "Bearer " + apiToken).addHeader("Content-Type", "application/json").post(body).build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            if (!response.isSuccessful()) {
                throw new IOException("API request failed: " + response.code() + " " + response.message() + "\n" + responseBody);
            }
            return responseBody;
        }
    }
}
