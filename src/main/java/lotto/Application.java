package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = ConsoleInputReader.readAllInputs();
        List<Lotto> lottos = LottoFactory.createLottos(lottoInput.getMoney());
        LottoResultService.printResult(lottos, lottoInput);
    }
}
