package lotto;

public enum ErrorMessage {
    NOT_MULTIPLE_OF_1000("금액은 천원 단위로 입력해주세요."),
    INVALID_MONEY("금액은 숫자만 입력해주세요."),
    INVALID_NUMBER_RANGE("로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호에 중복된 숫자가 있습니다."),
    INVALID_CHARACTER("당첨 번호는 1에서 45 사이의 숫자 6개를 ,로 구분하여 입력해야 합니다.(예: 1,2,3,4,5,6)");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    // [ERROR] 접두사를 자동으로 붙여 반환합니다.
    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}