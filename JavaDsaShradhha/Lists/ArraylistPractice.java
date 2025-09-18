import java.util.*;
class ArraylistPractice{
    public static void main(String[] args) {
        // ArrayList Declation--->
        //Float-->Boolean-->String
        ArrayList<Integer>name=new ArrayList<>();
        name.add(5);
        name.add(6);
        name.add(7);
        name.add(8);
        name.add(1);
        name.add(2);
        name.add(3);
        name.add(4);
        System.out.println(name);

        //Basics Operation--->>
        System.out.println(name.get(0));
        System.out.println(name.remove(2));
        System.out.println(name);
        System.out.println(name.set(1,10));
        System.out.println(name);
        name.add(2,24);
        System.out.println(name);
        System.out.println(name.size());
        System.out.println(name.contains(45));
        ArrayList<Integer>name2=new ArrayList<>();
        name2.add(6);
        name2.add(4);
        name2.add(3);
        name2.add(2);
        name2.add(1);
        System.out.println(name2);
        Collections.sort(name2);
        System.out.println(name2);
        Collections.sort(name2,Collections.reverseOrder());
        System.out.println(name2);

        // multidimentional ArrayList-->

        ArrayList<ArrayList<Integer>>pritam=new ArrayList<>();
        pritam.add(name);
        pritam.add(name2);
        for(int i=0;i<pritam.size();i++){
            ArrayList<Integer>list=pritam.get(i);
            for(int j=0;j<list.size();j++){
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }
    }
    //container with max water
    public static int container_with_line(ArrayList<Integer>name){
        int lp=0;int rp=name.size()-1;
        int max=Integer.MIN_VALUE;
        while(lp!=rp){
            int ht=Math.min(name.get(lp),name.get(rp));
            int width=rp-lp;
            int curr=width*ht;
            max=Math.max(max,curr);
            if(name.get(lp)<name.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return max;
    }
    // pair sum for a target value-->
    public static boolean pair_sum(ArrayList<Integer>name,int target){
        int lp=0;
        int rp=name.size()-1;
        while(lp!=rp){
            if((name.get(lp)+name.get(rp))==target){
                return true;
            }
            if(name.get(lp)+name.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }
    //pair sum in sorted rotated array--->
    public static boolean PairSumSortedArray(ArrayList<Integer>name,int target){

        int bp=-1;
        for(int i=0;i<name.size();i++){
            if(name.get(i)>name.get(i+1)){
                bp=i;
                break;
            }
        }
        int rp=bp;
        int lp=bp+1;
        while(lp!=rp){
            if(name.get(rp)+name.get(lp)==target){
                return true;
            }
            if(name.get(lp)+name.get(rp)<target){
                lp=(lp+1)%name.size();
            }else{
                rp=(name.size()+rp-1)%name.size();
            }
        }
        return false;
    }

}