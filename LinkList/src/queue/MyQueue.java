/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author ADMIN
 */
public class MyQueue {

    protected Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (head.data);

    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return (x);
    }

    void enqueue(Object x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }



    public void sort() {
        if (isEmpty() || head == tail) {
            return; // No need to sort if the queue is empty or has only one element
        }

        boolean swapped;
        Node current;
        Node nextNode = null;

        do {
            swapped = false;
            current = head;

            while (current.next != nextNode) {
                if (((Comparable) current.data).compareTo(current.next.data) > 0) {
                    // Swap the data of the current and next nodes
                    Object temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            nextNode = current;
        } while (swapped);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = head;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
