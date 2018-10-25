package com.demo.java.datastruct;

/**
 * @description: 单链表
 * @author: maker
 * @create: 2018/10/10
 */
public class ASingleLinkList {

    /**
     * @description: 节点类
     */
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        public void addNode(Node node) {
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.addNode(node);
            }
        }

        public Object getNode(int index) {
            if (this.next == null) {
                return null;
            }
            if (ASingleLinkList.this.foot == index) {
                return this.data;
            }
            ASingleLinkList.this.foot++;
            return this.next.getNode(index);
        }

        public void setNode(int index, Object data) {
            if (this.next == null) {
                return;
            }
            if (ASingleLinkList.this.foot == index) {
                this.data = data;
                return;
            }
            ASingleLinkList.this.foot++;
            this.next.setNode(index, data);
        }

        public boolean containsNode(Object data) {
            if (this.data.equals(data)) {
                return true;
            }
            if (this.next == null) {
                return false;
            } else {
                return this.next.containsNode(data);
            }
        }

        public void removeNode(Node previous, Object data) {
            if (this.data.equals(data)) {
                previous.next = this.next;
            } else {
                this.next.removeNode(this, data);
            }
        }

        public void toArrayNode() {
            ASingleLinkList.this.array[ASingleLinkList.this.foot] = this.data;
            ASingleLinkList.this.foot++;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }
    }

    // 根节点
    private Node root;
    // 节点个数
    private int size = 0;

    // 所有节点数据
    private Object array[];
    // 下一个节点角标
    private int foot;

    public void add(Object data) {
        if (data == null) {
            return;
        }
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public Object[] toArray() {
        if (this.size <= 0) {
            return null;
        }
        this.array = new Object[this.size];
        this.foot = 0;
        this.root.toArrayNode();
        return this.array;
    }

    public boolean contains(Object data) {
        if (data == null || this.root == null) {
            return false;
        } else {
            return this.root.containsNode(data);
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);
    }

    public void set(int index, Object data) {
        if (index < 0 || index >= this.size) {
            return;
        }
        this.foot = 0;
        this.root.setNode(index, data);
    }

    public void remove(Object data) {
        if (!this.contains(data))
            return;
        if (this.root.data.equals(data)) {
            this.root = this.root.next;
        } else {
            this.root.next.removeNode(this.root, data);
        }
        this.size--;
    }

    /**
     * @param args
     * @description: 测试入口
     */
    public static void main(String[] args) {
        ASingleLinkList linkList = new ASingleLinkList();
        System.out.println("is_empty: " + linkList.isEmpty());
        linkList.add("a");
        linkList.add("b");
        linkList.add("c");
        linkList.add("d");
        System.out.println("is_empty: " + linkList.isEmpty());
        System.out.println("size: " + linkList.getSize());
        Object[] array = linkList.toArray();
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
}
