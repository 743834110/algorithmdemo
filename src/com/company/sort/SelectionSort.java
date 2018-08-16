package com.company.sort;

/**
 * @author li
 * 简单选择排序
 * 每次选择最大的或者最小的存放到启始位置
 */
public class SelectionSort implements Sort{

    @Override
    public int[] sort(int[] elements) {

        int length = elements.length;
        int lower;

        for (int i = 0; i < length; i++) {

            lower = elements[i];
            for (int j = i + 1; j < length; j++) {
                if (lower > elements[j]) {
                   int temp = lower;
                   lower = elements[j];
                   elements[j] = temp;
                }
            }
            elements[i] = lower;
        }

        return elements;
    }
}
