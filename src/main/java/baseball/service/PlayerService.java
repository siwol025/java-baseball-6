package baseball.service;

import baseball.domain.InputValidator;
import baseball.util.GameCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerService {
    public String inputGuessNumber() {
        String input = Console.readLine();
        InputValidator.validateDigitCount(input);

        return input;
    }

    public List<Integer> assignPlayerNums(String guessNumber) {
        List<Integer> playerNums = guessNumber.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());

        return playerNums;
    }

    public GameCommand inputCommand() {
        String inputCommand = Console.readLine();
        GameCommand gameCommand = GameCommand.findByInputCommand(inputCommand);
        InputValidator.validateCommand(gameCommand);

        return gameCommand;
    }
}
