package com.gmail.nschoenbrot.dsa.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.gmail.nschoenbrot.dsa.algorithms.Search.binarySearch;
import static org.junit.Assert.assertEquals;

/**
 * @author Nelson Schoenbrot
 */
public class SearchTest {
    @Test
    public void binarySearch_FoundValue() throws Exception {
        final String[] sorted = {"apple", "banana", "dog", "zack", "zzz"};
        final List<String> sortedList = Arrays.asList(sorted);
        final String value = "dog";
        final int expectedIndex = 2;
        assertEquals(expectedIndex, binarySearch(sortedList, value));
    }

    @Test
    public void binarySearch_FoundAppleValue() throws Exception {
        final String[] sorted = {"apple", "banana", "dog", "zack", "zzz"};
        final List<String> sortedList = Arrays.asList(sorted);
        final String value = "apple";
        final int expectedIndex = 0;
        assertEquals(expectedIndex, binarySearch(sortedList, value));
    }

    @Test
    public void binarySearch_FoundZachValue() throws Exception {
        final String[] sorted = {"apple", "banana", "dog", "zack", "zzz"};
        final List<String> sortedList = Arrays.asList(sorted);
        final String value = "zack";
        final int expectedIndex = 3;
        assertEquals(expectedIndex, binarySearch(sortedList, value));
    }

    @Test
    public void binarySearch_FoundZachAtEndValue() throws Exception {
        final String[] sorted = {"apple", "banana", "dog", "zack"};
        final List<String> sortedList = Arrays.asList(sorted);
        final String value = "zack";
        final int expectedIndex = 3;
        assertEquals(expectedIndex, binarySearch(sortedList, value));
    }

    @Test
    public void binarySearch_NotFoundValue() throws Exception {
        final String[] sorted = {"apple", "banana", "dog", "zack", "zzz"};
        final List<String> sortedList = Arrays.asList(sorted);
        final String value = "cat";
        final int expectedIndex = -1;
        assertEquals(expectedIndex, binarySearch(sortedList, value));
    }
}