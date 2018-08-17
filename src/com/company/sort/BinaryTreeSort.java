package com.company.sort;

/**
 * 二叉排序树
 * 小的元素放在父节点左边，大的节点放在父节点的右边，中序输出
 */
public class BinaryTreeSort implements Sort {

    /**
     * 根节点
     */
    private Node root = null;

    /**
     * 元素个数
     */
    private int length;




    private class Node {
        /**
         * 节点值
         */
        private Integer value;
        /**
         * 左孩子
         */
        private Node left;
        /**
         * 右孩子
         */
        private Node right;

        public Node(Integer value) {
            this.value = value;
        }

    }

    @Override
    public int[] sort(int[] elements) {

        this.length = elements.length;
        if (length > 0)
            this.root = new Node(elements[0]);


        for (int i = 1; i < elements.length; i++) {
            this.build(this.root, elements[i]);
        }
        return this.travel();
    }

    /**
     * 排序树构建
     * @param parent
     * @param value
     */
    private void build(Node parent, int value) {

        if (parent.left != null && value < parent.value)
            this.build(parent.left, value);
        else if (parent.left == null && value < parent.value)
            parent.left = new Node(value);
        else if (parent.right != null)
            this.build(parent.right, value);
        else
            parent.right = new Node(value);

    }

    /**
     * 树中节点的值群到数组的转换
     * @return
     */
    private int[] travel() {
        int[] elements = new int[this.length];

        this.fetch(elements, this.root, 0);
        return elements;
    }

    /**
     * 中序遍历输出
     * @param elements
     * @param parent
     * @return int
     */
    private int fetch(int elements[], Node parent, int index) {

        if (parent == null)
            return index;

        // 左
        index = this.fetch(elements, parent.left, index);
        // 根
        elements[index++] = parent.value;
        // 右
        index = this.fetch(elements, parent.right, index);

        return index;
    }






}
