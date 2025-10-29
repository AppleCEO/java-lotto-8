package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class ConsoleReader {
    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
