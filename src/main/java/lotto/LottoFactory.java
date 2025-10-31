package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static List<Lotto> createLottos(Integer money) {
        int amount = money/1000;
        ConsoleOutput.printLottoAmount(amount);
        return IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }
}
