/*
 * give an array A of length N,Alex and VBob have decided to play a game called "take it apart"
 * At beginning of the game players pick a side of the array that is either the start or the end
 * of the array,and it's fixed for the rest of the game.Then they start playing in turns.Alex goes 
 * first they pick a number from their side and remove from the array .This number is considered
 * collected by the respective player ...
 * 
 * your task is to calculatethe minimum absolute difference between the sum of collected numbers by
 * alex and bob
*/


import java.util.*;

public class TakeItAppart {
    public static long solve(int N, List<Long> A) {
        long total = 0;
        long evenSum = 0, oddSum = 0;
        long[] prefix = new long[N + 1];

        // Calculate total sum, evenSum, oddSum, and prefix sums
        for (int i = 0; i < N; i++) {
            total += A.get(i);
            prefix[i + 1] = prefix[i] + A.get(i);
            if (i % 2 == 0) {
                evenSum += A.get(i);
            } else {
                oddSum += A.get(i);
            }
        }

        // Case 1: Picking alternate indices
        long diff_same = Math.abs(evenSum - oddSum);

        // Case 2: Choosing the first K elements
        int klr = (N + 1) / 2;
        long difflr = Math.abs(2 * prefix[klr] - total);

        // Case 3: Choosing the last K elements
        int krl = N / 2;
        long diffrl = Math.abs(total - 2 * prefix[krl]);

        return Math.min(Math.min(diff_same, difflr), diffrl);
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {  //i--  > 0
            int N = scanner.nextInt();
            List<Long> A = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                A.add(scanner.nextLong());
            }
            System.out.println(solve(N, A));
        }
        scanner.close();
    }
}
