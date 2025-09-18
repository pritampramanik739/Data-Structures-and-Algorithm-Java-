public class DivideConquer {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.print(rotatedI(arr, 0, 0, arr.length-1));
    }
     // merge sort----->
     public static void mergesort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // end of merge sort-------->

    // print arrray--->

    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // quicksort start-------->>>
    public static void quick_sort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int idx = partition(arr, si, ei);
        quick_sort(arr, si, idx - 1);
        quick_sort(arr, idx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    // quicksort ending-------->>>

    // search in a sorted and rotated array-----> Recursive approch
    public static int rotated(int arr[], int key, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = (si + ei) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= key && key <= arr[mid]) {
                return rotated(arr, key, si, mid - 1);
            } else {
                return rotated(arr, key, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= key && key <= arr[ei]) {
                return rotated(arr, key, mid + 1, ei);
            } else {
                return rotated(arr, key, si, mid - 1);
            }
        }
    }

    //iterative approach
    public static int rotatedI(int arr[],int key,int si,int ei){
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[si]<=arr[mid]){
                if(arr[si] <= key && key <= arr[mid]){
                    ei=mid-1;
                }else{
                    si=mid+1;
                }
            }else {
                if(arr[mid]<=key && key<=arr[ei]){
                    si=mid+1;
                }else{
                    ei=mid-1;
                }
            }
        }
        return -1;
    }
}
