package com.company.tree;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * @author zhang123
 * 哈弗曼树
 * prefix code: 前缀编码
 */
public class HuffmanTree {

    private Node root;

    public static class Node {
        /**
         * 权重
         */
        private int weight;
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

        public Node(int weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }


    public HuffmanTree(Node[] nodes) {
        List<Node> nodeList = new LinkedList<>();
        Collections.addAll(nodeList, nodes);
        this.build(nodeList);
    }

    /**
     * 构建哈弗曼树
     * 当节点列表中的数量为1时，将停止哈弗曼树的构建
     */
    private void build(List<Node> nodes) {

        if (nodes.size() <= 1) {
            this.root = nodes.get(0);
            return;
        }

        this.sort(nodes);
        Node n1 = nodes.remove(0);
        Node n2 = nodes.remove(0);
        Node node = new Node(n1.weight + n2.weight, null);
        node.left = n1;
        node.right = n2;
        nodes.add(node);
        this.build(nodes);
    }
    /**
     * 排序
     */
    private void sort(List<Node> nodes) {
        // 对节点进行排序处理
        nodes.sort((o1, o2) -> {
            if (o1.weight < o2.weight) {
                return -1;
            }
            else if (o1.weight == o2.weight) {
                return 0;
            }
            return 1;
        });
    }

    /**
     * 通过哈弗曼数目进行解码
     */
    public String decoding(String code) {

        StringBuilder builder = new StringBuilder();
        this.travel(builder, this.root, code.toCharArray(), -1);
        return builder.toString();
    }

    /**
     * 遍历哈弗曼树，取得相应的值
     * @param parent
     * @param builder
     * @param chars
     * @param index
     * @return int 当返回值为-1时，表明节点的遍历已经到了尽头，需要进行重置，重新进行树的遍历，以便找到源报文
     * 返回其他数则表明编码发生异常。
     */
    private int travel(StringBuilder builder ,Node parent, char[] chars, int index) {

        if (parent == null) {
            return -1;
        }
        Node node = null;
        if (index + 1 < chars.length ) {
            node = chars[++index] == '1'? parent.right: parent.left;;
        }
        int flag = this.travel(builder, node, chars, index);
        if (flag == -1) {
            // 添加解码后的字符
            builder.append((char)(int)parent.value);
            // 重新遍历哈弗曼树, 当前index无需自增，
            if (index + 1 != chars.length) {
                this.travel(builder, this.root, chars, index - 1);
            }
        }
        return 1;
    }


    /**
     *
     * 获取字符编码
     * @param chars
     * @return
     */
    public String coding(char[] chars) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            this.travel(this.root, builder, chars[i], "");
        }
        return builder.toString();
    }

    public String coding(String message) {
        return this.coding(message.toCharArray());
    }

    /**
     * 通过后序遍历哈弗曼, 根据左0右1的规则获取编码
     * @param parent
     * @param builder
     * @param ch
     */
    private void travel(Node parent, StringBuilder builder, char ch, String index) {

        if (parent == null) {
            return;
        }
        // 遍历左子树
        this.travel(parent.left, builder, ch, index + "0");
        // 遍历右子树
        this.travel(parent.right, builder, ch, index + "1");
        // 根
        if (parent.value != null && parent.value == ch) {

            builder.append(index);
        }
    }

}
