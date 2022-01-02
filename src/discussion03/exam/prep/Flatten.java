package discussion03.exam.prep;

/**
 * @auther Zhang Yubin
 * @date 2022/1/1 0:53
 */
public class Flatten {
    /**
     * Write a method flatten that takes in a 2-D array x and returns a 1-D array that
     * contains all of the arrays in x concatenated together.
     * For example, flatten({{1, 2, 3}, {}, {7, 8}}) should return {1, 2, 3, 7, 8}.
     */
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++) {
            totalLength += x[i].length;
        }
        int[] a = new int[totalLength];
        int aIndex = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                a[aIndex] = x[i][j];
                aIndex += 1;
            }
        }
        return a;
    }
}
