public class TwoDimentionalArray {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int mat[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}}; 
        // spiral_matrix(arr);
        // System.out.println();
        // searchmatrix(mat, 48);
        // for(int x[]:arr)
        // {
        //     for(int y:x)
        //     {
        //         System.out.printf("%02d ",y);
        //     }
        //     System.out.println("");
        // }
        MatrixMultiplication(arr, mat);
    }
    //Spiral Matrix
    public static void spiral_matrix(int arr[][]) {
        int r = 0;
        int c = 0;
        int lr = arr.length - 1;
        int lc = arr[0].length - 1;
        while (r <= lr && c <= lc) {
            // top part..
            for (int i = c; i <= lc; i++) {
                System.out.print(arr[r][i] + " ");
            }
            // right print..
            for (int i = r + 1; i <= lr; i++) {
                System.out.print(arr[i][lc] + " ");
            }
            // bottom part..
            for (int i = lc - 1; i >= c; i--) {
                if (r == lr) {
                    break;
                }
                System.out.print(arr[lr][i] + " ");
            }
            // left part..
            for (int i = lr - 1; i >= r + 1; i--) {
                if (c == lc) {
                    break;
                }
                System.out.print(arr[i][c] + " ");
            }
            c++;
            r++;
            lc--;
            lr--;
        }
    }
    //Diagonal Sum
    public static int diagonal(int ar[][]){
        int sum=0;
        for(int i=0;i<ar.length;i++){
            sum+=ar[i][i];
            if(i!=ar.length-1-i){
                sum+=ar[i][ar.length-1-i];
            }
        }
        System.out.print(sum);
        return sum;
    }
    //Search in Sorted Matrix
    public static void searchmatrix(int arr[][],int key){
        int r=0;int c=arr[0].length-1;
        while(r<arr.length && c>=0){
            if(arr[r][c]==key){
                System.out.print("index at : ( "+ r + ","+ c+ ")" );
                break;
            }
            else if(key>arr[r][c]){
                r++;
            }
            else{
                c--;
            }
        }
    }
    //matrix multiplication 
    public static void MatrixMultiplication(int arr[][],int mat[][]){
        int row1,col1,row2,col2;
        row1=arr.length;
        col1=arr[0].length;
        row2=mat.length;
        col2=mat[0].length;
        if(col1!=row2){
            System.out.println("Invalid Matrix");
        }
        int[][]prod= new int[row1][col2];
        for(int i=0;i<prod.length;i++){
            for(int j=0;j<prod[0].length;j++){
                for(int k=0;k<col1;k++){
                    prod[i][j]+=(arr[i][k]*mat[k][j]);
                }
            }
        }
        for(int i=0;i<prod.length;i++){
            for(int j=0;j<prod[0].length;j++){
                System.out.printf("%d ",prod[i][j]);
            }
            System.out.println();
        }
    }
}
