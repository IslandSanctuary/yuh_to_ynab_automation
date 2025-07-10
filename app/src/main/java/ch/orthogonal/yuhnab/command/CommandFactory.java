package ch.orthogonal.yuhnab.command;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandFactory {
    public static Command createCommand(String[] args) throws CommandException {
        if (args.length == 0) {
            // Default: monitor home directory
            return new MonitorCommand(Paths.get(System.getProperty("user.home")));
        }

        String command = args[0].toLowerCase();

        // Provide the correct command class depending on the arguments
        switch (command) {
            case "setup":
                if (args.length < 2) {
                    throw new CommandException("Setup command requires a folder path. Usage: yuhnab setup <folder_path>");
                }
                try {
                    Path folderPath = Paths.get(args[1]);
                    return new SetupCommand(folderPath.toString());
                } catch (InvalidPathException e) {
                    throw new CommandException("Invalid folder path: " + args[1]);
                }
            default:
                // Treat as folder path for monitoring
                try {
                    Path folderPath = Paths.get(args[0]);
                    return new MonitorCommand(folderPath);
                } catch (InvalidPathException e) {
                    throw new CommandException("Invalid command or path: " + args[0]);
                }
        }
    }

    public static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  yuhnab [folder_path]  - Monitor folder for CSV files");
        System.out.println("  yuhnab setup          - Create configuration and register service");
        System.out.println("  yuhnab list           - List existing configurations");
        System.out.println("  yuhnab delete <id>    - Delete configuration by ID");
    }
}