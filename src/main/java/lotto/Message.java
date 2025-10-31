package lotto;

public enum Message {
    PROMPT_BUY_MONEY("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    PROMPT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    RESULT_BUY_LOTTO_AMOUNT("\n%d개를 구매했습니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
