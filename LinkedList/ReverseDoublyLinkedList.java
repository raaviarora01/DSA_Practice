package LinkedList;

import java.util.Stack;

/*Given the head of a singly linked list,reverse the list,and return the reversed list.*/

public class ReverseDoublyLinkedList {
    public static DLNode bruteForceApproach(DLNode head) {

        // Brute force approach - Using stack - T(C) -> O(2N), SC -> O(N)
        DLNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;

    }

    public static DLNode optimalIterativeApproach(DLNode head) {

        // Optimal Approach - Reversing in place(Iterative Approach) - TC -> O(N), SC
        // -> O(1)
        if (head == null || head.next == null) {
            return head;
        }

        DLNode current = head;
        DLNode back = null;
        while (current != null) {
            back = current.prev;
            current.prev = current.next;
            current.next = back;
            current = current.prev;
        }
        return back.prev;

    }
}
