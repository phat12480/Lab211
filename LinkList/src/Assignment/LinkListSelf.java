/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class LinkListSelf {

    Node head;
    Node tail;
    Node begin;

    public LinkListSelf() {
        head = tail = null;

    }

    public void traverse() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public void addToHead(int x) {
        Node newNode = new Node(x, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
 public Node addToHeadkup(Node head, int x) {
        Node newNode = new Node(x, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            
        }
        return newNode;
    }
    public void addToTail(int x) {
        Node newNode = new Node(x, null);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAfterNode(int x, Node p) {
        Node newNode = new Node(x, null);
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == p.data) {
                count++;

            }
            current = current.next;
        }
        if (count == 0) {
            System.out.println("Not found p");
            return;
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            if (head == p) {
                addToTail(x);
            }
        }

        Node tmp = head;
        while (tmp != null) {

            if (tmp.data == p.data) {

                newNode.next = tmp.next;
                tmp.next = newNode;
            }
            tmp = tmp.next;
        }

    }

    public void detelefromHead() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;

    }

    public void detelefromTail() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        tail = current;

    }

    public void deleteAfterNode(Node p) {
        Node check = head;
        int count = 0;
        while (check != null) {
            if (check.data != p.data) {
                count++;
            }
            check = check.next;
        }
        if (count == 0) {
            System.out.println("p not exist");
            return;
        }
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
        }

        Node current = head;
        while (current != null) {
            if (current.data == p.data) {
                current.next = current.next.next;

            }
            current = current.next;
        }
    }

    public void deleteValue(int x) {
        traverse();
        if(head==null) return;
        Node test=new Node(0);
        test.next=head;
        
        
        for (Node current = begin; current != null; current = current.next) {
            Node previous = current;
            if (current.next == null) {
                System.out.println("null");
                break;
            }
            if (current.next.data == x) {
                if (current.next == tail) {
                    previous.next = null;
                    previous = tail;
                } else {
                    previous.next = current.next.next;
                }
            }

        }

        traverse();
    }
    public Node deleteMaxValue(Node head, int maxValue) {
        if (head == null) {
            return null;
        }
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        
        while (curr != null) {
            if (curr.data == maxValue) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
    public void search(int x) {
        for (Node current = head; current != null; current = current.next) {
            if (x == current.data) {
                System.out.println(current);
            }
        }
    }

    public void sort() {
        if (head == null) {
            System.out.println("list empty");
            return;
        }
        if (head.next == null) {
            System.out.println("1Node sorted");
            return;
        }

        for (begin = head; begin != null;begin=begin.next ) {
            int max = max(begin);
            
            System.out.println("max " + max);
            addToHead(max);
            begin = head;

            deleteValue(max);

        }

    }

    public Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node curr = dummy;
        while (left != null && right != null) {
            if (left.data < right.data) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return dummy.next;
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Chia danh sách thành hai nửa
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;

        // Chia đệ quy và gộp lại
        Node left = sortList(head);
        Node right = sortList(mid);
        return merge(left, right);
    }

    public int count() {
        int count = 0;
        for (Node current = head; current != tail; current = current.next) {
            count++;
        }
        return count;
    }

    public int max(Node head) {
        int max = head.data;
        for (Node tmp = head.next; tmp != null; tmp = tmp.next) {
            if (tmp.data > max) {
                max = tmp.data;
            }
        }
        return max;
    }

    public void arr() {
        int arr[] = new int[10];
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = tmp.data;
                break;
            }
        }
        traverse();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr " + arr[i]);

        }
        System.out.println("");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = arr[j];
                    count++;
                }
                if (count == arr.length - 1) {
                    break;
                }

            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr " + arr[i]);

        }

    }

}
