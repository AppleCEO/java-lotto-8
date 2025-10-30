package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = ConsoleReader.readMoney();
        List<Integer> winningNumbers = ConsoleReader.readWinningNumbers();
    }
}
