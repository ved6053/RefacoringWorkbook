package com.refacoring.workbook.matcher;

public class Matcher {
    public Matcher() {}
    public boolean match(int[] expected, int[] actual,
                         int clipLimit, int delta)
    {

        makeLargeUpToClipLimit(actual, clipLimit);


        return isLengthOfActualEqualToExpected(actual.length , expected.length)?isAbsDifferenceLessOrEqualToDelta(actual, expected, delta):false;
    }

    private void makeLargeUpToClipLimit(int []actual, int clipLimit){
        for (int i = 0; i < actual.length; i++)
            if (actual[i] > clipLimit)
                actual[i] = clipLimit;
    }
    private boolean isLengthOfActualEqualToExpected(int actualLength, int expectedLength) {
        return actualLength==expectedLength;
    }

    private boolean isAbsDifferenceLessOrEqualToDelta(int[] actual, int[] expected, int delta) {
        for (int i = 0; i < actual.length; i++)
            if (Math.abs(expected[i] - actual[i]) > delta)
                return false;

        return true;
    }
}