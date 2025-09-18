import java.util.ArrayList;

public class PrintAllPrimeDivisor {
    public static void main(String[] args) {
        //most optimal algorithm time complexity is O(sqrt(N)*logN)
        ArrayList<Integer>list=new ArrayList<>();
        int n=132;
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i == 0){
                list.add(i);
                while (n % i == 0) {
                    n=n/i;
                }
            }
        }
        if(n!=1) list.add((n));
        System.out.print(list);
    }
}
