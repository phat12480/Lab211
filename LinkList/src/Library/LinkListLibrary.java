/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.*;
// * replaces all

/**
 *
 * @author ADMIN
 */
public class LinkListLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> llist = new LinkedList<>();
        
        llist.add("B");
        llist.add("C");
        llist.addLast("G");
        llist.addFirst("A");
        llist.add(3, "D");
        llist.add("E");
        llist.add("F");
        System.out.println("Linklist: ");
        System.out.println(llist);
        //
        
        ArrayList<String> alist = new ArrayList<>();
        
        alist.add("a");
        alist.add("i");
        
        llist.addAll(alist);
        System.out.println("LinkList and arraylist: ");
        System.out.println(llist);
        
        llist.remove("B");
        llist.remove(3);
        llist.removeFirst();
        llist.removeLast();
        System.out.println("Linklist removing");
        System.out.println(llist);
        //
        boolean check = llist.contains("G");
        if (check) {
            System.out.println("G exist");
        } else {
            System.out.println("G not exist");
        }
        //
        int size = llist.size();
        System.out.println("size= " + size);
        
        Object e = llist.get(3);
        System.out.println(e);
        llist.set(3, "J");
        System.out.println("Linklist Set");
        System.out.println(llist);
        //
        
        String[] array = llist.toArray(new String[size]);
        System.out.println("Array convert to linklist");
        System.out.println(Arrays.toString(array));
        
    }
    
}
