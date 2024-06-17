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
public class Solution {
   public Node sortAndDeleteMaxValue(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node maxNode = null;

        while (head != null) {
            // Tìm node có giá trị lớn nhất
            maxNode = head;
            prev = head;
            while (head.next != null) {
                if (head.next.data > maxNode.data) {
                    maxNode = head.next;
                    prev = head;
                }
                head = head.next;
            }

            // Loại bỏ node có giá trị lớn nhất và đưa nó lên đầu
            prev.next = maxNode.next;
            maxNode.next = dummy.next;
            dummy.next = maxNode;
        }

        return dummy.next;
    }
}
