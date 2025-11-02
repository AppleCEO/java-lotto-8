package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleOutput {
    public static void printMoneyInputGuide() {
        System.out.println(Message.PROMPT_BUY_MONEY.get());
    }

    public static void printLottoAmount(int amount) {
        System.out.printf(Message.RESULT_BUY_LOTTO_AMOUNT.get(), amount);
    }

    public static void printWinningNumberInputGuide() {
        System.out.println(Message.PROMPT_WINNING_NUMBERS.get());
    }

    public static void printBonusNumberInputGuide() {
        System.out.println(Message.PROMPT_BONUS_NUMBERS.get());
    }

    public static void printNumbers(List<Integer> lottoNumbers) {
        List<String> numberStrings = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        String result = String.join(", ", numberStrings);
        System.out.println("[" + result + "]");
    }

    public static void printResult(Map<Ranking, Long> result, double profitRatio) {
        System.out.println(Message.RESULT_TITLE.get());
        printRanking(result);
        System.out.printf(Message.RESULT_PROFIT_RATIO.get(), profitRatio);
    }

    private static void printRanking(Map<Ranking, Long> result) {
        System.out.printf(Message.RESULT_RANKING_FIFTH_AMOUNT.get(), result.getOrDefault(Ranking.FIFTH, 0L));
        System.out.printf(Message.RESULT_RANKING_FOURTH_AMOUNT.get(), result.getOrDefault(Ranking.FOURTH, 0L));
        System.out.printf(Message.RESULT_RANKING_THIRD_AMOUNT.get(), result.getOrDefault(Ranking.THIRD, 0L));
        System.out.printf(Message.RESULT_RANKING_SECOND_AMOUNT.get(), result.getOrDefault(Ranking.SECOND, 0L));
        System.out.printf(Message.RESULT_RANKING_FIRST_AMOUNT.get(), result.getOrDefault(Ranking.FIRST, 0L));
    }
}
