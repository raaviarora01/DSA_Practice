package LinkedList;

import java.util.Stack;

/*Given the head of a singly linked list,reverse the list,and return the reversed list.*/

public class ReverseLinkedList {
    public static LLNode bruteForceApproach(LLNode head) {

        // Brute force approach - Using stack - T(C) -> O(2N), SC -> O(N)
        LLNode temp = head;
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

    public static LLNode optimalIterativeApproach(LLNode head) {

        // Optimal Approach 1 - Reversing in place(Iterative Approach) - TC -> O(N), SC
        // -> O(1)
        LLNode temp = head;
        LLNode back = null;
        while (temp != null) {
            LLNode front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }
        return back;

    }

    public static LLNode optimalRecursiveApproach(LLNode head) {

        // Optimal Approach 2 - Reversing in place(Recursice Approach) - TC -> O(N), SC
        // -> O(1)
        if (head == null || head.next == null)
            return head;

        LLNode newHead = optimalRecursiveApproach(head.next);

        LLNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
