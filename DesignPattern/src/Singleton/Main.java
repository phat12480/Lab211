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
public class Main {
    public static void main(String[] args) {
        System.out.println("single ton");
        Singleton s1=Singleton.getInstance(5);
        Singleton s2=Singleton.getInstance(6);
        if(s1.equals(s2)){
            System.out.println("unique instance");
        }
        System.out.println(s1.value);
        System.out.println(s2.value);
        
        Thread tfo=new Thread(new ThreadFoo());
        Thread tba=new Thread(new ThreadFbar());
        tfo.start();
        tba.start();
        
        
    }
    
    static class ThreadFoo implements Runnable{
        
        @Override
        public void run(){
            Singleton ss1=Singleton.getInstance(8);
            System.out.println(ss1.value);
        }
    }
        static class ThreadFbar implements Runnable{
        
        @Override
        public void run(){
            Singleton ss2=Singleton.getInstance(9);
            System.out.println(ss2.value);
        }
    }
}
