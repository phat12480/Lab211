/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglyLinkList;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class MyList {

    public Node head = null, tail = null;

    public void addtoHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addtoTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAfter(Node p, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            System.out.println("list is empty");
            return;
        } else {
            newNode.next = p.next;
            p.next = newNode;
        }

    }

    public int count() {
        Node current = head;
        int count = 0;
        if (current == null) {
            return 0;
        } else {
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;

    }

    public void deleFirst() {
        Node newNode = head;
        if (newNode == null) {
            return;
        }
        if (newNode.next == null) {
            newNode = null;

        } else {
            head = newNode.next;
        }
    }

    public void deleLast() {
        Node newNode = head;
        if (newNode == null) {
            return;
        }
        if (newNode.next == null) {
            newNode = null;

        } else {
            Node tmp=new Node();
            tmp = newNode;
            while (tmp.next.next != null) {
                tmp = tmp.next;
            }
            Node lastNode = tmp.next;
            tmp.next = null;
            lastNode = null;
        }
    }

    public void deleAfter(Node p) {
        Node newNode = p.next;
        if (newNode == null) {
            return;
        }
        if (newNode.next == null) {
            newNode = null;

        } else {
            p.next = newNode.next;
            newNode.next = null;
        }
    }

    public void deleIndex(int i) {
        if (i < 0) {
            System.out.println("i < 0 invalid");
            return;
        }
        if (i == 0) {
            if (head == null) {
                System.out.println("list is empty");
                return;
            } else {
                head = head.next;
                return;
            }
        }
        Node current = head;
        int count = 0;

        while (current != null && count < i - 1) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            System.out.println("invalid index");
            return;
        }
        Node newNode = current.next;
        current.next = newNode.next;
        newNode.next = null;
    }

    public void disPlayList() {
        Node current = head;
        while (current != null) {
            System.out.println(" " + current.data);
            current = current.next;

        }
        System.out.println("");
    }

    public boolean Search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return true;
            }

            current = current.next;

        }
        return false;
    }

}
