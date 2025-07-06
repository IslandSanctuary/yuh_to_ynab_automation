package ch.orthogonal.yuhnab.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

import static ch.orthogonal.yuhnab.util.JsonUtils.writeInstanceToJson;

public class ServiceConfig {
    private final static Logger logger = LogManager.getLogger(ServiceConfig.class);
    public String serviceId;
    public String apiToken;
    public String budgetId;
    public String accountId;
    public String folderPath;

    public ServiceConfig() {
        this.serviceId = "";
        this.apiToken = "";
        this.budgetId = "";
        this.accountId = "";
        this.folderPath = "";
    }

    public ServiceConfig(String serviceId, String apiToken, String budgetId, String accountId, String folderPath) {
        this.serviceId = serviceId;
        this.apiToken = apiToken;
        this.budgetId = budgetId;
        this.accountId = accountId;
        this.folderPath = folderPath;
    }


    public void save(Path configFolder) {
        writeInstanceToJson(this, configFolder);
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
