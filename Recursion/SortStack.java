/* You are given a stack of integers. Your task is to sort the stack in descending order using recursion, such that the top of the stack contains the greatest element. You are not allowed to use any loop-based sorting methods (e.g., quicksort, mergesort). You may only use recursive operations and the standard stack operations (push, pop, peek/top, and isEmpty). */

package Recursion;

import java.util.Stack;

public class SortStack {
    public void sortStack(Stack<Integer> st) {
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);;
            insert(st, temp);
        }
    }

    public static void insert(Stack<Integer> stack, int temp){
        if(stack.isEmpty() || temp >= stack.peek()){
            stack.push(temp);
            return;
        }

        int val = stack.pop();
        insert(stack, temp);

        stack.push(val);
    }
}
