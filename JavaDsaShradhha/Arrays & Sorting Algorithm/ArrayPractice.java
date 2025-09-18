import java.util.Arrays;
public class ArrayPractice{
    public static void main(String[] args) {
        int arr[] = { 1, 20, 30, 40, 50, 60, 700, 80, 90, 100 };
        LarAndSmall(arr);
        System.out.println(BinarySearch(arr, 70));
        System.out.println(SecondLargestElement(arr));
        Arrays.sort(arr);
        for (int x : arr) {
            System.out.println(x);
        }

    }

    // largest and smaklest number
    public static void LarAndSmall(int arr[]) {
        int lar = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > lar) {
                lar = arr[i];
            }
            if (arr[i] < small) {
                small = arr[i];
            }
        }
        System.out.println("Largest and smallest number are : " + lar + " and " + small);
    }

    // Binary search
    public static int BinarySearch(int arr[], int key) {
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Reverse Array
    public static void ReverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        //for(int i=A.length-1,j=0;i>=0;i++,j++){B[j]=A[i];}  two parameter in one loop
    }

    // Pairs of an Array
    public static void pair(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    // SubArray of Array
    public static void subarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Prefix Sum Of maximum subarray sum
    public static void prefix_sum(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum;
                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }
                maxsum = Math.max(maxsum, sum);
            }
        }
        System.out.print(maxsum);
    }

    // Kadane Algorithm
    public static void kadanes(int arr[]) {
        int m = Integer.MIN_VALUE;
        int mx = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if (cs < 0) {
                cs = 0;
            }
            mx = Math.max(mx, arr[i]);
            m = Math.max(m, cs);
        }
        if (m == 0) {
            System.out.print(mx);
        } else {
            System.out.print(m);
        }
    }

    // Trap Rain Water
    public static void water(int arr[]) {
        int x = 0;
        int arr1[] = new int[arr.length];
        int arr2[] = new int[arr.length];
        arr1[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr1[i] = Math.max(arr[i], arr1[i - 1]);
        }
        arr2[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            arr2[i] = Math.max(arr[i], arr2[i + 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            int waterlevel = Math.min(arr1[i], arr2[i]);
            x += (waterlevel - arr[i]) * 1;
        }
        System.out.print(x);
    }

    // Buy and sell stock
    public static int buystokes(int n[]) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int i = 0; i < n.length; i++) {
            if (buy < n[i]) {
                int p = n[i] - buy;
                sell = Math.max(sell, p);
            } else {
                buy = n[i];
            }
        }
        return sell;
    }

    // Second Largest Element
    public static int SecondLargestElement(int arr[]) {
        if (arr.length == 1) {
            return -1;
        }
        int max1, max2;
        max1 = Integer.MIN_VALUE;
        max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;
                max1 = arr[i];
            } else if (max2 < arr[i]) {
                max2 = arr[i];
            }
        }
        return max2;
    }
}