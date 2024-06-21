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
        if (isEmpty()) {
            System.out.println("list empty");
            return;
        }
        Node current = head;
//B1: check head ==x
        while (current.next != null) {
            if (head.data == x) {
                if (head.next == null) {
                    clear();
                } else {
                    head = head.next;
                    head.previous = null;
                }
                //B2: check current.next==data (check tail)
            } else if (current.next.data == x) {
                if (current.next == tail) {
                    tail = current;
                    current.next = null;
                    break;
                } else {
                    Node tmp = current.next;
                    current.next = tmp.next;
                    tmp.previous = current.previous;
                }
            } else {
                current = current.next;
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

    public void Sort() {
        if (isEmpty()) {
            System.out.println("list empty");
            return;
        }
        if (head.next == null) {
            System.out.println("1 Node");
            return;
        }

        boolean swap;
        Node max = null;
        Node current = null;
        do {
            swap = false;
            current = head;
//B1: check current == head
            while (current.next != max) {
                if (current.data > current.next.data) {
                    Node after = current.next;
                    if (current == head) {
                        head = head.next;
                    } else {
                        current.previous.next = after;
                    }
//B2: check current==tail and retail line
                    Node tmp = current.next.next;
                    if (tmp != null) {
                        tmp.previous = current;
                    }
                    current.next = after.next;
                    after.previous = current.previous;
                    after.next = current;
                    current.previous = after;

                    swap = true;
                } else {
                    current = current.next;
                }
            }
            max = current;
        } while (swap);
    }
}
