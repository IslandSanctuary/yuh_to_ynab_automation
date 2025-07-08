package ch.orthogonal.yuhnab.command;

public interface Command {
    void execute() throws CommandException;
    String getDescription();
}
