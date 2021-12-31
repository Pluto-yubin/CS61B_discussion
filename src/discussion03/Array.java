package discussion03;

/**
 * @auther Zhang Yubin
 * @date 2021/12/31 23:14
 */
public class Array {
    /**
     * Consider a method that inserts item into array arr at the given position. The
     * method should return the resulting array. For example, if x = [5, 9, 14, 15],
     * item = 6, and position = 2, then the method should return [5, 9, 6, 14, 15].
     * If position is past the end of the array, insert item at the end of the array.
     * Is it possible to write a version of this method that returns void and changes arr
     * in place (i.e., destructively)?
     * @param arr
     * @param item
     * @param position
     * @return
     */
    public static int[] insert(int[] arr, int item, int position) {
        int[] temp = new int[arr.length + 1];
        for (int i = 0; i < position; i++) {
            temp[i] = arr[i];
        }

        for (int i = position + 1; i < temp.length; i++) {
            temp[i] = arr[i - 1];
        }

        temp[position] = item;
        return temp;
    }

    /**
     * Consider a method that destructively reverses the items in arr. For example calling
     * reverse on an array [1, 2, 3] should change the array to be [3, 2, 1].
     * What is the fewest number of iteration steps you need? What is the fewest number
     * of additional variables you need?
     * @param arr
     */
    public static void reverse(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            swap(arr, lo, hi);
            lo += 1;
            hi -= 1;
        }
    }

    /**
     * Extra: Write a non-destructive method replicate(int[] arr) that replaces the
     * number at index i with arr[i] copies of itself. For example, replicate([3, 2,
     * 1]) would return [3, 3, 3, 2, 2, 1].
     * @param arr
     * @return
     */
    public static int[] replicate(int[] arr) {
        // 看不懂题目，服了都
        int total = 0;
        for (int item : arr) {
            total += item;
        }
        int[] result = new int[total];
        int i = 0;
        for (int item : arr) {
            for (int counter = 0; counter < item; counter++) {
                result[i] = item;
                i++;
            }
        }
        return result;

    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 14, 15};
        arr = insert(arr, 6, 2);
        printArray(arr);
        reverse(arr);
        printArray(arr);
    }
}
