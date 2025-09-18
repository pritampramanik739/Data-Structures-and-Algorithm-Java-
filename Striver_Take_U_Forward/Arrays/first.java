import java.util.*;

public class first{
    public static void main(String[] args) {
        int[] arr= {1,9,9,7,3,8,2};
        System.out.println("largest value is : "+ largestElement(arr));
        System.out.println("SecondLargest Number : "+ Secondlargest(arr));
        System.out.println("Second Smallest Number : " + SecondSmallest(arr));
        System.out.println();
        int[] nums={1,2,2,1,4,5,6,4,6,7,7};
        UNiqueElement(nums);
    }

    public static int  largestElement(int[] arr){
        int p=arr[0];
        for(int i=1;i<arr.length;i++){
            if(p<arr[i]){
                p=arr[i];
            }
        }
        return p;
    }

    public static int Secondlargest(int[] arr){
        int max1=arr[0];
        int max2=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[1]>max1){
                max2=max1;
                max1=arr[i];
            }else if(arr[i]>max2 && arr[i]!=max1){
                max2=arr[i];
            }
        }
        return max2;
    }

    public static int SecondSmallest(int[] arr){
        int min1=arr[0];
        int min2=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(min1>arr[1]){
                min2=min1;
                min1=arr[i];
            }else if(min2>arr[i] && arr[i]!=min1){
                min2=arr[i];
            }
        }
        return min2;
    }

    public static boolean checksorted(int[] arr){
        for(int i= 1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]){}
            else {
                return false;
            }
        }
        return true;
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer>list=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int i=0;
        for(Integer k : list){
            nums[i]=k;
            i++;
        }
        return list.size();
    }

    public int removeDuplicatesSorted(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }

    public static void UNiqueElement(int[] arr){
        int result=0;
        for(int i=0;i<arr.length;i++){
            result ^=arr[i];
        }
        System.out.println(result);
    }
}