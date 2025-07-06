package ch.orthogonal.yuhnab.util;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class JsonUtils {
    private static final Logger logger = LogManager.getLogger(JsonUtils.class);

    public static <T> void writeInstanceToJson(T obj, Path path) {
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

    public static <T> T getInstanceFromJson(Path path, Class<T> type) {
        Gson gson = new Gson();
        try {
            String json = Files.readString(path);
            logger.info("Reading config from {}", path);
            return gson.fromJson(json, type);

        } catch (IOException e) {
            logger.error("Couldn't read configuration {}", e.getMessage());
            return null;
        }
    }
}
