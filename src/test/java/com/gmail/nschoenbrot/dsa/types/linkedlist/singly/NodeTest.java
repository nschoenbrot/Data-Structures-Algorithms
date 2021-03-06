package com.gmail.nschoenbrot.dsa.types.linkedlist.singly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Nelson Schoenbrot
 */
public class NodeTest {
    private Node<Integer> node;

    @Before
    public void setUp() throws Exception {
        node = new Node<>(1);
    }

    @Test
    public void append() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("1, 2, 3, 4", node.listAsString());
    }

    @Test
    public void getNext() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals(a, node.getNext());
        assertEquals(b, node.getNext().getNext());
        assertEquals(c, node.getNext().getNext().getNext());
    }

    @Test
    public void reverse() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("4, 3, 2, 1", node.reverse().listAsString());
    }

    @Test
    public void isCyclical_True() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c, a);
        assertTrue(node.isCyclical());
    }

    @Test
    public void isCyclical_False() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertFalse(node.isCyclical());
    }

    @Test
    public void remove() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("1, 2, 4", node.remove(3).listAsString());
    }

    @Test
    public void remove_root() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("2, 3, 4", node.remove(1).listAsString());
    }

    @Test
    public void insert() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("1, 11, 2, 3, 4", node.insert(1, new Node<>(11)).listAsString());
    }

    @Test
    public void insert_front() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("11, 1, 2, 3, 4", node.insert(0, new Node<>(11)).listAsString());
    }

    @Test
    public void insert_end() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        assertEquals("1, 2, 3, 11, 4", node.insert(3, new Node<>(11)).listAsString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insert_outOfBounds() throws Exception {
        final Node<Integer> a = new Node<>(2);
        final Node<Integer> b = new Node<>(3);
        final Node<Integer> c = new Node<>(4);
        node.append(a, b, c);
        node.insert(4, new Node<>(11));
    }
}