import java.util.*;
public class MaximumFirstLastSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,3,4,10,6,1};
        int k=sc.nextInt();
        int ans=MaxScore(arr,k);
        System.out.println("answer is : "+ ans);
    }

    // maximum score from selecting k cards

    public static int MaxScore(int[] arr,int k){
        int lsum=0;
        int rsum=0;
        int maxi=0;
        for(int i=0;i<k;i++){
            lsum+=arr[i];
        }
        maxi=lsum;
        int rptr=arr.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=arr[i];
            rsum+=arr[rptr];
            rptr--;
            maxi=Math.max(maxi,lsum+rsum);
        }
        return maxi;
    }
}
