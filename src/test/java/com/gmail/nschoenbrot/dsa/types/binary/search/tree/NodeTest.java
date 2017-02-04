package com.gmail.nschoenbrot.dsa.types.binary.search.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

}