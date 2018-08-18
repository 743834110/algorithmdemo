package com.company;

import com.company.sort.*;
import com.company.tree.HuffmanTree;

import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Sort sort = new BinaryTreeSort();
        SortContext context = new SortContext(sort);

        int[] elements = context.sort(new int[] {7,4,1,8,5,2,3,6,9,78,14,55,1000,855458,888,8946});

        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }

        HuffmanTree tree = new HuffmanTree(new HuffmanTree.Node[] {
                new HuffmanTree.Node(5, 'A'),
                new HuffmanTree.Node(24, 'B'),
                new HuffmanTree.Node(7, 'C'),
                new HuffmanTree.Node(17, 'D'),
                new HuffmanTree.Node(34, 'E'),
                new HuffmanTree.Node(5, 'F'),
                new HuffmanTree.Node(13, 'G'),
        });

        String code = tree.coding("BAG");
        System.out.println("哈弗曼编码:" + code);
        tree.decoding(code );
        String message = tree.decoding(code);
        System.out.println(message);
    }
}
