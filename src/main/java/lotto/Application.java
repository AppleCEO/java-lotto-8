package lotto;

public class Application {
    public static void main(String[] args) {
        int money = ConsoleReader.readMoney();
        System.out.println(money/1000 + "개를 구매했습니다.");
    }
}
