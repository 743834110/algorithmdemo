package com.company;

import com.company.sort.*;

public class Main {

    public static void main(String[] args) {

        Sort sort = new QuickSort();
        SortContext context = new SortContext(sort);

        int[] elements = context.sort(new int[] {7,4,1,8,5,2,3,6,9});

        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }
}
