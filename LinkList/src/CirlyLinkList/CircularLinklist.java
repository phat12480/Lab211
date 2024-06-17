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
public class CircularLinklist {
    public static void main(String[] args) {
        MyList clist=new MyList();
        
        clist.addFirst(10);
        clist.addFirst(20);
        clist.addFirst(30);
        clist.disPlayList();
        
        clist.addLast(40);
        clist.addLast(50);
        clist.addLast(60);
        clist.disPlayList();
        
        
        
    }
  
}
