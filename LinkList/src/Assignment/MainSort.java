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
public class MainSort {

    public static void main(String[] args) {
        Sorted beginList = new Sorted();
        beginList.addtoHead(5);
        beginList.addtoHead(9);
        beginList.addtoHead(6);
        beginList.addtoHead(1);
        beginList.addtoHead(3);
        beginList.addtoHead(3);
        beginList.addtoHead(5);
        beginList.addtoHead(6);
        beginList.addtoHead(9);
        beginList.traverse();

        beginList.sorted2();
        beginList.traverse();

        beginList.sorted1();
        beginList.traverse();

    }
}
