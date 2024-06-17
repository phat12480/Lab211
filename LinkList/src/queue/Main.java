/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.display();
        
    }
}
