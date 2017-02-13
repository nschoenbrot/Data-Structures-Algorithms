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

    public static <T extends Comparable<T>> List<T> quickSort(final List<T> unsorted) {
        if (unsorted == null)
            return null;
        final ArrayList<T> sorted = new ArrayList<>(unsorted);
        quickSort(sorted, 0, unsorted.size());
        return sorted;
    }

    private static <T extends Comparable<T>> void quickSort(final List<T> unsorted, int start, int end) {
        final int size = end - start;
        if (size < 3) return;
        final List<T> toBeSorted = new ArrayList<>(unsorted);
        final T pivot = toBeSorted.get(size / 2 + start);
        int left = start;
        int right = end - 1;
        while (left < right) {
            final T leftElement = unsorted.get(left);
            final T rightElement = unsorted.get(right);
            final boolean isLeftLessThanPivot = leftElement.compareTo(pivot) < 0;
            final boolean isRightMoreThanPivot = rightElement.compareTo(pivot) > 0;
            if (isLeftLessThanPivot && isRightMoreThanPivot) {
                left++;
                right--;
            } else if (isLeftLessThanPivot) {
                left++;
            } else if (isRightMoreThanPivot) {
                right--;
            } else {
                unsorted.set(left, rightElement);
                unsorted.set(right, leftElement);
                left++;
                right--;
            }
        }
        quickSort(unsorted, start, left + 1);
        quickSort(unsorted, right, end);
    }
}
