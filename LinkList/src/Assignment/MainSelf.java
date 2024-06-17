/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author ADMIN
 */
public class MainSelf {
    public static void main(String[] args) {
        LinkListSelf s=new LinkListSelf();
        Node n=new Node(5);
       Solution so=new Solution();
        s.addToHead(3);
        s.addToHead(4);
        s.addToHead(5);
        s.addToTail(7);
        s.addToTail(8);
        s.addAfterNode(9, n);
        s.detelefromHead();
        s.detelefromTail();
        s.addToHead(5);
        s.deleteAfterNode(n);
        s.detelefromHead();
        s.addToHead(9);
        s.addToHead(6);
       
        s.traverse();
        s.sort();
        s.traverse();

     
        
        
    }
        
        
        
        
        
        
    }

