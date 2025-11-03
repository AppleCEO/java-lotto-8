package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleReaderTest extends NsTest {
    @Test
    void 구입_금액_입력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            int money = ConsoleReader.readMoney();
            assertThat(money).isEqualTo(8000);
        });
    }

    @Test
    void 로또_당첨번호_입력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            int matchingNumbers = winningLotto.countMatchingNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            assertThat(matchingNumbers).isEqualTo(6);
        });
    }

    @Test
    void 로또_당첨번호에_중복된_숫자가_있는_경우_에러_메시지_출력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,5", "10,20,30,40,41,42", "7");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            assertThat(output()).contains(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        });
    }

    @Test
    void 로또_당첨번호에_범위를_벗어난_숫자가_있을_시_에러_미시지_출력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,46", "10,20,30,40,41,42", "7");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            assertThat(output()).contains(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        });

        assertSimpleTest(() -> {
            run("8000", "0,2,3,4,5,6", "10,20,30,40,41,42", "7");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            assertThat(output()).contains(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        });
    }

    @Test
    void 로또_당첨번호에_숫자가_아닌_문자_입력_시_에러_미시지_출력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,a", "10,20,30,40,41,42", "7");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            assertThat(output()).contains(ErrorMessage.INVALID_CHARACTER.getMessage());
        });
    }

    @Test
    void 보너스_번호_입력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            int bonusNumber = ConsoleReader.readBonusNumber();
            assertThat(bonusNumber).isEqualTo(7);
        });
    }

    @Test
    void 보너스_번호에_범외를_벗어난_숫자_입력_시_에러_메시지_출력_테스트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "46", "8");
            int money = ConsoleReader.readMoney();
            Lotto winningLotto = ConsoleReader.readWinningLotto();
            int bonusNumber = ConsoleReader.readBonusNumber();
            assertThat(output()).contains(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        });
    }

    @Override
    public void runMain() {
    }
}