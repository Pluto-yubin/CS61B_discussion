package discussion03.exam.prep;


/**
 * @auther Zhang Yubin
 * @date 2022/1/1 1:01
 */
public class IntList {
    /**
     * Suppose we have the following IntList class, as defined in lecture and lab, with an
     * added skippify function.
     * Suppose that we define two IntLists as follows.
     * 1 IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     * 2 IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
     * Fill in the method skippify such that the result of calling skippify on A and B
     * are as below:
     * - After calling A.skippify(), A: (1, 3, 6, 10)
     * - After calling B.skippify(), B: (9, 7, 4)
     */

    public int first;
    public IntList rest;
    public IntList(int item) {
        first = item;
    }
    public static IntList list(int... args) {
        IntList head = new IntList(0);
        IntList temp = head;
        for (int arg : args) {
            IntList node = new IntList(arg);
            temp.rest = node;
            temp = temp.rest;
        }
        return head.rest;
    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = p.rest;
            n += 1;
        }
    }

    @Override
    public String toString() {
        return "IntList{" +
                "first=" + first +
                ", rest=" + rest +
                '}';
    }

    /**
     * Given a sorted linked list of items - remove duplicates.
     * For example given 1 -> 2 -> 2 -> 2 -> 3,
     * Mutate it to become 1 -> 2 -> 3 (destructively)
     */
    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }
        IntList current = p.rest;
        IntList previous = p;
        // 好难
        while (current != null) {
            if (previous.first == current.first) {
                previous.rest = current.rest;
            } else {
                previous = current;
            }
            current = current.rest;
        }
    }

    public static void main(String[] args) {
        IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(A.toString());
        A.skippify();
        System.out.println(A.toString());
    }
}
