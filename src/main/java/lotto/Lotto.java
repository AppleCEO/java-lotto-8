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
        validateNumberRange(numbers);
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public Ranking checkRanking(Lotto winningLotto, int bonusNumber) {
        return Ranking.valueOf(countMatchingNumbers(winningLotto), contains(bonusNumber));
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) this.numbers.stream() // 1. 현재 로또 번호 목록을 스트림으로 만듭니다.
                .filter(otherLotto::contains) // 2. 각 번호가 otherLotto에 포함되는지 필터링합니다.
                .count();
    }
}
