package DoublyLinkList;

import org.omg.CORBA.Current;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;

    //
    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void add(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null, null);
        } else {
            Node q = new Node(x, tail, null);
            tail.next = q;
            tail = q;
        }
    }

    public void delete(int x) {
        Node current = head;
        while (current != tail) {
            if (current == tail) {
                tail = current.previous;
                current.previous.next = null;
                break;
            }
            if (head.data == x) {
                head = head.next;
                head.next.previous = null;
                break;
            } else {
                current.previous.next = current.next;
                current.next.next.previous = current.previous;
            }
        }
    }

    public void traverse() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println("");
    }

    public void search(int x) {

        for (Node current = head; current != null; current = current.next) {
            if (current.data == x) {
                System.out.println(current.data + " ");
            }
        }
        System.out.println("");
    }

    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node current = null;
        Node max = null;

        do {
            swapped = false;
            current = head;

            while (current.next != max) {
                if (current.data > current.next.data) {
                    Node after = current.next;
                    swapNodes(current, after);
                    swapped = true;

                } else {
                    current = current.next;
                }
            }
            max = current;
        } while (swapped);
    }

    private void swapNodes(Node current, Node after) {

        if (current == head) {
            head = head.next;
        } else {
            current.previous.next = after;
        }

        if (after != tail) {
            after.next.previous = current;
        }

        current.next = after.next;
        after.previous = current.previous;
        after.next = current;
        current.previous = after;

    }

}
