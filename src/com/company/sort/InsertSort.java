package com.company.sort;

/**
 * @author li
 * 插入排序
 * 元素在每次插入数组当中就进行排序
 */
public class InsertSort implements Sort{

    @Override
    public int[] sort(int[] elements) {

        int length = elements.length;
        int higher;
        for (int i = 1; i < length ; i++) {
            higher = elements[i];
            for (int j = 0; j < i; j++) {
                if (elements[j] > higher) {
                    elements = this.rightShift(elements, j, higher, i);
                    break ;
                }
            }
        }

        return elements;
    }

    /**
     * 将元素插入到index位置中
     * @param elements
     * @param index
     * @param value
     * @param length
     * @return
     */
    private int[] rightShift(int[] elements, int index, int value, int length) {

        for (int i = length - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = value;
        return elements;
    }


}
