package com.gmail.nschoenbrot.dsa.types.linkedlist.singly;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * A node in a singly linked list.
 *
 * @author Nelson Schoenbrot
 */
public class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    /**
     * Get the node's data.
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Get the next node.
     *
     * @return next
     */
    public Node<T> getNext() {
        return next;
    }

    private void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Add a node to the end of the list.
     *
     * @param node node to add.
     */
    public void append(final Node<T> node) {
        Node<T> lastNode = this;
        for (Node<T> nextInList = next; nextInList != null; nextInList = nextInList.getNext()) {
            lastNode = nextInList;
        }
        lastNode.setNext(node);
    }

    /**
     * Append many nodes.
     *
     * @param nodes nodes to add.
     */
    @SafeVarargs
    public final void append(final Node<T>... nodes) {
        for (final Node<T> node : nodes) {
            append(node);
        }
    }

    /**
     * Insert a node a specific index.
     *
     * @param index the index to insert at.
     * @param node  the node to insert.
     * @return the head of the list.
     */
    public Node<T> insert(int index, Node<T> node) {
        int currentIndex = 0;
        Node<T> parent = null;
        for (Node<T> current = this; current != null; current = current.getNext()) {
            if (index == currentIndex && parent == null) {
                node.setNext(current);
                return node;
            }
            if (index == currentIndex) {
                node.setNext(current);
                parent.setNext(node);
                return this;
            }
            parent = current;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * List to string.
     *
     * @return a CSV.
     */
    public String listAsString() {
        final StringBuilder csv = new StringBuilder();
        csv.append(data);
        for (Node<T> nextInList = next; nextInList != null; nextInList = nextInList.getNext()) {
            csv.append(", ").append(nextInList.getData());
        }
        return csv.toString();
    }

    /**
     * Remove a node corresponding to a node.
     *
     * @param value the value to remove.
     * @return the head of the list.
     */
    public Node<T> remove(T value) {
        Node<T> parent = null;
        for (Node<T> current = this; current != null; current = current.getNext()) {
            if (value.equals(current.getData()) && parent != null)
                parent.setNext(current.getNext());
            else if (value.equals(current.getData()))
                return current.getNext();
            parent = current;
        }
        return this;
    }

    /**
     * Reverse the list.
     *
     * @return a reversed list.
     */
    public Node<T> reverse() {
        final Stack<Node<T>> stack = new Stack<>();
        for (Node<T> current = this; current != null; current = current.getNext()) {
            stack.push(current);
        }
        return createLinkedListFromStack(stack);
    }

    public boolean isCyclical() {
        final Set<Node<T>> set = new HashSet<>();
        for (Node<T> current = this; current != null; current = current.getNext()) {
            if (set.contains(current)) return true;
            set.add(current);
        }
        return false;
    }

    private Node<T> createLinkedListFromStack(final Stack<Node<T>> stack) {
        final Node<T> linkedList = stack.pop();
        linkedList.setNext(null);
        Node<T> current = linkedList;
        while (!stack.empty()) {
            final Node<T> nextInStack = stack.pop();
            nextInStack.setNext(null);
            current.setNext(nextInStack);
            current = nextInStack;
        }
        return linkedList;
    }
}
