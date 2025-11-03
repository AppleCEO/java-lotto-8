package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleReader {
    public static int readMoney() {
        while (true) {
            String input = Console.readLine();
            try {
                return parseMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(Message.ERROR_INVALID_MONEY.get());
            }
        }
    }

    private static int parseMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 == 0) {
                return money;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
