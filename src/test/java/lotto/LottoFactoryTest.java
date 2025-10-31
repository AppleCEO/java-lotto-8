package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {
    @Test
    void 로또_생성_테스트() {
        List<Lotto> lottos = LottoFactory.createLottos(3);
        assertThat(lottos.size()).isEqualTo(3);
    }
}