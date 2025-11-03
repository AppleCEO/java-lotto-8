package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultService {
    public static void printResult(List<Lotto> lottos, LottoInput lottoInput) {
        Map<Ranking, Long> result = getRanking(lottos, lottoInput);
        double profitRatio = getProfitRatio(result, lottoInput);
        ConsoleOutput.printResult(result, profitRatio * 100);
    }

    private static Map<Ranking, Long> getRanking(List<Lotto> lottos, LottoInput lottoInput) {
        Map<Ranking, Long> result = lottos.stream()
                .map(lotto -> lotto.checkRanking(lottoInput.getWinningLotto(), lottoInput.getMoney()))
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.counting()));
        return result;
    }

    private static double getProfitRatio(Map<Ranking, Long> result, LottoInput lottoInput) {
        long totalPrizeMoney = result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return (double) totalPrizeMoney / lottoInput.getMoney();
    }
}
