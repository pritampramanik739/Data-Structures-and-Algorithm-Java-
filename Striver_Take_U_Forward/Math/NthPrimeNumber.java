public class NthPrimeNumber {
    public static void main(String[] args) {
        int one=5;
        int two=2;
        int result=findNthPrime(one)*findNthPrime(two);
        System.out.println(result);
        System.out.print(isprime(2));
    }
    
    public static boolean isprime(int n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }

    public static int findNthPrime(int n){
        int c=0,num=1;
        while(c<n){
            num++;
            if(isprime(num)) c++;
        }
        return num;
    }
}
