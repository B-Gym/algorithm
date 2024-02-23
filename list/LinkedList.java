package list;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E date;
        private Node<E> next;

        Node(E data, Node<E> next) {
            // System.out.println("data: " + data);
            // System.out.println("next: " + next);
            this.date = data; // 데이터
            this.next = next; // 다음 노드 참조
        }
    }

    private Node<E> head; // 머리 노드
    private Node<E> crnt; // 현재 선택한 노드

    public LinkedList() {
        head = crnt = null;
    }

    public E serach(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.date) == 0) { // success search
                crnt = ptr;
                return ptr.date;
            }
            ptr = ptr.next;
        }
        return null; // fail search
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node<E> ptr = head;
                Node<E> prev = head;

                while (ptr.next != null) {
                    prev = ptr;
                    ptr = ptr.next;
                }
                prev.next = null;
                crnt = prev;
            }
        }
    }

    public void remove(Node p) {
        if (head != null) {
            if (p == head)
                removeFirst();
            else {
                Node<E> ptr = head;
                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null)
                        return;
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while (head != null)
            removeFirst();
        crnt = null;
    }

    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.date);
    }

    public void dump() {
        Node<E> ptr = head;
        // System.out.println("pointer: " + ptr);
        while (ptr != null) {
            System.out.println(ptr.date);
            ptr = ptr.next;
        }
    }
}
