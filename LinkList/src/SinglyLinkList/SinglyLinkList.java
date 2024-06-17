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
public class SinglyLinkList {

    public static void main(String[] args) {
        Node t = new Node(10);
        LinkList lt = new LinkList();
        lt.addToTail(6);
        lt.addToTail(3);
        lt.addToTail(4);
        lt.addToTail(1);

        if (lt.isEmpty()) {
            System.out.println("list is empty");
        } else {
            System.out.println("t= " + t);
        }
        
        lt.addToHead(0);
        LinkList lt2=new LinkList(new int[]{1,5,3,7});
        System.out.println(lt2);
        
        if(lt.isIncreaSorted()){
            System.out.println("sorted ");
        }
        else{
            System.out.println("not sorted");
        }
        lt.reverse();
        System.out.println(lt);
        
        
}
}