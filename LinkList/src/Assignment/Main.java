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
public class Main {

    public static void main(String[] args) {
        Agorithm arm = new Agorithm();
        Node n=new Node(2);

        //add
        arm.addToHead(5);
        arm.addToHead(6);
        arm.addToTail(2);
        arm.addToTail(1);
       
        arm.addMyHead(12);
        arm.addMyTail(13);
       
        arm.traverse();
        arm.sorted();
        arm.traverse();
        
        Node previousNode = arm.findpreviousNode(1);
        arm.addAfter(previousNode, 5);
        arm.traverse();
        arm.addToHead(5);
        arm.addToHead(6);
        arm.addToTail(2);
        arm.addToTail(1);
        arm.traverse();
        arm.addBefore(n, 5);
        arm.traverse();
        //delete
        arm.deletefromHead();
        arm.traverse();
        System.out.println(arm.deleteFromTail());
        arm.traverse();
        System.out.println(arm.deleteAfter(previousNode));
        arm.traverse();
        arm.deleteValue(5);
        arm.traverse();
        System.out.println(arm.search(5));
        System.out.println(arm.search(2));
        arm.deleteIndex(2);
        arm.traverse();
        arm.traverse();
        arm.sort();
        arm.traverse();
        arm.deleteNode(previousNode);
        arm.deleteNode(previousNode);
        arm.traverse();
        //
        int [] arr=arm.toArray();
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(""+arr[i]);
        }
        System.out.println("");
        System.out.println(arm.max());
        System.out.println(arm.min());
        System.out.println(arm.sum());
        System.out.println(arm.avg());
        arm.traverse();
        arm.reverse();
        arm.traverse();
    }
}
