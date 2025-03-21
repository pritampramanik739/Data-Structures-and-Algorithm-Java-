
public class Backtracking_suduku {

    public static void main(String[] args) {
        int arr[][] = {
            {0,8,0,0,3,0,0,5,0},{0,0,0,0,0,9,7,6,3},{6,0,0,0,1,0,0,0,0},{0,0,1,4,0,0,0,0,0},{9,0,0,5,0,8,0,0,4},{0,0,0,0,0,3,9,0,0},{0,0,0,0,4,0,0,0,8},{3,7,8,9,0,0,0,0,0},{0,4,0,0,5,0,0,7,0}};

        suduku(arr, 0, 0);
    }

    public static void displayed(int arr[][]) {

        System.out.println("<--------------->");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void suduku(int arr[][], int i, int j) {
        if (i == arr.length) {
            displayed(arr);
            return;
        }
        int ni;
        int nj;
        if (j == arr[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (arr[i][j] != 0) {
            suduku(arr, ni, nj);
        } else {
            for (int p = 1; p <= 9; p++) {
                if (issvalid(arr, i, j, p)) {
                    arr[i][j] = p;
                    suduku(arr, ni, nj);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static boolean issvalid(int arr[][], int x, int y, int val) {
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[x][j] == val) {
                return false;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j][y] == val) {
                return false;
            }
        }

        int smi = (x / 3) * 3;
        int smj = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[smi + i][smj + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
