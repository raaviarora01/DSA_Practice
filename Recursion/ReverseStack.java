/* You are given a stack of integers. Your task is to reverse the stack using recursion. You may only use standard stack operations (push, pop, top/peek, isEmpty). You are not allowed to use any loop constructs or additional data structures like arrays or queues.

Your solution must modify the input stack in-place to reverse the order of its elements.
 */

package Recursion;

import java.util.Stack;

public class ReverseStack {
    public void reverseStack(Stack<Integer> st) {
        if(!st.isEmpty()){
            int temp = st.pop();
            reverseStack(st);
            insertAtBottom(st, temp);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int temp){
        if(stack.isEmpty()){
            stack.push(temp);
            return;
        }

        int val = stack.pop();
        insertAtBottom(stack, temp);

        stack.push(val);
    }
}
