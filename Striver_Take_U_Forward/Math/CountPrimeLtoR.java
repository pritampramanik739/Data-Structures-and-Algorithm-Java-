import java.util.ArrayList;
import java.util.Scanner;

public class CountPrimeLtoR {

    public static ArrayList<Integer> getSieve(int n) {
        ArrayList<Integer> prime = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            prime.add(1); // Initialize all values to 1 (indicating prime)
        }
        prime.set(0, 0); // 0 is not prime
        prime.set(1, 0); // 1 is not prime
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (prime.get(i) == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime.set(j, 0); // Mark multiples of i as non-prime
                }
            }
        }
        return prime;
    }

    public static ArrayList<Integer> countPrimes(ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer> prime = getSieve(1000000);
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = 2; i < prime.size(); i++) {
            cnt += prime.get(i); // Count cumulative primes up to each index
            prime.set(i, cnt); // Store the cumulative prime count at each index
        }
        for (ArrayList<Integer> query : queries) {
            int l = query.get(0);
            int r = query.get(1);
            ans.add(prime.get(r) - prime.get(l - 1)); // Difference gives prime count in range [l, r]
        }
        return ans;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of queries from the user
        System.out.print("Enter the number of queries: ");
        int Q = scanner.nextInt();

        // Create a list to hold queries
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();

        // Get each query from the user
        for (int i = 0; i < Q; i++) {
            System.out.print("Enter range for query " + (i + 1) + " (l r): ");
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            ArrayList<Integer> query = new ArrayList<>();
            query.add(l);
            query.add(r);
            queries.add(query);
        }

        // Get the result for the queries
        ArrayList<Integer> result = countPrimes(queries);

        // Display the result
        System.out.println("\nNumber of primes between the ranges:");
        for (int res : result) {
            System.out.print(res + " ");
        }
        System.out.println();
        
        scanner.close();
    }

    
}

// O(nloglogn)+O(n)+O(Q)=O(nloglogn)+O(Q)