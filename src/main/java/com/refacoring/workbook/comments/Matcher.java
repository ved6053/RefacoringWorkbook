package com.refacoring.workbook.comments;

public class Matcher {
    public Matcher() {}
    public boolean match(int[] expected, int[] actual,
                         int clipLimit, int delta)
    {

        keepLargeUpToClipLimit(actual, clipLimit);
        return isLengthOfActualEqualToExpected(actual.length , expected.length)
                && isAbsDifferenceLessOrEqualToDeltaForEach(actual, expected, delta);
    }

    private void keepLargeUpToClipLimit(int []actual, int clipLimit){
        for (int i = 0; i < actual.length; i++)
            if (actual[i] > clipLimit)
                actual[i] = clipLimit;
    }
    private boolean isLengthOfActualEqualToExpected(int actualLength, int expectedLength) {
        return actualLength==expectedLength;
    }

    private boolean isAbsDifferenceLessOrEqualToDeltaForEach(int[] actual, int[] expected, int delta) {
        for (int i = 0; i < actual.length; i++)
            if (Math.abs(expected[i] - actual[i]) > delta)
                return false;
        return true;
    }
}