package ch.orthogonal.yuhnab.config;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ServiceConfig {
    private final static Logger logger = LogManager.getLogger(ServiceConfig.class);
    public String serviceId;
    public String apiToken;
    public String budgetId;
    public String accountId;
    public String folderPath;

    public ServiceConfig(String serviceId, String apiToken, String budgetId, String accountId, String folderPath) {
        this.serviceId = serviceId;
        this.apiToken = apiToken;
        this.budgetId = budgetId;
        this.accountId = accountId;
        this.folderPath = folderPath;
    }


    private void writeJsonFile(Object obj, Path path) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, json.getBytes(), StandardOpenOption.CREATE);
            logger.info("Config file written to {}", path.toString());
        } catch (IOException e) {
            logger.error("Couldn't write json to {} {}", path.toAbsolutePath(), e);
        }
    }
    public static ServiceConfig fromJson(Path path) {
        Gson gson = new Gson();
        try {
            String json = Files.readString(path);
            logger.info("Reading config from {}", path);
            return gson.fromJson(json, ServiceConfig.class);

        } catch (IOException e) {
            logger.error("Couldn't read configuration {}", e.getMessage());
            return null;
        }
    }

    public void save(Path configFolder) {
        writeJsonFile(this, configFolder);
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }
}
