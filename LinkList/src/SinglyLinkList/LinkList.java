/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglyLinkList;

/**
 *
 * @author ADMIN
 */


public class LinkList {
    
    public Node Search(int x, Node pred){
        Node curren=head;
        pred.next=null;
        while(curren!=null){
            if(curren!=null && curren.data!=x){
                pred.next=curren;
                curren=curren.next;
            }
        }
        return curren;
    }
    
    Node head;
    Node tail;

    public LinkList() {
        head = tail = null;
    }

    public LinkList(int[] i) {
    head=tail=null;
        for (int j : i) {
            addToTail(j);
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertAfter(Node newElement, Node pred) {
        if (pred != null) {
            newElement.next = pred.next;
            pred.next = newElement;
        } else {
            newElement.next = head;
            head = newElement;

        }
        if (pred == tail) {
            tail = newElement;
        }
    }
    public void removeAfter(Node pred){
        Node tmp;
        if(pred!=null){
            tmp=pred.next;
            pred.next=tmp.next;
            
        }
        else{
            tmp=head;
            head=tmp.next;
        }
        if(tmp == tail){
            tail=pred;
        }
        
    }

    public void deleteToHead(){
        removeAfter(null);
    }
    public void deleteToTail(){
        removeAfter(head);
    }

    public void addToTail(int x) {
        Node newElement = new Node(x);
        insertAfter(newElement, tail);
    }

    public void addToHead(int x) {
        Node newElement = new Node(x);
        insertAfter(newElement, null);
    }

    public boolean isIncreaSorted(){
        Node t=head;
        while (t.next!=null) {            
            if(t.data>t.next.data){
                return false;
            }
            t=t.next;
        }
        return true;
    }
    public void reverse(){
        Node t=head.next;
        tail=head.next=null;
        while (t!=null) {            
            Node sau=t.next;
            insertAfter(t, null);
            t=sau;
        }
    }
    public void insertSort(){
        Node curren=head.next;
        tail=head.next=null;
        while(curren!=null){
            Node sau=curren.next;
            Node pos=head;
            Node pred = new Node(null);
            while(pos!=null && pos.data < curren.data){
                pred.next=pos;
                pos=pos.next;
            }
            insertAfter(curren, pred.next);
            curren=sau;
        }
    }
    @Override
    public String toString() {
        String s="";
        for (Node t = head; t != null; t=t.next) {
            s+=t;
        }
        return s;
    }
    
}
