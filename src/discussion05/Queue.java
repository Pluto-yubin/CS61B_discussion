package discussion05;

/**
 * @auther Zhang Yubin
 * @date 2022/1/7 0:42
 */

import java.util.Stack;

/**
 * Define a Queue class that implements the push and poll methods of a queue ADT
 * using only a Stack class which implements the stack ADT.
 * @param <E>
 */
public class Queue<E> {

    private Stack<E> stack = new Stack<>();

    public void push(E elem) {
        stack.push(elem);
    }

    public E pop() {
        return pop(stack.pop());
    }

    // Beautiful recursion by only one stack
    public E pop(E e) {
        if (stack.isEmpty()) {
            return e;
        }

        E current = stack.pop();
        E toReturn = pop(current);
        push(current);
        return toReturn;
    }
}
