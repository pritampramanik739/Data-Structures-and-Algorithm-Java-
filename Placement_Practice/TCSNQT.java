import java.util.*;
public class TCSNQT{
    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        // Told that input is integer format
        System.out.print("Give Array size : ");
        int n=sc.nextInt();
        System.out.print("Give ArrayElement: ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println();

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }


        System.out.println();
        System.out.println();

        // flush the leftover newline
        sc.nextLine(); // <-- Add this line


        /* 

        //Input without Size
        List<Integer>list=new ArrayList<>();
        System.out.print("Give ListElement: ");
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        System.out.println();
        for(int val:list){
            System.out.print(val+" ");
        }


        */

        System.out.println();


        //Input As String
        System.out.print("Give StringList: ");
        String str=sc.nextLine();
        String[] token=str.split("\\s+");
        List<Integer>num=new ArrayList<>();
        for(String val: token){
            num.add(Integer.valueOf(val));  //Integer.parseInt(val)
        }
        System.out.println();
        for(int val:num){
            System.out.print(val+" ");
        }

        System.out.println();


        //String input is given but not tell what kind of input
        System.out.print("Give StringAnyType [] or , or anyType: ");
        String line=sc.nextLine();
        List<Integer> List =new ArrayList<>();
        StringBuilder numstr=new StringBuilder();
        for(Character ch:line.toCharArray()){
            if(Character.isDigit(ch)){
                numstr.append(ch);
            }else if (numstr.length()>0) {
                List.add(Integer.parseInt(numstr.toString()));
                numstr.setLength(0);
            }
        }
        if(numstr.length()>0){
            List.add(Integer.parseInt(numstr.toString()));
        }

        System.out.println();

        for(int i=0;i<List.size();i++){
            System.out.print(List.get(i)+" ");
        }


        System.out.println();


        // input 0-9 only
        System.out.print("send input: ");
        String go=sc.nextLine();
        List<Integer>jb=new ArrayList<>();
        for (char c : go.toCharArray()) {
            if (Character.isDigit(c)) {
                jb.add(c - '0');
            }
        }

        for (int c : jb) {
            System.out.print(c+" ");
        }

    }
}