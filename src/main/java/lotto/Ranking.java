package lotto;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private final int matchCount;
    private final boolean matchBonus;

    Ranking(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public long getPrizeMoney() {
        return switch (this) {
            case FIRST -> 2_000_000_000L;
            case SECOND -> 30_000_000L;
            case THIRD -> 1_500_000L;
            case FOURTH -> 50_000L;
            case FIFTH -> 5_000L;
            case NONE -> 0L;
        };
    }

    public static Ranking valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || matchBonus)
                .findFirst()
                .orElse(NONE);
    }
}
