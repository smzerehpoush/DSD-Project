package me.mahdiyar;


public class IntRange {

    public int min;
    public int max;

    public IntRange() {
        min = 0;
        max = 0;
    }

    public IntRange(int i, int j) {
        min = i;
        max = j;
    }

    public void setOrder() {
        if (min > max) {
            int i = min;
            min = max;
            max = i;
        }
    }

    public void union(IntRange intrange) {
        min = intrange.min >= min ? min : intrange.min;
        max = intrange.max <= max ? max : intrange.max;
    }
}
