import java.util.*;

public class questions {
    public static void main(String[] args) {
        System.out.println(Character.toUpperCase('a'));
        String str = "ABcdEF";
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 += Character.toUpperCase(str.charAt(i));
        }
        System.out.println(str2);

        isHappyNumber(10);
    }

    // colourful stone   [A. Colorful Stones (Simplified Edition)---> Codeforces]
    @SuppressWarnings("ConvertToTryWithResources")
    public static void ColorfulStone() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // Stones sequence
        String t = scanner.nextLine(); // Instructions sequence

        int position = 0; // Start from the first stone (0-based index)

        for (char instruction : t.toCharArray()) {
            // Ensure we do not go out of bounds before checking the stone color
            if (position < s.length() && s.charAt(position) == instruction) {
                position++; // Move to the next stone
            }
        }

        System.out.println(position + 1); // Output final position (1-based index)
        scanner.close();
    }


    // minimum penalty [given array then minimise the  value of the sum of diffences between to adjacent numbers]
    public static int MinimumPwenalty(int arr[]) {
        Arrays.sort(arr);
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            k += (int) Math.abs(arr[i] - arr[i - 1]);
        }
        return k;
    }

    // happy number square[GFG]
    public static int numSquareSum(int n) {
        int num = 0;
        while (n != 0) {
            int digit = n % 10;
            num += digit * digit;
            n /= 10;
        }
        return num;
    }
    static boolean isHappyNumber(int n) {
        HashSet<Integer> st = new HashSet<>();
        while (true) {
            n = numSquareSum(n);
            if (n == 1)
                return true;
            if (st.contains(n))
                return false;
            st.add(n);
        }
    }

    // chocolate[GFG -->Chocolate Distribution Problem]
    public int findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int minDiff = Integer.MAX_VALUE;
        for (int i = m - 1; i < n; i++) {
            minDiff = Math.min(minDiff, a.get(i) - a.get(i - m + 1));
        }
        return minDiff;
    }

    
    // [lucky or not[ram thinks 4&7 are his lucky number and those number which  are completely divisible by those number are called  almost lucky number]
    // A. Nearly Lucky Number important-->
}
