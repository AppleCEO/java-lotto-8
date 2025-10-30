package lotto;

public class ConsoleOutput {
    public static void printMoneyInputGuide() {
        System.out.println(Message.PROMPT_BUY_MONEY.get());
    }

    public static void printLottoAmount(int money) {
        System.out.printf(Message.RESULT_BUY_LOTTO_AMOUNT.get(), money/1000);
    }

    public static void printWinningNumberInputGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
