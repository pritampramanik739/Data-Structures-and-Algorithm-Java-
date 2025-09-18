/*
 * Anumber is called Beautiful Number if the bitwise XOR of all elements from 0 to x is equal to x
 * task is given array A of n integer find the number of beautiful elements int it 
*/

public class BeautifulNUmber {
    public static void main(String[] args) {
        long arr[]={1,2,3,4,5};
        long result=0;
        for(long x : arr){
            if((x & 3)==0 || x==1) result++; // x % 4 ==0 logic also valid
        }
        System.out.println(result);
    }  
}
