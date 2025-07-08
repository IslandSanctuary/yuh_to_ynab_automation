package ch.orthogonal.yuhnab;

import ch.orthogonal.yuhnab.command.Command;
import ch.orthogonal.yuhnab.command.CommandException;
import ch.orthogonal.yuhnab.command.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        try {
            Command command = CommandFactory.createCommand(args);
            command.execute();
        } catch (CommandException e) {
            logger.error("Command failed: {}", e.getMessage());
            if (e.getCause() != null) {
                logger.debug("Caused by:", e.getCause());
            }
            System.err.println("Error: " + e.getMessage());
            CommandFactory.printUsage();
            System.exit(1);
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            System.err.println("Unexpected error occurred. Check logs for details.");
            System.exit(1);
        }

    }

}

