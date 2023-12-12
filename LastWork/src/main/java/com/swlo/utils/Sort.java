package com.swlo.utils;

import java.util.Comparator;
import java.util.List;

public class Sort {

    public static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (comparator.compare(list.get(j), list.get(j+1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static <T> void selectionSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(min_idx)) < 0) {
                    min_idx = j;
                }
            }
            T temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);
        }
    }

    public static <T> void insertionSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }
}