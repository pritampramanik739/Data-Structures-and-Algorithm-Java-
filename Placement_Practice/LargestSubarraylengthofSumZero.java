import java.util.HashMap;

public class LargestSubarraylengthofSumZero {
    public static void main(String[] args) {
        // Find the length of the longest subarray with sum equal to zero in a given array
        int arrr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for(int i=0;i<arrr.length;i++){
            sum += arrr[i];
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(len);
    }
}
