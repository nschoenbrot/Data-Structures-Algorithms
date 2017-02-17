package com.gmail.nschoenbrot.dsa.types;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Nelson Schoenbrot
 */
public class ArrayListTest {
    private ArrayList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
    }

    @Test
    public void append_AddElements() throws Exception {
        list.append(1, 2, 3);
        assertEquals("1, 2, 3", list.listToString());
    }
}