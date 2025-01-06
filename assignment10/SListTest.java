package com.assignment10;

import java.util.NoSuchElementException;

class Link<T> {
    private T data;
    private Link<T> next;

    public Link(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }
}

class SListIterator<T> {
    private Link<T> curr;
    private Link<T> prev;
    private SList<T> list;

    public SListIterator(SList<T> list) {
        this.curr = list.head;
        this.prev = null;
        this.list = list;
    }

    public boolean hasNext() {
        return curr != null;
    }

    public void next() {
        if (!hasNext())
            throw new NoSuchElementException("No more elements");
        prev = curr;
        curr = curr.getNext();
    }

    public void insert(T data) {
        Link<T> newLink = new Link<>(data);
        if (curr == null) {
            newLink.setNext(list.head);
            list.head = newLink;
            curr = newLink;
        } else {
            newLink.setNext(curr.getNext());
            prev = curr;
            prev.setNext(newLink);
            curr = curr.getNext();
        }
    }

    public void remove() {
        if (curr == null)
            throw new RuntimeException("Cannot remove at beginning");
        if (prev == null) {
            curr = curr.getNext();
            list.head = curr;
        } else {
            prev.setNext(curr.getNext());
            curr = prev.getNext();
        }
    }
}

class SList<T> {
    Link<T> head;

    public SList() {
        this.head = null;
    }

    public SListIterator<T> iterator() {
        return new SListIterator<>(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link<T> curr = head;
        while (curr != null) {
            sb.append(curr.getData()).append("->");
            curr = curr.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}

public class SListTest {
    public static void main(String[] args) {
        SList<Integer> list = new SList<>();
        SListIterator<Integer> iterator = list.iterator();

        // Adding elements
        iterator.insert(1);
        iterator.insert(2);
        iterator.insert(3);
        System.out.println("After Inserting 1,2,3: " + list);

        // Moving iterator and inserting an element
        iterator = list.iterator();
        iterator.insert(4);
        System.out.println("After inserting 4 after 1: " + list);

        // Removing an element
        iterator = list.iterator();
        iterator.remove();
        iterator.next();
        iterator.remove();
        System.out.println("After removing elements 1 and 2: " + list);
    }
}
