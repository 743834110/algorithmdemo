package com.company.sort;

/**
 * @author li
 */
public class SortContext {

    private Sort sort;

    public SortContext(Sort sort) {
        this.sort = sort;
    }

    public int[] sort(int[] elements) {
        return this.sort.sort(elements);
    }
}
