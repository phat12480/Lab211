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
public class Main {

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(2);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(1);
        list.traverse();
        list.delete(2);
        list.delete(4);
        list.delete(1);
        list.traverse();
        list.Sort();
        list.traverse();

    }
}
