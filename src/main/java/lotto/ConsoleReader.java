package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleReader {
    public static int readMoney() {
        ConsoleOutput.printMoneyInputGuide();
        String input = Console.readLine();
        int money = Integer.parseInt(input);
        ConsoleOutput.printLottoAmount(money);
        return money;
    }

    public static List<Integer> readWinningNumber() {
        ConsoleOutput.printWinningNumberInputGuide();
        String input = Console.readLine();
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }
}
