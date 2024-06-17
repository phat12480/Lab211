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

    public void sort1() {
        if (isEmpty() || head.next == null) {
            // Stack is empty or has only one element, no need to sort
            return;
        }

        LinkStack sortedStack = new LinkStack();
        while (!isEmpty()) {
           Node temp = (Node) pop();
            while (!sortedStack.isEmpty() && (sortedStack.top().equals(temp))) {
                push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        // Copy the sorted elements back to the original stack
        while (!sortedStack.isEmpty()) {
            push(sortedStack.pop());
        }
    }
    public void sort() {
        if (isEmpty() || head.next == null) {
            // Stack is empty or has only one element, no need to sort
            return;
        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            Node current = head;
            Node prev = null;
            while (current.next != null) {
                if (current.data.equals(current.next.data)) {
                    // Swap the adjacent elements
                    Node nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;
                    if (prev == null) {
                        // Update head if the first element was swapped
                        head = nextNode;
                    } else {
                        prev.next = nextNode;
                    }
                    // Update the current node as the swapped node
                    prev = nextNode;
                    sorted = false;
                } else {
                    // Move to the next pair of elements
                    prev = current;
                    current = current.next;
                }
            }
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

    public boolean search(Object target) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(target)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
     public boolean search1(Object target) {
        LinkStack tempStack = new LinkStack();
        boolean found = false;

        while (!isEmpty()) {
            Object element = pop();
            if (element.equals(target)) {
                found = true;
            }
            tempStack.push(element);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }

        return found;
    }
    
    
}


