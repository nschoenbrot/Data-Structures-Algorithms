package com.gmail.nschoenbrot.dsa.algorithms;

import java.util.List;

/**
 * A class to contain various search algorithms.
 *
 * @author Nelson Schoenbrot
 */
public class Search {

    /**
     * Find the index of a value in a sorted list using binary search.
     *
     * @param sorted the sorted list to search.
     * @param value  the value to look for.
     * @return the index the value was found at or -1 if the value is not found.
     */
    public static <T extends Comparable<T>> int binarySearch(final List<T> sorted, final T value) {
        return binarySearch(sorted, value, 0, sorted.size());
    }

    private static <T extends Comparable<T>> int binarySearch(final List<T> sorted, final T value, int start, int end) {
        final int size = end - start;
        final int middleIndex = size / 2 + start;
        final T element = sorted.get(middleIndex);
        final int comparison = value.compareTo(element);
        if ((size == 1 || size == 0) && comparison != 0)
            return -1;
        if (comparison == 0)
            return middleIndex;
        if (comparison < 0)
            return binarySearch(sorted, value, start, middleIndex);
        else
            return binarySearch(sorted, value, middleIndex + 1, end);
    }
}
