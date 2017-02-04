package com.gmail.nschoenbrot.dsa.types.binary.search.tree;

/**
 * A node in a binary search tree.
 *
 * @author Nelson Schoenbrot
 */
public class Node<T extends Comparable<T>> {
    private Node<T> left;
    private Node<T> right;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    /**
     * Inserts a node into the tree.
     * Do not insert null or node with null data.
     *
     * @param node the node to insert.
     */
    public void insert(final Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (right == null)
                right = node;
            else
                right.insert(node);
        } else {
            if (left == null)
                left = node;
            else
                left.insert(node);
        }
    }

    /**
     * Get the node in a tree corresponding to the value.
     *
     * @param value is equal to the data in the node to be returned.
     * @return the node with data equal to the value or a null.
     */
    public Node<T> find(T value) {
        if (data.equals(value)) {
            return this;
        }
        if (left == null && right == null) {
            return null;
        }
        if (right != null && data.compareTo(value) < 0) {
            return right.find(value);
        }
        if (left != null && data.compareTo(value) > 0) {
            return left.find(value);
        }
        return null;
    }

    public String treeAsString() {
        if (left == null && right == null) {
            return data.toString();
        }
        if (left == null) {
            return data.toString() + ", " + right.treeAsString();
        }
        if (right == null) {
            return left.treeAsString() + ", " + data.toString();
        }
        return left.treeAsString() + ", " + data.toString() + ", " + right.treeAsString();
    }

    public T getData() {
        return data;
    }
}
