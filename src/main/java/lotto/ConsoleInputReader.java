package lotto;

import java.util.List;

public class ConsoleInputReader {
    public static LottoInput readAllInputs() {
        int money = readMoneyInput();
        Lotto winningLotto = readWinningLottoInput();
        int bonusNumber = readBonusNumberInput();

        return new LottoInput(money, winningLotto, bonusNumber);
    }

    private static int readMoneyInput() {
        ConsoleOutput.printMoneyInputGuide();
        return ConsoleReader.readMoney();
    }

    private static Lotto readWinningLottoInput() {
        ConsoleOutput.printWinningNumberInputGuide();
        return ConsoleReader.readWinningLotto();
    }

    private static int readBonusNumberInput() {
        ConsoleOutput.printBonusNumberInputGuide();
        return ConsoleReader.readBonusNumber();
    }
}
