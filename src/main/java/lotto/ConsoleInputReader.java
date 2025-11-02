package lotto;

import java.util.List;

public class ConsoleInputReader {
    public static LottoInput readAllInputs() {
        int money = readMoneyInput();
        List<Integer> winningNumbers = readWinningNumbersInput();
        int bonusNumber = readBonusNumberInput();

        return new LottoInput(money, winningNumbers, bonusNumber);
    }

    private static int readMoneyInput() {
        ConsoleOutput.printMoneyInputGuide();
        return ConsoleReader.readMoney();
    }

    private static List<Integer> readWinningNumbersInput() {
        ConsoleOutput.printWinningNumberInputGuide();
        return ConsoleReader.readWinningNumbers();
    }

    private static int readBonusNumberInput() {
        ConsoleOutput.printBonusNumberInputGuide();
        return ConsoleReader.readBonusNumber();
    }
}
