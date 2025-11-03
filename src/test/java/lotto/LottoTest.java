package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_보너스_번호로_등수를_반환한다_1등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Ranking ranking = lotto.checkRanking(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    void 당첨_번호와_보너스_번호로_등수를_반환한다_2등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Ranking ranking = lotto.checkRanking(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    void 당첨_번호와_보너스_번호로_등수를_반환한다_3등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Ranking ranking = lotto.checkRanking(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    void 당첨_번호와_보너스_번호로_등수를_반환한다_4등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 7));
        Ranking ranking = lotto.checkRanking(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(ranking).isEqualTo(Ranking.FOURTH);
    }

    @Test
    void 당첨_번호와_보너스_번호로_등수를_반환한다_5등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 8, 10));
        Ranking ranking = lotto.checkRanking(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(ranking).isEqualTo(Ranking.FIFTH);
    }

    @Test
    void 당첨_번호와_보너스_번호로_등수를_반환한다_미당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 7, 9, 8, 10));
        Ranking ranking = lotto.checkRanking(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(ranking).isEqualTo(Ranking.NONE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위를_벗어나는_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
