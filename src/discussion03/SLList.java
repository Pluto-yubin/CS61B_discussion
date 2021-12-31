package discussion03;

/**
 * @auther Zhang Yubin
 * @date 2021/12/31 21:17
 */
public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /**
     * Implement SLList.insert which takes in an integer x and inserts it at the given
     * position. If the position is after the end of the list, insert the new node at the end.
     * For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2.
     */

    public void insert(int item, int position) {
        IntNode prev = first, next = first.next;
        if (position == 0) {
            first = new IntNode(item, first);
            return;
        }
        while (position != 1 && next != null) {
            prev = prev.next;
            next = prev.next;
            position -= 1;
        }
        IntNode node = new IntNode(item, null);
        prev.next = node;
        node.next = next;
    }

    public void printList() {
        IntNode node = first;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Add another method to the SLList class that reverses the elements. Do this using
     * the existing IntNodes (you should not use new).
     */
    public void reverse() {
        IntNode prev = null;
        IntNode node = first;
        while (node != null) {
            IntNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        first = prev;
    }

    /**
     * Extra: If you wrote reverse iteratively, write a second version that uses recursion
     * (you may need a helper method). If you wrote it recursively, write it iteratively.
     */

    public void reverseRecursively() {
        helpRecurse(first);
    }

    public IntNode helpRecurse(IntNode node) {
        if (node == null || node.next == null) {
            first = node;
            return node;
        }
        helpRecurse(node.next).next = node;
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        SLList list = new SLList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.insert(6, 4);
        list.insert(5, 1);
        list.insert(0, 0);

        list.printList();
        list.reverse();
        list.printList();
        list.reverseRecursively();
        list.printList();
    }

}
