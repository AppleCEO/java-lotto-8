package lotto;

public enum LottoConfig {
    MIN_NUMBER(1),             // 로또 번호의 최소값
    MAX_NUMBER(45),            // 로또 번호의 최대값
    LOTTO_PRICE(1000),         // 로또 1장의 가격
    LOTTO_NUMBERS_COUNT(6);    // 로또 번호의 개수

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}