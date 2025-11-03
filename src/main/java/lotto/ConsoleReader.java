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

    public static Lotto readWinningLotto() {
        while (true) {
            String input = Console.readLine();
            try {
                return parseWinningLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto parseWinningLotto(String input) {
        try {
            List<Integer> winningNumbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER.getMessage());
        }
    }

    public static Integer readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
