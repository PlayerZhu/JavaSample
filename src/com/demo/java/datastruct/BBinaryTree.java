package com.demo.java.datastruct;

import java.util.Arrays;

/**
 * @description: 二叉树
 * @author: maker
 * @create: 2018/10/21
 */
public class BBinaryTree {
    private class Node {
        private Comparable data;
        private Node left;
        private Node right;

        public Node(Comparable data) {
            this.data = data;
        }

        public void addNode(Node node) {
            if (node.data.compareTo(this.data) < 0) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.addNode(node);
                }
            }
        }

        public void toNodeArray() {
            if (this.left != null) {
                this.left.toNodeArray();
            }
            BBinaryTree.this.array[BBinaryTree.this.index] = this.data;
            BBinaryTree.this.index++;
            if (this.right != null) {
                this.right.toNodeArray();
            }
        }
    }

    private Node root; // 任何数据结构要抓住一个根!!!
    private int count = 0;

    private int index;
    private Object[] array;

    public void add(Object data) {
        if (data == null) {
            return;
        }
        Node node = new Node((Comparable) data);
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
        count++;
    }

    public Object[] toArray() {
        index = 0;
        array = new Object[this.count];
        this.root.toNodeArray();
        return this.array;
    }

    public static void main(String[] args) {
        BBinaryTree binaryTree = new BBinaryTree();
        binaryTree.add("E");
        binaryTree.add("B");
        binaryTree.add("D");
        binaryTree.add("F");
        binaryTree.add("A");
        binaryTree.add("C");
        System.out.println(Arrays.toString(binaryTree.toArray()));
    }
}
