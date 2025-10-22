import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Main class containing demonstrations of various DSA problems
 * 1. Rotting Oranges (BFS Problem)
 * 2. Goldbach's Conjecture (Prime Numbers)
 * 3. Longest Palindrome Substring
*/
public class Infosys {
    
    public static void main(String[] args) {
        System.out.println("=== Infosys DSA Problems ===\n");
        
        // Test 1: Rotting Oranges
        System.out.println("1. ROTTING ORANGES PROBLEM");
        System.out.println("-".repeat(50));
        RottingOrangesSolution orangesSolution = new RottingOrangesSolution();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = orangesSolution.orangesRotting(grid);
        System.out.println("Time to rot all oranges: " + result + " minutes");
        System.out.println();
        
        // Test 2: Goldbach's Conjecture
        System.out.println("2. GOLDBACH'S CONJECTURE (Sum of Two Primes)");
        System.out.println("-".repeat(50));
        GoldbachSolution goldbachSolution = new GoldbachSolution();
        int number = 10;
        String canBeSum = goldbachSolution.isSumOfTwo(number);
        System.out.println("Can " + number + " be expressed as sum of two primes? " + canBeSum);
        System.out.println();
        
        // Test 3: Longest Palindrome
        System.out.println("3. LONGEST PALINDROME SUBSTRING");
        System.out.println("-".repeat(50));
        LongestPalindromeSolution palindromeSolution = new LongestPalindromeSolution();
        String testString = "babad";
        String longestPal = palindromeSolution.longestPalindrome(testString);
        System.out.println("Longest palindrome in '" + testString + "': " + longestPal);
    }
}

// ============================================================================
// PROBLEM 1: ROTTING ORANGES (BFS/Graph Problem)
// ============================================================================
/**
 * Problem: Given a grid where:
 * - 0 represents an empty cell
 * - 1 represents a fresh orange
 * - 2 represents a rotten orange
 * 
 * Every minute, any fresh orange adjacent (4-directionally) to a rotten orange becomes rotten.
 * Return the minimum number of minutes until no cell has a fresh orange.
 * If impossible, return -1.
 * 
 * Approach: Multi-source BFS
 * - Start BFS from all initially rotten oranges
 * - Track time taken to rot each fresh orange
 * - If any fresh orange remains unreachable, return -1
 */
class RottingOrangesSolution {
    
    // Helper class to store position and time information
    static class Pair {
        int row;
        int col;
        int time;
        
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    // Directions array for 4-directional movement: up, right, down, left
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int orangesRotting(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        
        // Count total fresh oranges and add all rotten oranges to queue
        int cnt = 0; // Total fresh oranges initially
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
        }
        
        // BFS to rot adjacent fresh oranges
        int time = 0;
        int cf = 0; // Count of fresh oranges that got rotten
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            time = Math.max(time, t);
            
            // Check all 4 directions
            for (int i = 0; i < dirs.length; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                
                // If valid cell with fresh orange, make it rotten
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && 
                    !vis[nr][nc] && mat[nr][nc] == 1) {
                    q.offer(new Pair(nr, nc, t + 1));
                    vis[nr][nc] = true;
                    cf++; // Increment count of rotted oranges
                }
            }
        }
        
        // If not all fresh oranges got rotten, return -1
        return (cf != cnt) ? -1 : time;
    }
}

// ============================================================================
// PROBLEM 2: GOLDBACH'S CONJECTURE (Prime Numbers)
// ============================================================================
/**
 * Problem: Check if a given even number N can be expressed as sum of two prime numbers.
 * This is based on Goldbach's Conjecture which states that every even integer 
 * greater than 2 can be expressed as the sum of two primes.
 * 
 * Approach:
 * - Iterate through all numbers from 2 to N/2
 * - For each number i, check if both i and (N-i) are prime
 * - If yes, return "Yes", otherwise return "No"
 */
class GoldbachSolution {
    
    public String isSumOfTwo(int N) {
        if (N <= 2) {
            return "No";
        }
        
        // Check if N can be expressed as sum of two primes
        for (int i = 2; i <= N / 2; i++) {
            if (isPrime(i) && isPrime(N - i)) {
                return "Yes";
            }
        }
        return "No";
    }
    
    // Helper method to check if a number is prime
    private boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        
        // Check divisibility up to sqrt(a)
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// ============================================================================
// PROBLEM 3: LONGEST PALINDROME SUBSTRING
// ============================================================================
/**
 * Problem: Find the longest palindromic substring in a given string.
 * 
 * Approach: Brute Force
 * - Check all possible substrings
 * - For each substring, verify if it's a palindrome
 * - Keep track of the longest palindrome found
 * 
 * Time Complexity: O(n^3) - can be optimized to O(n^2) using expand around center
 * Space Complexity: O(1)
 */
class LongestPalindromeSolution {
    
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        String ans = "";
        
        // Check all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
    
    // Helper method to check if substring from start to end is palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
