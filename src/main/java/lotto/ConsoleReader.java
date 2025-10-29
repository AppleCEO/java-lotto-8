package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class ConsoleReader {
    public static int readMoney() {
        ConsoleOutput.printMoneyInputGuide();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
