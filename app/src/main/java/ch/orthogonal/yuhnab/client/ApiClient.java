package ch.orthogonal.yuhnab.client;

import ch.orthogonal.yuhnab.config.ServiceConfig;

import java.util.List;
import java.util.Map;

public interface ApiClient {
    void send(List<Map<String, Object>> parsedData, ServiceConfig config);
}