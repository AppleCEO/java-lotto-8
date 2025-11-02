package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static int money;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void main(String[] args) {
        readFromConsole();
        List<Lotto> lottos = LottoFactory.createLottos(money);
        printResult(lottos);
    }

    private static void readFromConsole() {
        money = ConsoleReader.readMoney();
        winningNumbers = ConsoleReader.readWinningNumbers();
        bonusNumber = ConsoleReader.readBonusNumber();
    }

    private static void printResult(List<Lotto> lottos) {
        Map<Ranking, Long> result = lottos.stream()
                .map(lotto -> lotto.checkRanking(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.counting()));
        ConsoleOutput.printResult(result);
    }
}
