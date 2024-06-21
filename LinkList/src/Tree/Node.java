/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author User
 */
public class Node {

    int data;
    Node left, right;

    Node() {
    }

    Node(int x, Node p, Node q) {
        this.data = x;
        left = p;
        right = q;
    }

    Node(int x) {
        this.data = x;
        left = null;
        right = null;
    }

}
