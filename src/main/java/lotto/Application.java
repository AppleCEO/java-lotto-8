package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = ConsoleReader.readMoney();
        LottoFactory.createLottos(money);
        List<Integer> winningNumbers = ConsoleReader.readWinningNumbers();
    }
}
