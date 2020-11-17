package me.youngseop.baseball.code;

public enum BaseballGameConfig {
    THREE_DIGITS(3, 123, 987),
    FOUR_DIGITS(4, 1234, 9876);

    private final int size;
    private final int start;
    private final int end;

    BaseballGameConfig(int size, int start, int end) {
        this.size = size;
        this.start = start;
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getBound() {
        return end - start + 1;
    }


}
