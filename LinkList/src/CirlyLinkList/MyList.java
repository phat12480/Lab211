/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CirlyLinkList;

/**
 *
 * @author ADMIN
 */
public class MyList {

    public Node head = null, tail = null;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void disPlayList() {
        Node current = head;
        if (head == null) {
            System.out.println("list is empty");
            return;
        } else {
            while (current != head) {
                System.out.println(" " + current.data);
                current = current.next;
            }
            System.out.println("");
        }

    }

}
