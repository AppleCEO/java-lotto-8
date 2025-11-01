package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int money = ConsoleReader.readMoney();
        List<Lotto> lottos = LottoFactory.createLottos(money);
        List<Integer> winningNumbers = ConsoleReader.readWinningNumbers();
        int bonusNumber = ConsoleReader.readBonusNumber();
        List<Ranking> rankings = lottos.stream()
                .map(lotto -> lotto.checkRanking(winningNumbers, bonusNumber))
                .toList();
        ConsoleOutput.printResult();
    }
}
