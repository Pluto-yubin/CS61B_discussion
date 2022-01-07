package discussion05.exam;

/**
 * @auther Zhang Yubin
 * @date 2022/1/7 17:01
 */

import java.util.Stack;

/**
 * Suppose we wanted a data structure SortedStack that takes in integers, and
 * maintains them in sorted order. SortedStack supports two operations: push(int
 * i) and pop(). Pushing puts an int onto our SortedStack, and popping returns
 * the next smallest item in the SortedStack. For example, if we inserted 10, 4, 8,
 * 2, 14, and 3 into a SortedStack, and then popped everything off, we would get
 * 2, 3, 4, 8, 10, 14.
 */
public class SortedStack<T extends Comparable<T>> {
    private Stack<T> stack = new Stack<>();
    private Stack<T> temp = new Stack<>();

    public void push(T elem) {
        if (stack.isEmpty()) {
            stack.push(elem);
        } else {
            while (elem.compareTo(stack.peek()) < 0) {  // element is smaller than stack's top elem
                temp.push(stack.pop());
            }
            stack.push(elem);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }

    public T pop() {
        return stack.pop();
    }
}
