package com.pismery.study.structure.tree;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉搜索树
 */
public class BST {

    private int count;
    private Node root;

    public BST() {
        this.root = null;
        this.count = 0;
    }


    /**
     * @return root.key value when root is null return null;
     */
    public Integer getRoot() {
        if (this.root == null)
            return null;


        return this.root.getKey();
    }


    public void insert(Integer key, Integer value) {
        if (root == null) {
            root = new Node(key, value);
            count++;
            return;
        }

        insert(root, key, value);
    }

    private void insert(Node root, Integer key, Integer value) {
        if (root.getKey() < key && root.getRight() == null) {
            count++;
            root.setRight(new Node(key, value));
            return;
        }
        if (root.getKey() > key && root.getLeft() == null) {
            count++;
            root.setLeft(new Node(key, value));
            return;
        }


        if (root.getKey() < key) {
            insert(root.getRight(), key, value);
        } else if (root.getKey() > key) {
            insert(root.getLeft(), key, value);
        } else {
            root.setValue(value);
        }
    }

    /**
     * @param key
     * @return true:Tree contain the key;false : no find in tree;
     */
    public boolean isContain(Integer key) {
        return isContain(root, key);
    }

    private boolean isContain(Node root, Integer key) {
        if (root == null)
            return false;

        if (root.getKey() < key)
            return isContain(root.getRight(), key);
        else if (root.getKey() > key)
            return isContain(root.getLeft(), key);
        else
            return true;
    }

    public Integer getByKey(Integer key) {
        if (key == null)
            return null;

        return getByKey(this.root, key);
    }

    private Integer getByKey(Node root, Integer key) {
        if (root == null)
            return null;

        if (root.getKey() < key)
            return getByKey(root.getRight(), key);
        else if (root.getKey() > key)
            return getByKey(root.getLeft(), key);
        else
            return root.getValue();
    }

    /**
     * 前序遍历
     */
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrder(result, root);
        return result;
    }

    private void preOrder(List<Integer> list, Node root) {
        if (root == null)
            return;
        list.add(root.getKey());
        preOrder(list, root.getLeft());
        preOrder(list, root.getRight());
    }

    /**
     * 中序遍历
     */
    public List<Integer> midOrder() {
        List<Integer> result = new ArrayList<>();
        midOrder(result, root);
        return result;
    }

    private void midOrder(List<Integer> list, Node root) {
        if (root == null)
            return;

        midOrder(list, root.getLeft());
        list.add(root.getKey());
        midOrder(list, root.getRight());
    }

    /**
     * 后序遍历
     */
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrder(result, root);
        return result;
    }

    private void postOrder(List<Integer> list, Node root) {
        if (root == null)
            return;

        postOrder(list, root.getLeft());
        postOrder(list, root.getRight());
        list.add(root.getKey());
    }

    /**
     * 层次遍历
     */
    public List<Integer> levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);

        List<Integer> result = new ArrayList<>();
        Node element;
        while (true) {
            element = queue.poll();

            if (element == null)
                break;

            if (element.getLeft() != null)
                queue.add(element.getLeft());

            if (element.getRight() != null)
                queue.add(element.getRight());

            result.add(element.getKey());
        }
        return result;
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public Integer minimunKey() {
        if (root == null)
            throw new RuntimeException("root is null");
        return minmunKey(root);
    }

    private Integer minmunKey(Node root) {
        if (root.getLeft() == null)
            return root.getKey();

        return minmunKey(root.getLeft());

    }

    /**
     * 获取最大值
     *
     * @return
     */
    public Integer maxmunKey() {
        if (root == null)
            throw new RuntimeException("root is null");

        return maxmunKey(root);
    }

    private Integer maxmunKey(Node root) {
        if (root.getRight() == null)
            return root.getKey();

        return maxmunKey(root.getRight());
    }

    /**
     * 移除最小值
     */
    public void removeMin() {
        if (root == null)
            return;

        removeMin(null, root);
    }

    private void removeMin(Node father, Node node) {
        if (node.getLeft() != null) {
            removeMin(node, node.getLeft());
            return;
        }

        if (father == null)
            this.root = null;
        else if (father.getKey() > node.getKey())
            father.setLeft(node.getRight());
        else
            father.setRight(node.getRight());

        this.count--;
    }

    /**
     * 移除最大值
     */
    public void removeMax() {
        if (this.root == null)
            return;

        removeMax(null, this.root);

    }

    private void removeMax(Node father, Node node) {
        if (node.getRight() != null) {
            removeMax(node, node.getRight());
            return;
        }

        if (father == null)
            this.root = null;
        else
            father.setRight(node.getLeft());

        this.count--;
    }

    /**
     * 移除Key值；若Key不存在，直接return
     *
     * @param key
     */
    public void remove(Integer key) {
        if (!isContain(key))
            return;

        remove(null, this.root, key);
    }

    private void removeRoot() {

        if (this.root.getLeft() != null && this.root.getRight() != null) {
            //获取右子树的最小值
            Node min = minimumNode(this.root.getRight());

            removeMin(this.root, this.root.getRight());
            min.setLeft(this.root.getLeft());
            min.setRight(this.root.getRight());

            this.root = min;
            return;
        }

        this.root = getSingleChildren(this.root);
        this.count--;
        return;
    }

    private void remove(Node father, Node node, Integer key) {
        if (node.getKey() < key) {
            remove(node, node.getRight(), key);
            return;
        }
        if (node.getKey() > key) {
            remove(node, node.getLeft(), key);
            return;
        }

        //find the node
        if (father == null) {
            removeRoot();
            return;
        }

        if (node.getLeft() != null && node.getRight() != null) {
            //获取右子树的最小值
            Node min = minimumNode(node.getRight());

            removeMin(node, node.getRight());
            min.setLeft(node.getLeft());
            min.setRight(node.getRight());

            if (father.getKey() < node.getKey())
                father.setRight(min);
            else
                father.setLeft(min);

            return;
        }

        Node childNode = getSingleChildren(node);
        if (father.getKey() < node.getKey())
            father.setRight(childNode);
        else
            father.setLeft(childNode);

        this.count--;
        return;
    }

    /**
     * @param node
     * @return 1.若只有左孩子，返回左孩子
     * 2.若只有右孩子，返回右孩子
     * 3.若没有孩子，返回null
     * 4.若左右孩子都存在，throw runtimeexception();
     */
    Node getSingleChildren(Node node) {
        if (node.getLeft() != null && node.getRight() == null) {
            //如果左子树存在，右子树不存在
            return node.getLeft();
        }

        if (node.getLeft() == null && node.getRight() != null) {
            //如果右子树存在，左子树不存在
            return node.getRight();
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        }

        throw new RuntimeException();
    }

    private Node minimumNode(Node root) {
        if (root.getLeft() == null)
            return root;

        return minimumNode(root.getLeft());
    }

    public int length() {
        return this.count;
    }

    /**
     * aim to unit test
     *
     * @return
     */
    Node getRootNode() {
        return this.root;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class Node {
        private Integer key;
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
