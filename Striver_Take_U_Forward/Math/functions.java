import java.util.*;
public class functions {
    public static void main(String[] args) {
        System.err.println(Gcd2(12, 18));
    }

    public static void CountDigit(int n) {
        int k = (int) Math.log10(n) + 1;
        System.out.println(k);
    }


    public static void PrintDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void PrintDivisors2(int n) {
        ArrayList<Integer> divisor = new ArrayList<>();
        int k = (int) Math.sqrt(n);
        for (int i = 1; i <= k; i++) {
            if (n % i == 0) {
                divisor.add(i);
                if (i != n / i) {
                    divisor.add(n / i);
                }
            }
        }
        Collections.sort(divisor);
        for (int p : divisor) {
            System.out.print(p + " ");
        }
    }

    // check perfect square
    public static int countPerfectSquares(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (isPerfectSquare(num)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        return (sqrt * sqrt == num);
    }

    public static int GCD(int a,int b){
        while(a>0 && b>0){
            if(a>b) a%=b;
            else b%=a;
        }
        if(a==0) return b;
        return a;
    }

    public static int Gcd2(int a, int b) {
        return (b == 0) ? a : Gcd2(b, a % b);
    }
}
