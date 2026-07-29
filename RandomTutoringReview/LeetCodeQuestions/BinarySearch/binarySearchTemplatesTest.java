package LeetCodeQuestions.BinarySearch;

public class binarySearchTemplatesTest {

    public static void main(String[] args) {

        System.out.println(binarySearchLeftMostInsertionPoint(new int[]{1,3,4,5,6,8,8,9,10}, 8));
        System.out.println(binarySearchRightMostInsertionPoint(new int[]{1,3,4,5,6,8,8,9,10}, 8));
    }

    public static int binarySearchLeftMostInsertionPoint(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {

                right = mid;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }

    public static int binarySearchRightMostInsertionPoint(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {

                right = mid;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }
}
