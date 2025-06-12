package finalmission.domain;

import lombok.Getter;

@Getter
public class Guest {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 14;
    private final int size;

    public Guest(final int size) {
        validateSize(size);
        this.size = size;
    }

    private void validateSize(final int size) {
        if (isNotAllowedSize(size)) {
            throw new IllegalArgumentException("인원 수는 1명 이상, 14명 이하여야 합니다.");
        }
    }

    private boolean isNotAllowedSize(final int size) {
        return size < MIN_SIZE || size > MAX_SIZE;
    }
}
