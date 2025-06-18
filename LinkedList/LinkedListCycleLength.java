/* Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false. */

package LinkedList;

import java.util.HashMap;

public class LinkedListCycleLength {
    // Brute Force Approach - TC -> O(N * 2 * log(N)), SC -> O(N)
    public int cycleLength(LLNode head) {
        HashMap<LLNode, Integer> map = new HashMap<>();
        LLNode temp = head;

        int i = 1;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return i - map.get(temp);
            }

            map.put(temp, i++);
            temp = temp.next;
        }
        return 0;
    }

    // Optimal Approach(ortoise and Hare Algorithm) - TC -> O(N), SC -> O(1)
    // If there is a loop in LL, then there must be a point where slow and fast
    // pointers will collide
    public int cycleLengthOptimal(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int cnt = 1;
                fast = fast.next;
                while (slow != fast) {
                    cnt++;
                    fast = fast.next;
                }

                return cnt;
            }
        }

        return 0;
    }
}
