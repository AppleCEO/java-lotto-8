package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static int money;
    private static List<Lotto> lottos;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void main(String[] args) {
        readFromConsole();
        lottos = LottoFactory.createLottos(money);
        List<Ranking> rankings = lottos.stream()
                .map(lotto -> lotto.checkRanking(winningNumbers, bonusNumber))
                .toList();
        ConsoleOutput.printResult();
    }

    private static void readFromConsole() {
        money = ConsoleReader.readMoney();
        winningNumbers = ConsoleReader.readWinningNumbers();
        bonusNumber = ConsoleReader.readBonusNumber();
    }
}
