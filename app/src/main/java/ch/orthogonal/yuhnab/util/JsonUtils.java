package ch.orthogonal.yuhnab.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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
            logger.error("Couldn't read {}", e.getMessage());
            return null;
        }
    }

    public static <T> List<T> getInstancesFromJson(Path path, Class<T> type) {
        Gson gson = new Gson();
        try {
            String json = Files.readString(path);
            logger.info("Reading config list from {}", path);

            // Create a TypeToken for List<T> to handle generic type erasure
            Type listType = TypeToken.getParameterized(List.class, type).getType();
            List<T> result = gson.fromJson(json, listType);

            // Return empty list if JSON was null or empty
            return result != null ? result : new ArrayList<>();

        } catch (IOException e) {
            logger.error("Couldn't read list {}", e.getMessage());
            return new ArrayList<>();
        } catch (JsonSyntaxException e) {
            logger.error("Invalid JSON syntax in file {}: {}", path, e.getMessage());
            return new ArrayList<>();
        }
    }
}
