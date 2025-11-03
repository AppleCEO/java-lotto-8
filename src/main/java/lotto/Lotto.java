package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        ConsoleOutput.printNumbers(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateNoDuplicates(numbers);
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    public Ranking checkRanking(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return Ranking.valueOf(matchCount, numbers.contains(bonusNumber));
    }
}
