package lotto;

import java.util.List;

public class LottoInput {
    private final int money;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoInput(int money, List<Integer> winningNumbers, int bonusNumber) {
        this.money = money;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMoney() {
        return money;
    }
}
