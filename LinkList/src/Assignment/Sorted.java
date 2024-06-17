/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class Sorted {

    Node head;
    Node tail;
    Node maxNode2 = head;

    public Sorted() {
        head = tail = null;
    }

    public void addtoHead(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void traverse() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println("");
    }

    public int findMaxAndDelete() {
        Node previous = null;
        Node preMax = null;
        Node maxNode = head;
        Node current = head;
        while (current != null) {
            if (current.data > maxNode.data) {
                maxNode = current;
                preMax = previous;
            } else {
                previous = current;
                current = current.next;
            }

        }
        if (preMax == null) {
            head = maxNode.next;
        } else {
            preMax.next = maxNode.next;
        }
        if (maxNode == tail) {
            tail = preMax;
        }
        return maxNode.data;

    }

    public int findMaxAndDelete2() {
        Node preMax = null;
        Node maxNode = head;
        Node current = head;
        while (current.next != null) {
            if (current.next.data > maxNode.data) {
                maxNode = current.next;
                preMax = current;
            } else {
                current = current.next;
            }
        }
        if (maxNode == head) {
            head = maxNode.next;
        } else {
            preMax.next = maxNode.next;
        }
        if (maxNode == tail) {
            tail = preMax;
        }
        return maxNode.data;
    }

    public void sorted1() {
        if (head == null) {
            System.out.println("List is Empty!!!");
            return;
        }
        if (head.next == null) {
            System.out.println("1 Node");
            return;
        }
        Sorted listSort = new Sorted();
        while (head != null) {
            int max = findMaxAndDelete();
            listSort.addtoHead(max);
        }
        head = listSort.head;
        tail = listSort.tail;

    }

    public void sorted2() {
        if (head == null) {
            System.out.println("List is Empty!!!");
            return;
        }
        if (head.next == null) {
            System.out.println("1 Node");
            return;
        }
        Sorted listSort2 = new Sorted();
        while (head != null) {
            int max = findMaxAndDelete2();
            listSort2.addtoHead(max);
        }
        head = listSort2.head;
        tail = listSort2.tail;

    }

}
