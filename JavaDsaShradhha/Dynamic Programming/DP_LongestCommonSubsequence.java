
import java.util.*;

public class DP_LongestCommonSubsequence {

    public static void main(String[] args) {

    }

    //Brute force approach-->> Using Recursion - O(2 ^ min(m, n)) Time and O(min(m, n)) Space
    public static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            // same --/
            return lcs(s1, s2, n - 1, m - 1) + 1;
        } else {
            // diffent-->
            int ans1 = lcs(s1, s2, n - 1, m);
            int ans2 = lcs(s1, s2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    //Memoization approach-->> (Top Down DP) - O(m * n) Time and O(m * n) Space
    public static int lcs2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];

        // Initialize the memo table with -1
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcsRec(s1, s2, m, n, memo);
    }

    // Returns length of LCS for s1[0..m-1], s2[0..n-1]
    public static int lcsRec(String s1, String s2, int m, int n, int[][] memo) {
        // Base Case
        if (m == 0 || n == 0) {
            return 0;
        }

        // Already exists in the memo table
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        // Match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = lcsRec(s1, s2, m - 1, n - 1, memo) + 1;
        }

        // Do not match
        return memo[m][n] = Math.max(lcsRec(s1, s2, m, n - 1, memo), lcsRec(s1, s2, m - 1, n, memo));
    }

    //Tabulation approach-->> (Bottom Up DP) - O(m * n) Time and O(m * n) Space
    public static int lcs3(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table in bottom-up fashion
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, increment the count from the previous indices
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters do not match, take the maximum from either excluding
                    // the current character of s1 or s2
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The bottom-right cell contains the length of LCS for s1 and s2
        return dp[m][n];
    }

    // largest common substring --> Tabulation approach-->> (Bottom Up DP) - O(m * n) Time and O(m * n) Space
    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int sp[][] = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    sp[i][j] = sp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, sp[i][j]);
                } else {
                    sp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    //longest increasing subsequnce--> tc=O(n^2) sc=O(n^2)
    public static int longestIncreasingSubsequnce(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return lcsHelperForLis(arr, arr2);
    }

    public static int lcsHelperForLis(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    // edit distance -->> replace--insertion--delete-->>> tc=O(m*n) sc=O(m*n)
    public static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        //initialize-->>
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        //bottom up-->
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1];
                    int del = dp[i - 1][j];
                    int rep = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(add, Math.min(del, rep)) + 1;
                }
            }
        }
        return dp[n][m];
    }

    // Minimum number of operations to convert string a to string b
    // Operations allowed: Insert, Delete
    //tc=O(m*n) sc=O(m*n)
    public static int minConversionMoves(String a, String b) {
        int n = a.length();
        int m = b.length();

        // LCS DP
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[n][m];
        return (n - lcs) + (m - lcs);
    }

    //wildcard matching -->> tc=O(m*n) sc=O(m*n)
    public static boolean ismatch(String s,String p){
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        //initialize
        dp[0][0]=true;
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case -> ith char == jth char || jth char == ? 
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }

}
