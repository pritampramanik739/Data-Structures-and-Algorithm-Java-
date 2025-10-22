public class DP_CatalanNumber {
    public static void main(String[] args) {
        
    }

    //catalan number Recursion.tc=O(2^n) sc=O(n)
    public static int findCatalan(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // catalan(n) is the sum of catalan(i) * catalan(n-i-1)
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += findCatalan(i) * findCatalan(n - i - 1);
        }
        return res;
    }

    //catalan number Memoization.tc=O(n^2) sc=O(n)
    public static int catalanmem(int n,int dp[]){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanmem(i, dp)*catalanmem(n-1-i, dp);
        }
        return dp[n]=ans;
    }

    //catalan number Tabulation.tc=O(n^2) sc=O(n)
    public static int catalntab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];  //[ Ci=Cj*Ci-j-1][count bst same code ]
                //[ left_tree=dp[j] & right_tree=dp[i-j-1] ] ;
                //[ same for mount ranges inside * outside ] ;
            }
        }
        return dp[n];
    }

    // nth catalan number = (2n)! / (n+1)! * n! .Time Complexity: O(n) Space Complexity: O(1)
    public static int catalanFormula(int n) {
        long res = 1;
        // Calculate value of 2nCn
        for (int i = 0; i < n; i++) {
            res = res * (2 * n - i);
            res = res / (i + 1);
        }
        // return 2nCn/(n+1)
        return (int) (res / (n + 1));
    }

    //catalan number Simplified formula.tc=O(n) sc=O(1).formula = (2(2n-1)/(n+1))*catalan(n-1)
    public static int CatalanSimplified(int n) {
        int res = 1;  //best practice is use long for large then typecast to int.

        // Use the iterative approach to  
        // calculate the nth Catalan number
        for (int i = 2; i <= n; i++) {
            res = (res * (4 * i - 2)) / (i + 1);
        }

        return res;
    }
}
