/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Prototype pro=new Prototype("win10", "word2003", "bkas", "chrome", "v69");
        Prototype pro2=pro.clone();
        pro2.setOthers("skype");
        System.out.println(pro);
        System.out.println(pro2);
        
    }
}
