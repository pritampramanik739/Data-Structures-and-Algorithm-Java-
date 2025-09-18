public class StrongNumber {
    public static void main(String[] args) {
        int n=145;
        if(Strong(n)){
            System.out.println("strong number");
        }else{
            System.out.println("Not strong number");
        }
    }
    public static int fact(int n){
        int i=1;
        for(int j=1;j<=n;j++){
            i=i*j;
        }
        return i;
    }
    public static boolean Strong(int n){
        int num=n;
        int sum=0;
        while(num!=0){
            int digit=num%10;
            sum=sum+fact(digit);
            num=num/10;
        }
        return sum==n;
    }
}
