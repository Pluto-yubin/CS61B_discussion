package discussion06;

/**
 * @auther Zhang Yubin
 * @date 2022/1/21 20:03
 */
public class BadIntegerStack {
    public class Node {
        public Integer value;
        public Node prev;

        public Node(Integer value, Node prev) {
            this.value = value;
            this.prev = prev;
        }

    }
    public Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer num) {
        top = new Node(num, top);
    }

    public Integer pop() {
        Integer ans = top.value;
        top = top.prev;
        return ans;
    }

    public Integer peek() {
        return top.value;
    }

    public static void main(String[] args) {
        /*
        (a) Exploit the flaw by filling in the main method below so that it prints “Success”
            by causing BadIntegerStack to produce a NullPointerException.
         */
        try {
            BadIntegerStack stack = new BadIntegerStack();
            stack.pop();
        } catch (NullPointerException e) {
            System.out.println("Success");
        }

        /*
        (b) Exploit another flaw in the stack by completing the main method below so that
            the stack appears infinitely tall.
         */

        BadIntegerStack stack = new BadIntegerStack();
        stack.push(1);
        stack.top.prev = stack.top;
    }
}
