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
            int lottoWinningNumbers = ConsoleReader.readLottoNumber();
            assertThat(lottoWinningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Override
    public void runMain() {
    }
}