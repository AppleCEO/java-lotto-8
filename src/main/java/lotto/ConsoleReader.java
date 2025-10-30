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
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumber() {
        String input = Console.readLine();
        List<Integer> numbers = Arrays.stream(input.split(",")) // 1. 쉼표로 자르기 -> ["1", "2", "3", ...]
                .map(Integer::parseInt)      // 2. 각 문자열을 정수로 변환 -> [1, 2, 3, ...]
                .collect(Collectors.toList());
        return numbers;
    }
}
