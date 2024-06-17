/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Agorithm {
    Node head;
    Node tail;
    public Agorithm() {
        head = tail = null;
    }
   public void sorted() {
        while (true) {
            Node head = null;
            Node P = head;
            boolean flag = true;
            while (P != null) {
                if (P.next.data<P.data) {
                    Node temp = P;
                    temp.data=P.data;
                    P.data = P.next.data;
                    P.next.data = temp.data;
                    flag = false;
                    P = P.next;
                }
            }
            if (flag == false)
		
                
                return;
        }

    }
    //add
    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = tail = newNode;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public void addMyHead(int x){
        Node newNode=new Node(x);
        if(head==null){
            head=tail=null;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }

    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = tail = null;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMyTail(int x){
        Node newNode=new Node(x);
        if(head==null){
            head=tail=null;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        
        
    }
    
    public void insertValue(int x) {
        Node newNode = new Node(x);
        int count=1;
        if (head == null) {
            System.out.println("link list empty");
            return;
        } else {
            Node cuurent = head;
            while (cuurent.next != null) {
                cuurent = cuurent.next;
                count++;
                if(count==3){
                    newNode.next=cuurent.next.next;
                     cuurent.next = newNode;
                     
                }
            }
           
            
        }
    }
    
    public void insertMyPosition(int x, int position){
            int count=1;
            Node newNode=new Node(x);
            Node current=head;
            Node previous=null;
            while (current.next!=null) {            
            current=current.next;
            count++;
            if(position==(count-1)){
                previous=current;
            }
            if(count==position){
                newNode.next=current;
                previous=newNode;
            }
        }
            
        
        
    }
    

    public void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("data null");
            return;
        }
        if (head == null) {
            System.out.println("link list null");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

    public void addBefore(Node p, int x) {
        if (head == null) {
            System.out.println("link list empty");
            return;
        }
        if (p == head) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current == p) {
                Node newNode = new Node(x);
                newNode.next = current;
                previous.next = newNode;
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("node not found");
    }

    //detele
    public int deletefromHead() {
        if (head == null) {
            System.out.println("link list empty");
            return -1;
        }
        if (head.next == null) {
            int deleteValue = head.data;
            head = null;
            return deleteValue;
        }
        int deleteValue = head.data;
        head = head.next;
        return deleteValue;
    }

    public int deleteFromTail() {
        if (head == null) {
            System.out.println("link list empty");
            return -1;
        }
        if (head.next == null) {
            int deleteValue = head.data;
            head = null;
            return deleteValue;
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        int deleteValue = current.data;
        previous.next = null;
        return deleteValue;
    }

    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("invalid node");
            return -1;
        }
        Node nodetoDelete = p.next;
        p.next = nodetoDelete.next;
        int deleteValue = nodetoDelete.data;
        return deleteValue;
    }

    public void deleteNode(Node p) {
        if (head == null) {
            System.out.println("link list empty");
            return;
        }
        if (p == head) {
            head = head.next;
            return;
        }
        Node current = head;
        Node prevuous = null;
        while (current != null) {
            if (current == p) {
                prevuous.next = current.next;
                return;
            }
            prevuous = current;
            current = current.next;
        }
        System.out.println("Node not found");
    }

    public void deleteValue(int x) {
        if (head == null) {
            System.out.println("link list empty");
            return;
        }
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && current.data != x) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("value not found");
            return;
        }
        previous.next = current.next;
    }

    public void deleteIndex(int i) {
        if (head == null) {
            System.out.println("link list empty");
            return;
        }
        if (i == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        int count = 1;
        while (current != null) {
            if (count == i) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
            count++;
        }
        System.out.println("in valid position" + i);
    }
    //other

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public Node findpreviousNode(int value) {
        Node current = head;
        Node previoud = null;
        while (current != null && current.data != value) {
            previoud = current;
            current = current.next;
        }
        return previoud;
    }

    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        Node cuurent;
        Node last = null;
        do {
            swapped = false;
            cuurent = head;
            while (cuurent.next != last) {
                if (cuurent.data > cuurent.next.data) {
                    int tmp = cuurent.data;
                    cuurent.data = cuurent.next.data;
                    cuurent.next.data = tmp;
                    swapped = true;
                }
                cuurent = cuurent.next;
            }
            last = cuurent;
        } while (swapped);
    }

    public int[] toArray() {
        int[] array = new int[10];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index] = current.data;
            current = current.next;
            index++;
        }
        return array;
    }

    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("link list empty");
            return;
        }
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
//calculate 

    public int max() {
        if (head == null) {
            System.out.println("link list empty");
            return -1;
        }
        int maxValue = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > maxValue) {
                maxValue = current.data;
            }
            current = current.next;
        }
        return maxValue;
    }

    public int min() {
        if (head == null) {
            System.out.println("link list empty");
            return -1;
        }
        int minValue = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < minValue) {
                minValue = current.data;
            }
            current = current.next;
        }
        return minValue;
    }

    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public double avg() {
        double sum = 0;
        double count = 0;
        Node cuurent = head;
        while (cuurent != null) {
            sum += cuurent.data;
            count++;
            cuurent = cuurent.next;
        }
        if (count == 0) {
            System.out.println("link list empty");
            return -1;
        }
        return sum / count;
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
