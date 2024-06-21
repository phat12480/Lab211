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
public class Main {
public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inOrder(tree.root);

        System.out.println("\n\nDelete 20");
        tree.deleteByMerging(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrder(tree.root);

        System.out.println("\n\nDelete 30");
        tree.deleteByMerging(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrder(tree.root);

        System.out.println("\n\nDelete 50");
        tree.deleteByMerging(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrder(tree.root);
    }
}

