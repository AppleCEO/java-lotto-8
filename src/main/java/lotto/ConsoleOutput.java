package lotto;

public class ConsoleOutput {
    public static void printMoneyInputGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoAmount(int money) {
        System.out.println(money/1000 + "개를 구매했습니다.");
    }
}
