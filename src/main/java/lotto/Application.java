package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static int money;
    private static List<Lotto> lottos;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void main(String[] args) {
        readFromConsole();
        lottos = LottoFactory.createLottos(money);
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
                .collect(Collectors.groupingBy(
                        ranking -> ranking,         // Map의 Key: Ranking enum 상수 (FIFTH, FOURTH 등)
                        Collectors.counting()       // Map의 Value: 해당 Ranking 상수의 개수 (Long)
                ));
        ConsoleOutput.printResult(result);
    }
}
