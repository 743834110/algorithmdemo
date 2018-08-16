package com.company.sort;


/**
 * 冒泡排序
 * 小在首部
 * 大在尾部
 */
public class BubbleSort implements Sort{


    @Override
    public int[] sort(int[] elements) {

        int length = elements.length;

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length - i - 1; j++) {

                if (elements[j] > elements[j + 1]) {
                    elements[j] = elements[j] ^ elements[j + 1];
                    elements[j + 1] = elements[j] ^ elements[j + 1];
                    elements[j] = elements[j] ^ elements[j + 1];
                }
            }
        }

        return elements;
    }
}
