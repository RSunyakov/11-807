package com.company.generics;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
MyArrayList<Integer> list1;
MyArrayList<Integer> list2;

    @Before
    public void setup() {
        list1 = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(i);
        }
        list2 = new MyArrayList<>();
    }

    @Test
    public void testsize() {
        int expected = 20;
        int actual = 20;
        assertEquals(expected, actual);
    }

}
