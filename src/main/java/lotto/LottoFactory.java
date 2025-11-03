package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static List<Lotto> createLottos(Integer money) {
        int amount = money/LottoConfig.LOTTO_PRICE.getValue();
        ConsoleOutput.printLottoAmount(amount);
        return IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(
                            LottoConfig.MIN_NUMBER.getValue(),
                            LottoConfig.MAX_NUMBER.getValue(),
                            LottoConfig.LOTTO_NUMBERS_COUNT.getValue()
                        )
                ))
                .collect(Collectors.toList());
    }
}
