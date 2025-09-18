import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactorizationSPF {
    static final int MAX = 1000000;
    static int[] spf = new int[MAX + 1]; // Smallest Prime Factor array

    // Precompute the smallest prime factor for every number
    public static void sieve() {
        for (int i = 2; i <= MAX; i++) spf[i] = i; // Initialize SPF to itself
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) { // If i is prime
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) { // Mark only if it's still unmarked
                        spf[j] = i;
                    }
                }
            }
        }
    }

    // Get prime factorization using the SPF table
    public static ArrayList<Integer> getPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        while (n != 1) {
            factors.add(spf[n]);
            n /= spf[n];
        }
        return factors;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        sieve(); // Precompute SPF table

        System.out.print("Enter number of queries: ");
        int Q = scanner.nextInt();

        for (int i = 0; i < Q; i++) {
            System.out.print("Enter a number to find its prime factorization: ");
            int num = scanner.nextInt();
            ArrayList<Integer> factors = getPrimeFactors(num);

            System.out.print("Prime factors of " + num + ": ");
            for (int factor : factors) {
                System.out.print(factor + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}


//O(Q)+O(sqrt(n)) ---> O(nloglogn)+O(Qlogn)