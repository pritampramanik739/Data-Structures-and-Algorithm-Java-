import java.util.*;
public class HashSet_Practice {
    public static void main(String[] args) {
        // Hashset----->>>>> 1.null  allowed 2.no duplicate
        HashSet<Integer> j = new HashSet<>();
        j.add(1);
        j.add(3);
        j.add(8);
        j.add(9);
        j.add(null);
        System.out.println(j);

        // iteration method-->>
        @SuppressWarnings("rawtypes")
        Iterator it = j.iterator();
        while (it.hasNext()) {
        System.out.print(it.next()+" ");
        }
        System.out.println();
        // advanced loop-->
        for (Integer n : j) {
        System.out.print(n+" ");
        }

        // Linked Hashset---> ordered usind double LinkedList--<><><>
        LinkedHashSet<Integer> l = new LinkedHashSet<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);

        // TreeSet--->>>1.sorted 2.null values are not allowed..
        TreeSet<String> ts = new TreeSet<>();
        ts.add("ritam");
        ts.add("pritak");
        ts.add("hjgkvb");
        System.out.println(ts);

    }
    //count distinct element---->
    public static void CDE(int arr[]){
        HashSet<Integer> count = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            count.add(arr[i]);
        }
       System.out.println(count.size());
    }
    //union and intersection count----->
    public static void Union_Intersection(int arr1[],int arr2[]){
        HashSet<Integer> count = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            count.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            count.add(arr2[i]);
        }
        System.out.println("Union is = "+ count.size());

        count.clear();
        for(int i=0;i<arr1.length;i++){
            count.add(arr1[i]);
        }
        int cp=0;
        for(int i=0;i<arr2.length;i++){
            if(count.contains(arr2[i])){
                cp++;
                count.remove(arr2[i]);
            }
        }
        System.out.println("Intersection is = "+ cp);
    }
}
