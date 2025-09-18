public class Backtracking_NQeens {
    public static void main(String[] args) {
        char board[][]=new char[5][5];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='X';
            }
        }
        Nqueens(board,0);
    }
    public static void Nqueens(char board[][], int row) {
        if (row == board.length) {
            display(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                Nqueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }
    public static boolean issafe(char arr[][], int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
     public static void display(char arr[][]) {
        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("<------------>");
    }
}
