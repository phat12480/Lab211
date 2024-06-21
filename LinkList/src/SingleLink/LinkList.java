/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLink;

/**
 *
 * @author User
 */
public class LinkList {

    Node head;
    Node tail;


    
    
    public LinkList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    public void add(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);

        } else {
            Node newNode = new Node(x, null);
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void traverse() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println("");
    }

    public void delete(int x) {
        if (isEmpty()) {
            System.out.println("lsit empty");
            return;
        }
        //B1: check head==x
        Node current = head;
        while (current.next != null) {
            if (head.data == x) {
                if (head.next == null) {
                    clear();
                } else {
                    head = head.next;
                }
            } //B2: check current.next==tail (check tail)
            else if (current.next.data == x) {
                if (current.next == tail) {
                    tail = current;
                    current.next = null;
                    break;
                } else {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
    }



    public void search(int x) {
        int check = 0;
        for (Node current = head; current != null; current = current.next) {
            if (current.data == x) {
                System.out.println(current.data);
                check++;
            }
        }
        if (check == 0) {
            System.out.println("No have Node");
        }
    }

    public void Sort() {
        if (isEmpty()) {
            System.out.println("lsit empty");
            return;
        }
        if (head.next == null) {
            System.out.println("1 Node");
            return;
        }
        Node current, pre = null;
        boolean swap;
        Node max = null;
        do {
            swap = false;
            current = head;
            pre = null;
            //B1: check current==head
            while (current.next != max) {
                if (current.data > current.next.data) {
                    if (current == head) {
                        head = head.next;
                    } else {
                        pre.next = current.next;
                    }
                    //B2: retail line
                   Node tmp = current.next.next;
                   if(tmp==null){
                       tail=current;
                   }
                    current.next.next = current;
                    current.next = tmp;
                    //B3: update pre
                    if (pre == null) {
                        pre = head;
                    } else {
                        pre = pre.next;
                    }
                    swap = true;
                } else {
                    pre = current;
                    current = current.next;
                }
            }
            max = current;
        } while (swap);
    }

}
