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
            head = tail = new Node(x, null);
        } else {
            Node newNode = new Node(x, null);
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void deleteValue(Object value) throws Exception {
        MyQueue tempQueue = new MyQueue();

        while (!isEmpty()) {
            Object element = dequeue();
            if (!element.equals(value)) {
                tempQueue.enqueue(element);
            }
        }

        while (!tempQueue.isEmpty()) {
            enqueue(tempQueue.dequeue());
        }
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

    public void sortQueue() throws Exception {
        if (isEmpty()) {
            // Queue is empty or has only one element, no need to sort
            return;
        }

        MyQueue sortedQueue = new MyQueue();
        while (!isEmpty()) {
            Object temp = dequeue();
            // Insert temp in sorted order into sortedQueue
            while (!sortedQueue.isEmpty() && (int) sortedQueue.front() < (int) temp) {
                enqueue(sortedQueue.dequeue());
            }
            sortedQueue.enqueue(temp);

        }

        // Copy the sorted elements back to the original queue
        while (!sortedQueue.isEmpty()) {
            enqueue(sortedQueue.dequeue());
        }
    }

    public int getSize() {
        Node p = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            i++;
        }

        return i;
    }

    public void sort() throws Exception {
        MyQueue q2 = new MyQueue();
        Object temp = null;
        Object min = null;
        Node p = head;
        int i = 0;
        int k = getSize();
        while (true) {
            i++;
            if (q2.isEmpty() || (Integer) front() <= (Integer) min) {
                min = front();
                q2.enqueue(dequeue());
            } else if ((Integer) front() > (Integer) min) {
                enqueue(dequeue());
            }
            if (isEmpty()) {
                while (!q2.isEmpty()) {
                    enqueue(q2.dequeue());
                }
                return;
            }
            if (i == k) {
                while (!q2.isEmpty()) {
                    enqueue(q2.dequeue());
                }
                i = 0;
                display();
            }

        }
    }
}
