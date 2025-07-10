package ch.orthogonal.yuhnab.command;

import ch.orthogonal.yuhnab.config.ServiceConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.UUID;

public class SetupCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SetupCommand.class);
    private final String folderPath;

    public SetupCommand(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public void execute() throws CommandException {
        try {
            Path home = Paths.get(System.getProperty("user.home"));
            Path configDir = home.resolve(".config").resolve("yuhnab");
            Path configPath = configDir.resolve("config.json");

            // Create config directory if it doesn't exist
            Files.createDirectories(configDir);

            if (Files.exists(configPath)) {
                throw new CommandException("Configuration already exists. Use 'yuhnab delete' to remove it first.");
            }

            // Interactive setup logic here
            logger.info("Setting up yuhnab configuration...");

            // Generate unique service ID
            String serviceId = UUID.randomUUID().toString();

            // Get user input for configuration
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to yuhnab setup!");
            System.out.println("Please provide the following information:");

            System.out.print("Enter API Token: ");
            String apiToken = scanner.nextLine().trim();

            System.out.print("Enter Budget ID: ");
            String budgetId = scanner.nextLine().trim();

            System.out.print("Enter Account ID: ");
            String accountId = scanner.nextLine().trim();

            // Validate required inputs
            if (apiToken.isEmpty() || budgetId.isEmpty() || accountId.isEmpty()) {
                throw new CommandException("All fields are required. Setup cancelled.");
            }

            if (folderPath == null || folderPath.trim().isEmpty()) {
                throw new CommandException("Folder path is required. Please provide it as an argument to the setup command.");
            }

            // Create configuration
            ServiceConfig config = new ServiceConfig(serviceId, apiToken, budgetId, accountId, folderPath);

            // Save configuration to JSON file
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonConfig = gson.toJson(config);

            Files.writeString(configPath, jsonConfig);

            logger.info("Configuration saved successfully to {}", configPath);
            System.out.println("Setup completed successfully!");
            System.out.println("Service ID: " + serviceId);
            System.out.println("Configuration saved to: " + configPath);

        } catch (IOException e) {
            throw new CommandException("Failed to create configuration", e);
        }
    }

    @Override
    public String getDescription() {
        return "Create new configuration and register as system service";
    }
}