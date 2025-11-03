package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleReader {
    public static int readMoney() {
        while (true) {
            String input = Console.readLine();
            try {
                return parseMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 == 0) {
                return money;
            }
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_1000.getMessage());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    public static List<Integer> readWinningNumbers() {
        while (true) {
            String input = Console.readLine();
            try {
                List<Integer> winningNumbers = parseWinningNumbers(input);
                validateNoDuplicates(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateNoDuplicates(winningNumbers);
        return winningNumbers;
    }

    public static Integer readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }
}
