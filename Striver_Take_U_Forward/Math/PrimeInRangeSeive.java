// Sieve of Eratosthenes-->O(n)+O(nlog(logn))+O(n)

import java .util.*;
public class PrimeInRangeSeive {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int range=sc.nextInt();
        int[] arr= new int[range+1];
        for(int i=2;i<=range;i++) arr[i]=1;
        for(int i=2;i*i<=range;i++){
            if(arr[i]==1){
                for(int j=i*i;j<=range;j+=i) arr[j]=0;
            }
        }
        for(int k=2;k<=range;k++){
            if(arr[k]==1){
                System.out.print(k+" ");
            }
        }
        sc.close();
    }
}
