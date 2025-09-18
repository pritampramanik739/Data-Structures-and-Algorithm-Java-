public class LargestNumberDivisibleBy90 {

    public static void main(String[] args) {
        int[] arr = {0,5,5,5,5,5,5,5,5,5}; // Example input
        String d=findLargestNumber(arr);
        long lk=Long.parseLong(d);
        System.out.println(lk);
    }

    public static String findLargestNumber(int[] arr) {
        int count5 = 0, count0 = 0;
        
        for (int num : arr) {
            if (num == 5) count5++;
            else if (num == 0) count0++;
        }
        
        if (count0 == 0) return "0";
        if (count5 < 9) return "0";
        
        int maxCount5 = (count5 / 9) * 9;
        return "5".repeat(maxCount5) + "0".repeat(count0);
    }
}
