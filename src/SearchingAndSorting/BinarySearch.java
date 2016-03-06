package SearchingAndSorting;

/**
 * Created by Anuradha on 3/6/2016.
 */
public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] arr) {
        this.array = arr;
    }

    // Method to be called by the user
    public int binarySearch(int key) {
        return binarySearch(key, 0, array.length - 1);
    }

    // Method that will split and search in sub array determined by indices start and end
    private int binarySearch(int key, int start, int end) {
        // If the key is not available
        if (end < start) {
            return -1;
        }
        // If the key is present
        else {
            // Make a mid point pivot
            int mid = (start + end) / 2;
            // If the key is found
            if (array[mid] == key) {
                return mid;
            }
            // If key is in the array above the mid point
            else if (array[mid] < key) {
                return binarySearch(key, mid + 1, end);
            }
            // If the key resides in the first half
            else {
                return binarySearch(key, start, mid - 1);
            }
        }
    }

    public int ordinarySearch(int key) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Generating a sorted array
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = i + 1;
        }
        BinarySearch bs = new BinarySearch(arr);
        long time = System.currentTimeMillis();
        System.out.println(bs.binarySearch(100000000));
        System.out.println("Time for binary Search = " + (System.currentTimeMillis() - time));
        // 1 Milli second
        time = System.currentTimeMillis();
        System.out.println(bs.ordinarySearch(100000000));
        // 87 milli seconds
        System.out.println("Time for ordinary Search = " + (System.currentTimeMillis() - time));
    }
}

