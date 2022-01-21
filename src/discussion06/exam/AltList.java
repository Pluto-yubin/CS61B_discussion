package discussion06.exam;

/**
 * @auther Zhang Yubin
 * @date 2022/1/21 21:32
 */
public class AltList<X, Y> {
    private X item;
    private AltList<Y, X> next;

    AltList(X item, AltList<Y, X> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * This list represents [5 cat 10 dog]. In this list, assuming indexing begins at 0, all
     * even-index items are Integers and all odd-index items are Strings.
     * Write an instance method called pairsSwapped() for the AltList class that returns
     * a copy of the original list, but with adjacent pairs swapped. Each item should only
     * be swapped once. This method should be non-destructive: it should not modify the
     * original AltList instance.
     * For example, calling list.pairsSwapped() should yield the list [cat 5 dog 10].
     * There were two swaps: ”cat” and 5 were swapped, then ”dog” and 10 were swapped.
     * You may assume that the list on which pairsSwapped() is called has an even nonzero length. Your code should maintain this invariant.
     */


    public AltList<Y, X> pairsSwapped() {
        AltList<Y, X> res = new AltList<>(next.item, new AltList<>(item, null));
        if (next.next != null) {
            // 这真没想到
            res.next.next = next.next.pairsSwapped();
        }
        return res;
    }

    public static void main(String[] args) {
        AltList<Integer, String> list =
                new AltList<>(5,
                        new AltList<>("cat",
                                new AltList<>(10,
                                        new AltList<>("dog", null))));
        AltList<String, Integer> altList = list.pairsSwapped();
        System.out.println(altList);
    }
}
