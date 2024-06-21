/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;

/**
 *
 * @author ADMIN
 */
public class LinkStack {

    protected Node head;

    public LinkStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(Object x) {
        head = new Node(x, head);
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (head.data);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = head.data;
        head = head.next;
        return (x);
    }

    public void sort() {
        LinkStack sortStack = new LinkStack();
        if (isEmpty()) {
            System.out.println("stack empty");
            return;
        }
        if (head.next == null) {
            System.out.println("1 stack");
            return;
        }
        while (!isEmpty()) {
            Object tmp = pop();
//B1: if object sorted < tmp : return stack
            while (!sortStack.isEmpty() && ((int) sortStack.top() < (int) tmp)) {
                push(sortStack.pop());
            }
//B2: else push tmp on sorted
            sortStack.push(tmp);
        }
        while (!sortStack.isEmpty()) {
            push(sortStack.pop());
        }

    }

    public void display() {
        Node current = head;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void delete(Object x) {
        if (isEmpty()) {
            return;
        }
        LinkStack tempStack = new LinkStack();
        while (!isEmpty()) {
            Object element = pop();
            if (!element.equals(x)) {
                tempStack.push(element);
            }
        }

        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }

    }

}
