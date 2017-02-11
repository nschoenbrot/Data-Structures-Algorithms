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
        Node<T> nextInList = next;
        while (nextInList != null) {
            lastNode = nextInList;
            nextInList = nextInList.getNext();
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
     * List to string.
     *
     * @return a CSV.
     */
    public String listAsString() {
        final StringBuilder csv = new StringBuilder();
        csv.append(data);
        Node<T> nextInList = next;
        while (nextInList != null) {
            csv.append(", ").append(nextInList.getData());
            nextInList = nextInList.getNext();
        }
        return csv.toString();
    }

    /**
     * Reverse the list.
     *
     * @return a reversed list.
     */
    public Node<T> reverse() {
        final Stack<Node<T>> stack = new Stack<>();
        Node<T> current = this;
        while (current != null) {
            stack.push(current);
            current = current.getNext();
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
