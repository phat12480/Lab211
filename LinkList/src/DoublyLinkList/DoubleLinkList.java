package DoublyLinkList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class DoubleLinkList {

    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(9);
        list.add(3);
        list.add(2);
        list.add(6);
        list.traverse();
      
        list.Sort();
        list.traverse();
        list.delete(3);
        list.traverse();
        list.delete(9);
        list.traverse();
        list.delete(2);
        list.traverse();

    }

}
