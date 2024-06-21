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
public class Tree {

    Node root;

    Tree() {
        root = null;
    }

    // Insert a node with value x into the BST
    void insert(int x) {
        root = insertRec(root, x);
    }

    Node insertRec(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }

        if (x < root.data) {
            root.left = insertRec(root.left, x);
        } else if (x > root.data) {
            root.right = insertRec(root.right, x);
        } else {
            System.out.println("The key " + x + " already exists, no insertion");
        }

        return root;
    }

    // Visit a node (in this case, print the node's data)
    void visit(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
        }
    }

    // PreOrder traversal
    void preOrder(Node p) {
        if (p != null) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    // InOrder traversal
    void inOrder(Node p) {
        if (p != null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    // PostOrder traversal
    void postOrder(Node p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    // Search for a node with value x
    Node search(int x) {
        return searchRec(root, x);
    }

    Node searchRec(Node root, int x) {
        if (root == null || root.data == x) {
            return root;
        }
        if (root.data > x) {
            return searchRec(root.left, x);
        }
        return searchRec(root.right, x);
    }

    // Delete a node by merging
    void deleteByMerging(int x) {
        Node p = root, f = null;

        while (p != null) {
            if (p.data == x) {
                if (p.left == null && p.right == null) {
                    deleteLeaf(f, p);
                } else if (p.left == null || p.right == null) {
                    delete1Child(f, p);
                } else {
                    delete2Children(f, p);
                }
                return;
            } else if (x > p.data) {
                f = p;
                p = p.right;
            } else {
                f = p;
                p = p.left;
            }
        }

        System.out.println("The key " + x + " does not exist, no deletion");
    }

    void deleteLeaf(Node f, Node p) {
 //TH 1 root leaf == x
        if (f == null) {
            root = null;
        } else if (f.left == p) {
            f.left = null;
        } else {
            f.right = null;
        }
    }

    void delete1Child(Node f, Node p) {
        Node child = (p.left != null) ? p.left : p.right;
        if (f == null) {
            root = child;
        } else if (f.left == p) {
            f.left = child;
        } else {
            f.right = child;
        }
    }

    void delete2Children(Node f, Node p) {
         Node rightmost = p.left;
        if(f==null){
            root=rightmost;
            root.right=p.right;
            return;
        }
       
        // Find the rightmost node in the left subtree
        while (rightmost.right != null) {
            rightmost = rightmost.right;
        }

        // Attach the right subtree to the rightmost node of the left subtree
        rightmost.right = p.right;

        // Update the parent's pointer to the new root of the modified subtree
        if (f.left == p) {
            f.left = p.left;
        } else {
            f.right = p.left;
        }
    }

    void deleteMer(int x) {
        Node result =deleteMerRec(root, x);
        if(result==null){
            System.out.println("x is not exist");
        }
        else{
            System.out.println("Delete success");
        }
    }

    Node deleteMerRec(Node node, int x) {
        if (node == null) {
            return null;
        }
        if (x < node.data) {
            node.left = deleteMerRec(node.left, x);
        } else if (x > node.data) {
            node.right = deleteMerRec(node.right, x);
        } else {
            // Node to be deleted found
            if (node.left == null && node.right == null) {
                // Case 1: Leaf node
                return null;
            } else if (node.left == null) {
                // Case 2: Node with one child (right)
                return node.right;
            } else if (node.right == null) {
                // Case 2: Node with one child (left)
                return node.left;
            } else {
                // Case 3: Node with two children
                // Find the rightmost node in the left subtree
                Node rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Attach the right subtree to the rightmost node of the left subtree
                rightmost.right = node.right;

                // Replace node with its left subtree
                node = node.left;
            }
        }

        return node;
    }

    // Delete a node by copying
    void deleteByCopying(int x) {
        root = deleteByCopyingRec(root, x);
    }

    Node deleteByCopyingRec(Node node, int x) {
        if (node == null) {
            return node;
        }

        if (x < node.data) {
            node.left = deleteByCopyingRec(node.left, x);
        } else if (x > node.data) {
            node.right = deleteByCopyingRec(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node temp = minValueNode(node.right);
            node.data = temp.data;
            node.right = deleteByCopyingRec(node.right, temp.data);
        }

        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
