package com.gmail.nschoenbrot.dsa.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.gmail.nschoenbrot.dsa.algorithms.Sort.mergeSort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Nelson Schoenbrot
 */
public class SortTest {
    @Test
    public void mergeSort_SortUnsortedIntegers() throws Exception {
        final Integer[] numbers = {10, 5, 2, 7, 4, 9, 12, 1, 8, 6, 11, 3};
        final Integer[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        final List<Integer> unsorted = Arrays.asList(numbers);
        assertEquals(Arrays.asList(sortedNumbers), mergeSort(unsorted));
    }

    @Test
    public void mergeSort_SortUnsortedIntegersOddNumber() throws Exception {
        final Integer[] numbers = {10, 5, 2, 7, 4, 9, 12, 1, 8, 6, 11, 3, 13};
        final Integer[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        final List<Integer> unsorted = Arrays.asList(numbers);
        assertEquals(Arrays.asList(sortedNumbers), mergeSort(unsorted));
    }

    @Test
    public void mergeSort_SortUnsortedIntegersEmpty() throws Exception {
        final Integer[] numbers = {};
        final Integer[] sortedNumbers = {};
        final List<Integer> unsorted = Arrays.asList(numbers);
        assertEquals(Arrays.asList(sortedNumbers), mergeSort(unsorted));
    }

    @Test
    public void mergeSort_SortUnsortedIntegersNull() throws Exception {
        assertNull(mergeSort(null));
    }
}