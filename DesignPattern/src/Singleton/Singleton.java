/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author ADMIN
 */
public class Singleton {
    
    private static Singleton instance;
    public int value;
    private Singleton(int x) {
        this.value=x;
    }

    public static Singleton getInstance(int x) {
        if (instance == null) {
            instance = new Singleton(x);
        }
        return instance;
    }

}
