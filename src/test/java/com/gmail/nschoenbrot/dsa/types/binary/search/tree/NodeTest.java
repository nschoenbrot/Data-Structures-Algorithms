package com.gmail.nschoenbrot.dsa.types.binary.search.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Nelson Schoenbrot
 */
public class NodeTest {
    private Node<Integer> node;

    @Before
    public void setUp() throws Exception {
        node = new Node<>(100);
    }

    @Test
    public void insert() throws Exception {
        final Node<Integer> a = new Node<>(60);
        final Node<Integer> b = new Node<>(59);
        final Node<Integer> c = new Node<>(88);
        final Node<Integer> d = new Node<>(59);
        node.insert(a);
        node.insert(b);
        node.insert(c);
        node.insert(d);
        final String expected = "59, 59, 60, 88, 100";

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void find() throws Exception {
        final Node<Integer> a = new Node<>(752937);
        final Node<Integer> b = new Node<>(9871);
        final Node<Integer> c = new Node<>(98349);
        final Node<Integer> d = new Node<>(75289308);
        node.insert(a);
        node.insert(b);
        node.insert(c);
        node.insert(d);

        assertEquals(b, node.find(9871));
    }

    @Test
    public void remove_RightLeaf() {
        final Node<Integer> a = new Node<>(25);
        final Node<Integer> b = new Node<>(115);
        node.insert(a);
        node.insert(b);
        final String expected = "25, 100";

        node.remove(115);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_LeftLeaf() {
        final Node<Integer> a = new Node<>(25);
        final Node<Integer> b = new Node<>(115);
        node.insert(a);
        node.insert(b);
        final String expected = "100, 115";

        node.remove(25);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_RemovedLeaf() {
        final Node<Integer> a = new Node<>(25);
        final Node<Integer> b = new Node<>(115);
        node.insert(a);
        node.insert(b);
        final int expected = 25;

        final Node<Integer> removed = node.remove(25);

        assertTrue(expected == removed.getData());
    }
}