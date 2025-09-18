import java.util.*;
public class PowerExponent {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(); // a^b
        int c=sc.nextInt();
        int b=Math.abs(c);
        float ans=1f; //double--
        while(b>0) {
            if(b%2==1){
                ans=ans*a;
                b=b-1;
            }else{
                b=b/2;
                a=a*a;
            }
        }
        if(c<0){
            ans=(float)1.0/ans; //if float/double value 1.0
        }
        System.out.println(ans);
        sc.close();
    }
}
