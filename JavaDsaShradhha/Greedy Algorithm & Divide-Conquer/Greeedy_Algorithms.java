import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Greeedy_Algorithms {
    public static void main(String[] args) {
        
    }
    
    // chocolate problem-->
    public static void Chocolate(Integer costhor[], Integer costver[]) {
        Arrays.sort(costhor, Collections.reverseOrder());
        Arrays.sort(costver, Collections.reverseOrder());
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costhor.length && v < costver.length) {
            if (costver[v] <= costhor[h]) {
                cost += (costhor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costver[v] * hp);
                vp++;
                v++;
            }
        }
        while (v < costver.length) {
            cost += (costver[v] * hp);
            vp++;
            v++;
        }
        while (h < costhor.length) {
            cost += (costhor[h] * vp);
            hp++;
            h++;
        }
        System.out.println("cost is : "+cost);
    }

    // job sequncing-->
    static class job {
        int deadline;
        int profit;
        int id;

        public job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void Job_Sequncing(Integer a[][]) {
        ArrayList<job> m = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            m.add(new job(i, a[i][0], a[i][1]));
        }
        Collections.sort(m, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < m.size(); i++) {
            job curr = m.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        int max = 0;
        System.out.println("max jobs = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            max += a[seq.get(i)][1];
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
        System.out.println("jobs profit  = " + max);
    }

    // coin changer--->
    public static void Coin(Integer a[]) {
        Arrays.sort(a, Comparator.reverseOrder());
        int count = 0;
        int amount = 890;
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= amount) {
                while (a[i] <= amount) {
                    count++;
                    b.add(a[i]);
                    amount -= a[i];
                }
            }
        }
        System.out.println("total coin used :" + count);

        for (int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i) + " ");
        }
    }

    // maximum length chain of pairs--->
    public static void MLC(int a[][]) {
        Arrays.sort(a, Comparator.comparingDouble(o -> o[1]));
        int chain = 1;
        int chain_end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > chain_end) {
                chain++;
                chain_end = a[i][1];
            }
        }
        System.out.println("chain length is : " + chain);
    }

    // minimum absolute diffence-->
    public static void MAD(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int mindiff = 0;

        for (int i = 0; i < a.length; i++) {
            mindiff += Math.abs(a[i] - b[i]);
        }

        System.out.println("min absolute diff of pairs = " + mindiff);
    }

    // Functionl Knapsack--->
    public static void Knapsack(int val[], int weight[]) {
        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = 50;
        int final_val = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int id = (int) ratio[i][0];
            if (capacity >= weight[id]) {
                final_val += val[id];
                capacity -= weight[id];
            } else {
                final_val += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("knapsack value is : " + final_val);
    }

    // Activity Selection
    public static void Activity(int start[], int end[]) {

        int activity[][] = new int[start.length][2];

        for (int i = 0; i < start.length; i++) {
            activity[i][0] = start[i];
            activity[i][1] = end[i];
        }

        //lamda function--> sorted based on 1st index if we wanr 0th index used row[0]..
        Arrays.sort(activity, Comparator.comparing(row -> row[1]));

        // endtime basics sort-->
        int maxact;
        ArrayList<Integer> a = new ArrayList<>();

        //1st activity
        maxact = 1;
        a.add(activity[0][0]);
        int last = activity[0][1];
        for (int i = 1; i < start.length; i++) {
            if (activity[i][0] >= last) {
                maxact++;
                a.add(activity[i][0]);
                last = activity[i][1];
            }
        }

        System.out.println("max activity=" + maxact);
        for (int i = 0; i < a.size(); i++) {
            System.out.print("A" + a.get(i) + " ");
        }
        System.out.println();

    }


}
