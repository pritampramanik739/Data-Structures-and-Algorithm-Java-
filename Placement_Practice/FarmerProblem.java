import java.util.*;

public class FarmerProblem {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ans = ans ^ i;
            list.add(ans);
        }
        for (int i = 2; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        System.out.print(sum);
        sc.close();

    }
}

//n farmers problem 
/*
 * let 3 farmer={1,2,3}
 * for one farmer =1
 * for 2 farmer 1^2=3
 * for 3 farmer 1^2^3=0
 * so the answer will be =1+3+0=4
 */
