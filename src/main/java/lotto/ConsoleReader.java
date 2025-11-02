package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleReader {
    public static int readMoney() {
        ConsoleOutput.printMoneyInputGuide();
        while (true) {
            String input = Console.readLine();
            try {
                int money = Integer.parseInt(input);
                return money;
            } catch (NumberFormatException e) {
                System.out.println(Message.ERROR_INVALID_MONEY.get());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        ConsoleOutput.printWinningNumberInputGuide();
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer readBonusNumber() {
        ConsoleOutput.printBonusNumberInputGuide();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
