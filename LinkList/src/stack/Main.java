/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        LinkStack stack=new LinkStack();
        stack.push(5);
        stack.push(9);
        stack.push(7);
        stack.push(4);
        stack.push(7);
        stack.push(8);
        stack.display();
        stack.sort();
        stack.display();
        stack.delete(7);
        stack.display();
    }
}
