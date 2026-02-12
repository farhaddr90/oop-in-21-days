package com.dorri.week1.page121;

import java.util.ArrayList;
import java.util.List;

public class MyStack<E> {
    private final List<E> list;

    public MyStack() {
        list = new ArrayList<E>();
    }

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }
}