import java.util.*;
import java.util.Map.Entry;
public class HashMap_practice {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("china", 10);
        hm.put("us", 34);
        Set<Entry<String, Integer>>keys=hm.entrySet();
        System.out.println(keys);
        //for loop-->>> for each.....
        Set<String>keyh=hm.keySet();
        for (String k : keyh) {
        System.out.println(k+" "+","+hm.get(k));
        }

        // insertion order maintain-->>
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("china", 10);
        lhm.put("us", 34);
        System.out.println(lhm);

        // sorted order of keys-->> //red black tree
        TreeMap<String, Integer> th = new TreeMap<>();
        th.put("India", 100);
        th.put("China", 10);
        th.put("Us", 34);
        System.out.println(th);

        StartingCity();
    }
    // majority element--- element appear more than |_n/3_| times
    public static void Majority_Element(int arr[]){
        HashMap<Integer, Integer> Hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (Hs.containsKey(arr[i])) {
            // Hs.put(arr[i], Hs.get(arr[i]) + 1);
            // } else { Hs.put(arr[i], 1);}
            Hs.put(arr[i],Hs.getOrDefault(arr[i], 0)+1);
        }
        for (Integer k : Hs.keySet()) {
            if(Hs.get(k)>arr.length/3){
            System.out.println(k);
            }
        }
    }
    //valid anagram--> made of same element
    public static boolean anagram(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        HashMap<Character, Integer> d = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            d.put(c, d.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (d.get(c) != null) {
                if (d.get(c) == 1) {
                    d.remove(c);
                } else {
                    d.put(c, d.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return d.isEmpty();
    }
    @SuppressWarnings("unused")
    public static void StartingCity(){
        HashMap<String, String> t = new HashMap<>();
        t.put("chennei", "bangaluru");
        t.put("mumbai", "delhi");
        t.put("goa", "chennei");
        t.put("delhi", "goa");
        String s = getst(t);
        System.out.print(s);
        for (String key : t.keySet()) {
        System.out.print("-->" + t.get(s));
        s = t.get(s);
        }
        System.out.println();
    }
    // find the starting point----------->>
    public static String getst(HashMap<String, String> t) {
        HashMap<String, String> rev = new HashMap<>();
        for (String key : t.keySet()) {
            rev.put(t.get(key), key);
        }
        for (String key : t.keySet()) {
            if (!rev.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    // largest subarray length for  sum 0-->>
    public static void ZeroSumSubarray(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(len);
    }
    //subarray sum equal to k -->> count how many possible combination..
    public static void CountSumK(int n[],int k){
        HashMap<Integer,Integer>vm=new HashMap<>();
        vm.put(0, 1);
        int sum=0;
        int ans=0;
        for(int i=0;i<n.length;i++){    //sum(j)-k=sum(i)==>sum(i)-sum(j)=k
            sum+=n[i];
            if(vm.containsKey(sum-k)){   //sum(0,j)-sum(0,i)=sum(i+1,j)
                ans+=vm.get(sum-k);      // sum(0,j)-sum(0,i-1)=sum(i,j)
            }
            vm.put(sum, vm.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
