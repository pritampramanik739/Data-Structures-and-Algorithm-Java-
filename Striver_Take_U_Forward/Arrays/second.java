import java.util.*;

public class second {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        leftRotate(arr);
        DleftRotate(arr, 2);
        DLeftRotateOptimal(arr, 8);
        int arr1[] = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 0, 7};
        MoveZerosOptimal(arr1);
        System.out.println(Arrays.toString(arr1));
        int nums[]={1,1,2,3,4,4,5};
        int nums1[]={1,1,3,4,4,5,6,7};
        System.out.println(UnionOptimal(nums, nums1));
    }

    public static int[] leftRotate(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void DleftRotate(int[] arr, int d) {
        d = d % arr.length;
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        for (int i = arr.length - d; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length - d)];
        }
    }

    public static void DLeftRotateOptimal(int[] arr, int d) {
        d = d % arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int si, int ei) {
        while (si <= ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }

    public static void Movezeros(int[] arr) {

        //step-1 copy non zero elements to list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
            }
        }

        //step 2 copy elements back to the array
        int nz = list.size();
        for (int i = 0; i < nz; i++) {
            arr[i] = list.get(i);
        }

        //step 3 fill the remaining positions with Zero
        for (int i = nz; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void MoveZerosOptimal(int arr[]) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }

        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {  // Avoid self-XOR
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    public static int[] Intersection(int[] nums1, int[] nums2) {  // comments things if sorted arrays 
        int n1 = nums1.length;          // if dupliocate are allow in answer use List and array method
        int n2 = nums2.length;
        Set<Integer> list = new HashSet<>();          //int[] temp = new int[nums2.length)];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j] && !list.contains(nums1[i])) {//if (nums1[i]==nums2[j] && temp[j]==0) { 
                    list.add(nums1[i]);                                  //add(element);temp[j] = 1;break;}
                    break;                                           //if(nums2[j]>nums1[i])break;
                }
            }
        }
        int[] arr = new int[list.size()];
        int k = 0;
        for (int num : list) {
            arr[k++] = num;
        }
        return arr;
    }

    public static int[] IntersectionOptimal(int[] nums1, int[] nums2) { // here no duplicate allow in answer set
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> list1 = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < n2; i++) {
            if (list1.contains(nums2[i])) {
                list.add(nums2[i]);
                list1.remove(nums2[i]);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int[] intersect(int[] nums1, int[] nums2) {  //In answer set duplicate are allowed if applicable
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        ArrayList<Integer> set = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else { // nums1[i] == nums2[j]
                set.add(nums1[i]); // O(1) insert
                i++;
                j++;
            }
        }
        // Convert set to array
        int[] arr = new int[set.size()];
        int k = 0;
        for (int num : set) {
            arr[k++] = num;
        }
        return arr;
    }

    public static Set<Integer> FindUnion(int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            s.add(arr2[i]);
        }
        return s;
    }

    public static ArrayList<Integer> UnionOptimal(int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0; // pointers
       ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
       while (i < n && j < m) {
            if (arr1[i] <= arr2[j]){  // case 1 and 2 
                if (Union.isEmpty() || Union.get(Union.size()-1) != arr1[i]) Union.add(arr1[i]);
                i++;
            }
            else{  //case 3 
                if (Union.isEmpty() || Union.get(Union.size()-1) != arr2[j]) Union.add(arr2[j]);
                j++;
            }
        }

       while (i < n)         // If any element left in arr1
       {
         if (Union.get(Union.size()-1) != arr1[i]) Union.add(arr1[i]);
         i++;
       }
       while (j < m)        // if any elements left in arr2
       {
         if (Union.get(Union.size()-1) != arr2[j]) Union.add(arr2[j]);
         j++;
       }
       return Union;
    }
}