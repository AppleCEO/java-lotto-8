package lotto;

import java.util.List;

public class LottoInput {
    private final int money;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoInput(int money, Lotto winningLotto, int bonusNumber) {
        this.money = money;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMoney() {
        return money;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
