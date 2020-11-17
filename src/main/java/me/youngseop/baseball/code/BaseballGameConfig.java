package me.youngseop.baseball.code;

public enum BaseballGameConfig {
    NUMBER3(3, 100, 999);

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

    public int getEnd() {
        return end;
    }

    public int getNextInt() {
        return end - start + 1;
    }


}
