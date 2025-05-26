package com.example.util;


import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {


    private class Node {
        E data;
        Node next;

        Node(E e) {
            this.data = e;
        }
    }

    Node head;
    Node tail;

    public void add(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public String get(int index) {
        ///..
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        class It implements Iterator<E> {
            Node temp=head;

            @Override
            public boolean hasNext() {
                if (temp != null)
                    return true;
                else return false;
            }

            @Override
            public E next() {
                E data = (E) temp.data;
                temp = temp.next;
                return data;
            }
        }
        return new It();
    }

}
