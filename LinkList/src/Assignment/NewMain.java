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
public class NewMain {

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        Solution solution = new Solution();
        Node resultHead = solution.sortAndDeleteMaxValue(head);

// In danh sách liên kết sau khi thực hiện
        Node current = resultHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
