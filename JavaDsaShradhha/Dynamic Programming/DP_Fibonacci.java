
public class DP_Fibonacci {
    public static void main(String[] args) {
        fibonacciwithoutThirdVariable(10);
        Nthfibonnaci(4);
    }

    public static void fibonacci(int n) {
        System.out.println("Fibonacci series up to " + n + " terms:");
        int f1 = 0, f2 = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + f1);
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    }

    public static void fibonacciwithoutThirdVariable(int n){
        System.out.println("Fibonacci series up to " + n + " terms:");
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            b = a + b; // update b to next Fibonacci number
            a = b - a; // update a (previous value of b)
            System.out.print(b + " ");
        }
    }

    public static void Nthfibonnaci(int n){
        int f1 = 0, f2 = 1;
        if(n==0){
            System.out.println(f1);
            return;
        }
        if(n==1){
            System.out.println(f2);
            return;
        }
        for (int i = 2; i <= n; i++) {
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }

        System.out.println(f1);
    }

    public static void fibonacciUptoGivenNumber(int n) {
        System.out.println("Fibonacci numbers less than or equal to " + n + ":");
        int f1 = 0, f2 = 1;
        while (f1 <= n) {
            System.out.print(" " + f1);
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    }

    // All are 0 index in the fibonacci series
    public static int fibonacci(int n, int f[]) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fibonacci(n - 1, f) + fibonacci(n - 2, f);
        return f[n];
    }
    public static int fibonacci_tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    //Time Complexity->O(2^n) Space Complexity->O(n)
    public static int countWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2);
    }
    //Time Complexity->O(n) Space Complexity->O(n)
    public static int countWaysRec(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = countWaysRec(n - 1, memo) + countWaysRec(n - 2, memo);
    }
    //Time Complexity->O(n) Space Complexity->O(n)
    public static int climbStairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //O(n).. Best for three step , four step also only need to change return line 
    public static int countways(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){
            return ways[n];
        }
        ways[n]=countways(n-1, ways)+countways(n-2, ways);
        return ways[n];
    }


    //Time Complexity->O(n) Space Complexity->O(1)
    public static int countWaysoptimal(int n) {
  
        // variable prev1, prev2 - to store the 
        // values of last and second last states 
        int prev1 = 1;
        int prev2 = 1;
  
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
  
        // In last iteration final value
        // of curr is stored in prev.
        return prev1;
    }
    
}