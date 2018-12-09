package com.company.generics;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> l = new MyArrayList<String>();
        l.add("я");
        l.add("уку");
        l.add("121");
        l.add("111111");
        l.add("God plan");
        MyArrayList<String> l2 = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            l2.add("" + i);
        }

        //classic using iterator of MyArrayList
        Iterator<String> iter = l.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
