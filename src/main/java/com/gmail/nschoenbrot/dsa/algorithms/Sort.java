package com.gmail.nschoenbrot.dsa.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to contain various sorting algorithms.
 *
 * @author Nelson Schoenbrot
 */
public class Sort {
    public static <T extends Comparable<T>> List<T> mergeSort(final List<T> unsorted) {
        if (unsorted == null)
            return null;
        if (unsorted.size() < 2)
            return unsorted;
        final int splitIndex = unsorted.size() / 2;
        final List<T> left = mergeSort(unsorted.subList(0, splitIndex));
        final List<T> right = mergeSort(unsorted.subList(splitIndex, unsorted.size()));
        return mergeStep(left, right);
    }

    private static <T extends Comparable<T>> List<T> mergeStep(final List<T> left, List<T> right) {
        final List<T> merged = new ArrayList<>();
        int leftHead = 0;
        int rightHead = 0;
        while (leftHead < left.size() && rightHead < right.size()) {
            if (left.get(leftHead)
                    .compareTo(right.get(rightHead)) < 0)
                merged.add(left.get(leftHead++));
            else
                merged.add(right.get(rightHead++));
        }
        while (rightHead < right.size())
            merged.add(right.get(rightHead++));
        while (leftHead < left.size())
            merged.add(left.get(leftHead++));
        return merged;
    }
}
