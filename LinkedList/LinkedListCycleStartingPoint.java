/* Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list. */

package LinkedList;

import java.util.HashMap;

public class LinkedListCycleStartingPoint {
    // Brute Force Approach - TC -> O(N * 2 * log(N)), SC -> O(N)
    public LLNode startPoint(LLNode head) {
        HashMap<LLNode, Integer> map = new HashMap<>();
        LLNode temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }

            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    // Optimal Approach(ortoise and Hare Algorithm) - TC -> O(N), SC -> O(1)
    // If there is a loop in LL, then there must be a point where slow and fast
    // pointers will collide
    public LLNode startPointOptimal(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
