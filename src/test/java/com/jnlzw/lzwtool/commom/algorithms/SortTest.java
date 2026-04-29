package com.jnlzw.lzwtool.commom.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    private final Sort sort = new Sort();
    private final Comparator<Integer> asc = Integer::compareTo;

    @Test
    void insertionSortCases() {
        assertCases((arr) -> sort.insertionSort(arr, asc));
    }

    @Test
    void mergeSortCases() {
        assertCases((arr) -> sort.mergeSort(arr, asc));
    }

    @Test
    void heapSortCases() {
        assertCases((arr) -> sort.heapSort(arr, asc));
    }

    @Test
    void quickSortCases() {
        assertCases((arr) -> sort.quickSort(arr, asc));
    }

    @Test
    void countSortCases() {
        assertCases(sort::countSort);
    }

    private void assertCases(SortExecutor executor) {
        Integer[] empty = new Integer[]{};
        executor.sort(empty);
        assertArrayEquals(new Integer[]{}, empty);

        Integer[] dup = new Integer[]{3, 1, 3, 2, 2};
        executor.sort(dup);
        assertArrayEquals(new Integer[]{1, 2, 2, 3, 3}, dup);

        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5};
        executor.sort(sorted);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, sorted);

        Integer[] reverse = new Integer[]{5, 4, 3, 2, 1};
        executor.sort(reverse);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, reverse);

        Integer[] randomLarge = new Integer[200];
        Random random = new Random(42);
        for (int i = 0; i < randomLarge.length; i++) {
            randomLarge[i] = random.nextInt(1000);
        }
        Integer[] expected = randomLarge.clone();
        Arrays.sort(expected);
        executor.sort(randomLarge);
        assertArrayEquals(expected, randomLarge);
    }

    @FunctionalInterface
    private interface SortExecutor {
        void sort(Integer[] arr);
    }
}
