package lotto;

public class Application {
    public static void main(String[] args) {
        int money = ConsoleReader.readMoney();
        ConsoleOutput.printLottoAmount(money);
    }
}
