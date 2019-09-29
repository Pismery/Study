package com.pismery.study.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于m阶的B树满足以下定义
 * 1. 根节点至少有两个孩子，除非根节点是叶子节点；
 * 2. 每个中间结点有k个孩子则必须有k-1个元素；[ceil(m/2)<=k<=m]
 * 3. 所有叶子节点都在同一个层次中；
 * 4. 每个节点中的元素从小到大排列，节点当中k-1个元素正好是k个孩子包含的元素的值域分划
 */
public class BTree {

    private Node root;
    private int degree;

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        System.out.println(a instanceof List);
    }


    public BTree(int degree) {
        if (degree < 2)
            throw new RuntimeException("degree less than 2");

        this.degree = degree;
        this.root = new Node(degree);
    }


    public void insert(int key) {
        if (root.leaf) {
            root.keys.add(key);
        }
    }

    private void insert(Node father, Node node, int key) {
        if (node.isLeaf()) {
            int index = 0;
            List<Integer> keys = node.getKeys();
            for (; index < node.keyNum(); index++) {
                if (keys.get(index) == key)
                    return;
                else if (keys.get(index) < key)
                    break;
            }
            keys.add(index, key);

            if (node.keyNum() >= node.degree - 1) {

            }
        }
    }

    private class Node {
        private List<Integer> keys;
        private List<Node> childs;
        /**
         * 树的阶数
         */
        private int degree;
        /**
         * true:为叶子节点；false：非叶子节点
         */
        private boolean leaf;

        public Node() {
            this.keys = new LinkedList<>();
            this.childs = new LinkedList<>();
            this.degree = 2;
            this.leaf = true;
        }

        public Node(int degree) {
            if (degree < 2)
                throw new RuntimeException("degree less than 2");

            this.keys = new LinkedList<>();
            this.childs = new LinkedList<>();
            this.degree = degree;
            this.leaf = true;
        }

        public int childNum() {
            return this.childs.size();
        }

        public int keyNum() {
            return this.keys.size();
        }

        private boolean isFullNode() {
            return childNum() >= this.degree;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        public List<Integer> getKeys() {
            return keys;
        }

        public void setKeys(List<Integer> keys) {
            this.keys = keys;
        }

        public List<Node> getChilds() {
            return childs;
        }

        public void setChilds(List<Node> childs) {
            this.childs = childs;
        }
    }
}
