package discussion05.exam;

import discussion03.Array;
import org.junit.Test;
import org.junit.Assert;
import java.util.*;

/**
 * @auther Zhang Yubin
 * @date 2022/1/7 16:15
 */
public class Solution {
    /**
     * a. Given an array of integers A and an integer k, return true if any two numbers
     * in the array sum up to k, and return false otherwise. How would you do this?
     * Give the main idea and what ADT you would use.
     */

    private static Solution solution = new Solution();

    public boolean twoSum(int[] A, int k) {
        Set<Integer> set = new HashSet<>();
        for (int integer : A) {
            if (set.contains(k - integer)) {
                return true;
            }
            set.add(integer);
        }
        return false;
    }

    @Test
    public void testTwoSum() {
        int[] a = {1, 2, 3};
        Assert.assertTrue(solution.twoSum(a, 5));
        Assert.assertFalse(solution.twoSum(a, 6));
    }

    /**
     * b. Find the k most common words in a document. Assume that you can represent
     * this as an array of Strings, where each word is an element in the array. You
     * might find using multiple data structures useful.
     */

    public String[] kMostWords(String[] strings, int k) {
        Map<String, Integer> counter = new HashMap<>();

        for (String string : strings) {
            counter.put(string, counter.getOrDefault(string, 0) + 1);
        }
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return counter.get(o2) - counter.get(o1);
            }
        });
        for (String s : counter.keySet()) {
            queue.add(s);
        }

        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }
        return res;

    }

    @Test
    public void testKMostWords() {
        String[] strings = {"a", "b", "a", "b", "c", "d", "e", "e", "e"};
        String[] expect = {"a", "b", "e"};
        String[] actual = solution.kMostWords(strings, 3);
        Arrays.sort(actual);
        Assert.assertArrayEquals(expect, actual);
    }




}
