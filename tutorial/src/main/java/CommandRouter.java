import java.util.*;

final class CommandRouter {
    private final Map<String, Command> commands = Collections.emptyMap();

    Command.Status route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);          //입력줄을 ' '단위로 구분한 첫번째 위치는 명령어
        Command command = commands.get(commandKey);
        if (command == null) {
            return invalidCommand(input);
        }

        Command.Status status =
                command.handleInput(splitInput.subList(1, splitInput.size()));
        if (status == Command.Status.INVALID) {
            System.out.println(commandKey + ": invalid arguments");
        }
        return status;
    }

    private Command.Status invalidCommand(String input) {
        System.out.println(
                String.format("couldn't understand \"%s\". please try again.", input));
        return Command.Status.INVALID;
    }

    // 띄워쓴 기준으로 split
    private static List<String> split(String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}