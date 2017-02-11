package com.gmail.nschoenbrot.dsa.types.binary.search.tree;

import com.gmail.nschoenbrot.dsa.types.binary.search.tree.exception.NullInsertException;
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
        node.insert(a, b, c, d);
        final String expected = "59, 59, 60, 88, 100";

        assertEquals(expected, node.treeAsString());
    }

    @Test(expected = NullInsertException.class)
    @SuppressWarnings("unchecked")
    public void insert_Null() throws Exception {
        node.insert((Node) null);
    }

    @Test(expected = NullInsertException.class)
    @SuppressWarnings("unchecked")
    public void insert_NullData() throws Exception {
        node.insert(new Node(null));
    }

    @Test
    public void find() throws Exception {
        final Node<Integer> a = new Node<>(752937);
        final Node<Integer> b = new Node<>(9871);
        final Node<Integer> c = new Node<>(98349);
        final Node<Integer> d = new Node<>(75289308);
        node.insert(a, b, c, d);

        assertEquals(b, node.find(9871));
    }

    @Test
    public void remove_RightLeaf() {
        final Node<Integer> a = new Node<>(25);
        final Node<Integer> b = new Node<>(115);
        node.insert(a, b);
        final String expected = "25, 100";

        node.remove(115);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_LeftLeaf() {
        final Node<Integer> a = new Node<>(25);
        final Node<Integer> b = new Node<>(115);
        node.insert(a, b);
        final String expected = "100, 115";

        node.remove(25);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_RemovedLeaf() {
        final Node<Integer> a = new Node<>(25);
        final Node<Integer> b = new Node<>(115);
        node.insert(a, b);
        final int expected = 25;

        final Node<Integer> removed = node.remove(25);

        assertTrue(expected == removed.getData());
    }

    @Test
    public void remove_NodeWithOneRightChild() {
        final Node<Integer> a = new Node<>(92);
        final Node<Integer> b = new Node<>(118);
        final Node<Integer> c = new Node<>(121);
        final Node<Integer> d = new Node<>(119);
        final Node<Integer> e = new Node<>(125);
        node.insert(a, b, c, d, e);
        final String expected = "92, 100, 119, 121, 125";

        node.remove(118);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_NodeWithOneLeftChild() {
        final Node<Integer> a = new Node<>(92);
        final Node<Integer> b = new Node<>(118);
        final Node<Integer> c = new Node<>(121);
        final Node<Integer> d = new Node<>(119);
        final Node<Integer> e = new Node<>(125);
        final Node<Integer> f = new Node<>(-4);
        final Node<Integer> g = new Node<>(93);
        final Node<Integer> h = new Node<>(-10);
        node.insert(a, b, c, d, e, f, g, h);
        final String expected = "-10, 92, 93, 100, 118, 119, 121, 125";

        node.remove(-4);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_RightNodeWithOneLeftChild() {
        final Node<Integer> a = new Node<>(92);
        final Node<Integer> b = new Node<>(118);
        final Node<Integer> c = new Node<>(121);
        final Node<Integer> d = new Node<>(119);
        final Node<Integer> e = new Node<>(125);
        final Node<Integer> f = new Node<>(-4);
        final Node<Integer> g = new Node<>(93);
        final Node<Integer> h = new Node<>(-10);
        final Node<Integer> i = new Node<>(124);
        node.insert(a, b, c, d, e, f, g, h, i);
        final String expected = "-10, -4, 92, 93, 100, 118, 119, 121, 124";

        node.remove(125);

        assertEquals(expected, node.treeAsString());
    }

    @Test
    public void remove_LeftNodeWithOneRightChild() {
        final Node<Integer> a = new Node<>(92);
        final Node<Integer> b = new Node<>(118);
        final Node<Integer> c = new Node<>(121);
        final Node<Integer> d = new Node<>(119);
        final Node<Integer> e = new Node<>(125);
        final Node<Integer> f = new Node<>(-4);
        final Node<Integer> g = new Node<>(93);
        final Node<Integer> h = new Node<>(-3);
        final Node<Integer> i = new Node<>(124);
        node.insert(a, b, c, d, e, f, g, h, i);
        final String expected = "-3, 92, 93, 100, 118, 119, 121, 124, 125";

        node.remove(-4);

        assertEquals(expected, node.treeAsString());
    }
}