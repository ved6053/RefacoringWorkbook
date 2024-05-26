package com.refacoring.workbook.matcher;

public class Matcher {
    public Matcher() {}
    public boolean match(int[] expected, int[] actual,
                         int clipLimit, int delta)
    {

        makeLargeUpToClipLimit(actual, clipLimit);

        // Check for length differences
        if (actual.length != expected.length)
            return false;

        // Check that each entry within expected +/- delta
        for (int i = 0; i < actual.length; i++)
            if (Math.abs(expected[i] - actual[i]) > delta)
                return false;

        return true;
    }

    private void makeLargeUpToClipLimit(int []actual, int clipLimit){
        for (int i = 0; i < actual.length; i++)
            if (actual[i] > clipLimit)
                actual[i] = clipLimit;
    }
}