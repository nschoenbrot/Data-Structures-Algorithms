package com.gmail.nschoenbrot.dsa.types.binary.search.tree;

import com.gmail.nschoenbrot.dsa.types.binary.search.tree.exception.NullInsertException;

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

    public T getData() {
        return data;
    }

    /**
     * Inserts a node into the tree.
     * Do not insert null or node with null data, will cause cause exception.
     *
     * @param node the node to insert.
     */
    public void insert(final Node<T> node) {
        if (node == null || node.getData() == null)
            throw new NullInsertException();
        if (data.compareTo(node.getData()) < 0)
            insertOnRight(node);
        else
            insertOnLeft(node);
    }

    /**
     * Insert multiple nodes.
     * Do not insert null or node with null data, will cause cause exception.
     *
     * @param nodes the nodes to insert.
     */
    @SafeVarargs
    public final void insert(final Node<T>... nodes) {
        for (final Node<T> node : nodes)
            insert(node);
    }

    /**
     * Get the node in a tree corresponding to the first occurrence of the value.
     *
     * @param value is equal to the data in the node to be returned.
     * @return the node with data equal to the value or a null.
     */
    public Node<T> find(T value) {
        final int compare = data.compareTo(value);
        if (compare == 0)
            return this;
        if (left == null && right == null)
            return null;
        if (right != null && compare < 0)
            return right.find(value);
        if (left != null && compare > 0)
            return left.find(value);
        return null;
    }

    /**
     * Get a csv version of the tree.
     *
     * @return the csv. Example: 1, 2, 3
     */
    public String treeAsString() {
        if (left == null && right == null)
            return data.toString();
        if (left == null)
            return data.toString() + ", " + right.treeAsString();
        if (right == null)
            return left.treeAsString() + ", " + data.toString();
        return left.treeAsString() + ", " + data.toString() + ", " + right.treeAsString();
    }

    /**
     * Find the node with the lowest value in the tree.
     *
     * @return the min node.
     */
    public Node<T> findMin() {
        if (left == null)
            return this;
        return left.findMin();
    }

    /**
     * Attempts to remove the first occurrence of data matching the value.
     *
     * @param value corresponds to the node to remove (the node with the data equal to the value).
     * @return the root of the tree. The root of the tree will only change if the root is deleted.
     */
    public Node<T> remove(final T value) {
        if (data.equals(value) && left == null && right == null)
            return null;
        if (data.equals((value)) && right == null)
            return left;
        if (data.equals(value) && left == null)
            return right;
        if (data.equals(value)) removeNodeWithTwoChildren();
        else remove(value, null, false);
        return this;
    }

    private void remove(final T value, final Node<T> parent, final boolean isRightOfParent) {
        final int compare = data.compareTo(value);
        if (compare == 0)
            removeFoundNode(parent, isRightOfParent);
        else if (compare < 0)
            right.remove(value, this, true);
        else if (compare > 0)
            left.remove(value, this, false);
    }

    private void removeFoundNode(final Node<T> parent, final Boolean isRightOfParent) {
        if (left != null && right != null)
            removeNodeWithTwoChildren();
        else if (isRightOfParent)
            removeNodeWithRightChild(parent);
        else
            removeNodeWithLeftChild(parent);
    }

    private void removeNodeWithRightChild(final Node<T> parent) {
        if (right != null)
            parent.setRight(right);
        else if (left != null)
            parent.setRight(left);
        else
            parent.setRight(null);
    }

    private void removeNodeWithLeftChild(final Node<T> parent) {
        if (left != null)
            parent.setLeft(left);
        else if (right != null)
            parent.setLeft(right);
        else
            parent.setLeft(null);
    }

    private void removeNodeWithTwoChildren() {
        final Node<T> minRightChild = right.findMin();
        final T data = minRightChild.getData();
        right.remove(data, this, true);
        this.data = data;
    }

    private void insertOnRight(final Node<T> node) {
        if (right == null)
            right = node;
        else
            right.insert(node);
    }

    private void insertOnLeft(final Node<T> node) {
        if (left == null)
            left = node;
        else
            left.insert(node);
    }

    private void setLeft(Node<T> left) {
        this.left = left;
    }

    private void setRight(Node<T> right) {
        this.right = right;
    }
}
