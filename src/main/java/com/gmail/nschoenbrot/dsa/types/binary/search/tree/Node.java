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

    /**
     * Inserts a node into the tree.
     * Do not insert null or node with null data, will cause cause exception.
     *
     * @param node the node to insert.
     */
    public void insert(final Node<T> node) {
        if (node == null || node.getData() == null) throw new NullInsertException();
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
     * Insert multiple nodes.
     * Do not insert null or node with null data, will cause cause exception.
     *
     * @param nodes the nodes to insert.
     */
    @SafeVarargs
    public final void insert(final Node<T>... nodes) {
        for (final Node<T> node : nodes) {
            insert(node);
        }
    }

    /**
     * Get the node in a tree corresponding to the first occurrence of the value.
     *
     * @param value is equal to the data in the node to be returned.
     * @return the node with data equal to the value or a null.
     */
    public Node<T> find(T value) {
        final int compare = data.compareTo(value);
        if (compare == 0) {
            return this;
        }
        if (left == null && right == null) {
            return null;
        }
        if (right != null && compare < 0) {
            return right.find(value);
        }
        if (left != null && compare > 0) {
            return left.find(value);
        }
        return null;
    }

    /**
     * Get a csv version of the tree.
     *
     * @return the csv. Example: 1, 2, 3
     */
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

    /**
     * Attempts to remove the first occurrence of a node with data matching the value.
     *
     * @param value corresponds to the node to remove (the node with the data equal to the value).
     * @return the deleted node with null left and right. Or null if no node was found.
     */
    public Node<T> remove(final T value) {
        return remove(value, null, null);
    }

    private Node<T> remove(final T value, final Node<T> parent, final Boolean isRight) {
        // TODO Remove nodes with two children.
        final int compare = data.compareTo(value);
        Node<T> removed = null;
        if (compare == 0 && parent != null && isRight != null) {
            if (isRight) {
                if (right != null)
                    parent.setRight(right);
                else if (left != null)
                    parent.setRight(left);
                else
                    parent.setRight(null);
            } else {
                if (left != null)
                    parent.setLeft(left);
                else if (right != null)
                    parent.setLeft(right);
                else
                    parent.setLeft(null);
            }
            return this;
        } else if (compare < 0) {
            removed = right.remove(value, this, true);
        } else if (compare > 0) {
            removed = left.remove(value, this, false);
        }
        return removed;
    }

    public T getData() {
        return data;
    }

    private void setLeft(Node<T> left) {
        this.left = left;
    }

    private void setRight(Node<T> right) {
        this.right = right;
    }
}
