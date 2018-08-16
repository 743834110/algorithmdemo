package com.company.sort;

/**
 * 快速排序
 * 排序时，大的放一边，小的放在另一边
 *
 */
public class QuickSort implements Sort{

    @Override
    public int[] sort(int[] elements) {

        int pivot = elements[0];
        int lower = 0;
        int higher = elements.length - 1;
        elements = this.partitionSort(pivot, elements, lower, higher);
        return elements;
    }

    /**
     * 分区进行排序运算
     * @param pivot
     * @param elements
     * @param lower
     * @param higher
     * @return
     */
    private int[] partitionSort(int pivot, int elements[], int lower, int higher) {

        if (lower >= higher)
            return elements;

        int first = lower;
        int last = higher;
        while (lower < higher) {

            while (lower < higher && elements[higher] > pivot) {
                higher--;
            }
            elements[lower] =  elements[higher];

            while (lower < higher && elements[lower] < pivot) {
                lower++;
            }
            elements[higher] = elements[lower];

        }
        elements[lower] = pivot;
        this.partitionSort(elements[first], elements, first, lower - 1);
        this.partitionSort(elements[lower + 1], elements, lower + 1, last);
        return elements;
    }
}
