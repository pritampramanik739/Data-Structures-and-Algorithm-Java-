public class DP_MCM {
    public static void main(String[] args) {
        
    }
    //recursive--> time complexity - O(2^n) and O(n) Space
    public static int mcm(int arr[],int i,int j){ // i start with 1 not 0 and j=n-1
        if(i==j){
            return 0; //single matrix case
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1=mcm(arr, i, k); // Ai...Ak=> arr[i-1]*arr[k]
            int cost2=mcm(arr, k+1, j);//Ai+1..Aj=>arr[k]*arr[j];
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalcost=cost1+cost2+cost3;
            ans=Math.min(ans, finalcost);
        }
        return ans;
    }
    //memoization-->Using Top-Down DP (Memoization) - O(n*n*n) and O(n*n) Space
    public static int mcmmem(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1=mcmmem(arr, i, k, dp);
            int cost2=mcmmem(arr, k+1, j, dp);
            int cost3=arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,cost1+cost2+cost3);
        }
        return dp[i][j]=ans;
    }
    //tabulation--->Using Bottom-Up DP (Tabulation) - O(n*n*n) and O(n*n) Space
    public static int mcmtab(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int l=2;l<=n-1;l++){
            for(int i=1;i<=n-l;i++){
                int j=i+l-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],cost1+cost3+cost2);
                }
            }
        }
        return dp[1][n-1];
    }
}
