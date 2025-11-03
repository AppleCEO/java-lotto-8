package lotto;

public enum Message {
    PROMPT_BUY_MONEY("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    PROMPT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    RESULT_BUY_LOTTO_AMOUNT("\n%d개를 구매했습니다.\n"),
    RESULT_TITLE("\n당첨 통계\n---"),
    RESULT_RANKING_FIFTH_AMOUNT("3개 일치 (5,000원) - %d개\n"),
    RESULT_RANKING_FOURTH_AMOUNT("4개 일치 (50,000원) - %d개\n"),
    RESULT_RANKING_THIRD_AMOUNT("5개 일치 (1,500,000원) - %d개\n"),
    RESULT_RANKING_SECOND_AMOUNT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    RESULT_RANKING_FIRST_AMOUNT("6개 일치 (2,000,000,000원) - %d개\n"),
    RESULT_PROFIT_RATIO("총 수익률은 %.1f%%입니다.\n");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
