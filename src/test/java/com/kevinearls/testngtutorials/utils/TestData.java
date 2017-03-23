package com.kevinearls.testngtutorials.utils;

import java.util.List;

/**
 * Created by kearls on 23/03/2017.
 */
public class TestData {
    Integer minimum;
    Integer maximum;
    List<Integer> expectedResultValues;

    public TestData(Integer minimum, Integer maximum, List<Integer> expectedValues) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.expectedResultValues = expectedValues;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public List<Integer> getExpectedResultValues() {
        return expectedResultValues;
    }

}
