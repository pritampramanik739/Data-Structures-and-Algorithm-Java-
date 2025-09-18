public class DP_01_Knapsack{
    public static void main(String[] args) {
        
    }


    //O(2^n) Time and O(n) Space
    public static int knapsack_recurtion(int val[], int wt[], int w, int n) { // n->array Length
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapsack_recurtion(val, wt, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack_recurtion(val, wt, w, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack_recurtion(val, wt, w, n - 1);
        }
    }

    //O(n x W) Time and Space
    public static int knapsack_memoization(int val[], int wt[], int w, int n, int dp[][]) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (dp[n][w] != 0) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapsack_memoization(val, wt, w - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsack_memoization(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else {
            dp[n][w] = knapsack_memoization(val, wt, w, n - 1, dp);
            return dp[n][w];
        }
    }
    //O(n x W) Time and Space
    public static int knapsack_tabulation(int val[], int wt[], int w,int dp[][]) {
        for (int i = 1; i < val.length + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int v = val[i - 1];
                int p = wt[i - 1];
                if (p <= j) {
                    int ans1 = v + dp[i - 1][j - p];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = ans2;
                }
            }
        }
        return dp[val.length][w];
    }

    //Using Recursion – O(2^n) Time and O(n) Space
    public static boolean isSubsetSumRec(int[] arr, int n, int sum) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // If last element is greater than 
      	// sum, ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSumRec(arr, n - 1, sum);
        }
        // Check if sum can be obtained by including 
      	// or excluding the last element
        return isSubsetSumRec(arr, n - 1, sum) || isSubsetSumRec(arr, n - 1, sum - arr[n - 1]);
    }

    //O(sum*n) Time and O(sum*n) Space
    public static boolean targetsum(int arr[],int  sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v=arr[i-1];
                //exclude current element...
                if(j < v){
                    dp[i][j]=dp[i - 1][j];
                }
                 // Include or exclude
                else{
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-v];
                }
            }
        }
        return dp[n][sum];
    }

    //minimum partition --->time O(n*2) space O(n*2)
    public static int minpartition (int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int w=sum/2;
        int dp[][]=new int [n+1][w+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][w];
        int sum2=sum-sum1;
        return Math.abs(sum1-sum2);
    }

}