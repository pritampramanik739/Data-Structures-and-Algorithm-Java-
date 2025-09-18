
public class DP_Unbounded_Knapsack {
    public static void main(String[] args) {

    }
    //Using Recursive Method - O(2^n) time and O(capacity) space
    public static int knapSackRecur(int i, int capacity, int[] val, int[] wt) {  
        //i track the val array size index 
        if (i == val.length) return 0;

        // Consider current item only if 
        // its weight is less than equal 
        // to maximum weight.
        int take = 0;
        if (wt[i] <= capacity) {
            take = val[i] + knapSackRecur(i, capacity - wt[i], val, wt);
        }

        // Skip the current item
        int noTake = knapSackRecur(i + 1, capacity, val, wt);

        // Return maximum of the two.
        return Math.max(take, noTake);
    }
    public static int knapSack(int capacity, int[] val, int[] wt) {
        return knapSackRecur(0, capacity, val, wt);
    }

    //Using Bottom-Up DP (Tabulation) – O(n*capacity) Time and O(n*capacity) Space
    
    public static int unboundedknapsack(int val[],int wt[],int w){
        int n=val.length;
        int dp[][]=new int[n+1][w+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                int pick=0;
                if(wt[i-1]<=j){
                    // for valid--->
                    pick=val[i-1]+dp[i][j-wt[i-1]];
                }
                //invalid--->
                int notpick=dp[i-1][j];
                dp[i][j]=Math.max(pick,notpick);
            }
        }
        return dp[n][w];   
    }


    // Using Recursion - O(2^sum) time and O(sum) space
    public static int countRecur(int[] coins, int n, int sum) {

        //n= coins.length
        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0) return 1;

        // 0 ways in the following two cases
        if (sum < 0 || n == 0) return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return countRecur(coins, n, sum - coins[n - 1]) + countRecur(coins, n - 1, sum);
    }

    //Using Bottom-Up DP (Tabulation) – O(sum*n) time and O(sum*n) space
     public static int coinchange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        //one way to make sum = 0 by not using any coins
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        // O(n*sum)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    // valid-->
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    // invalid-->
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    // Using Recursion - O(n^n) Time and O(n) Space
    public static int cutRodRecur(int n, int[] price) {
        
        //n= price.length
        // Base case
        if (n == 0) return 0;
        
        int ans = 0;

        // Find maximum value for each cut.
        // Take value of rod of length j, and 
        // recursively find value of rod of 
        // length (i-j).
        for (int j = 1; j <= n; j++) {
            ans = Math.max(ans, price[j - 1] + cutRodRecur(n - j, price));
        }

        return ans;
    }

    // using tabulation Time & space complexity => O(n * totrod)
    public static int rodcutting(int length[], int price[], int totrod) {
        int n = length.length;
        int dp[][] = new int[n + 1][totrod + 1];
        // although below loop is not required as java already initialized with 0
        // But if you use Memoization this will be the base case .
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < totrod + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totrod + 1; j++) {
                // valid--?>
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totrod];
    }


}
