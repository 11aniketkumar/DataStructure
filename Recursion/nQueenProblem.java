// import java.util.*;

public class nQueenProblem
{
    public static void nQueen(int[][] board, int row, int col, int col_check[], int top_diagonal[], int bottom_diagonal[], int n) {
        if (row == n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i = row; i < n; i++) {
            for(int j = col; j < n; j++) {
                if(col_check[j] == 0) {
                    if(top_diagonal[i+((n-1)-j)] == 0) {
                        if(bottom_diagonal[i+j] == 0) {
                            col_check[j] = 1;
                            top_diagonal[i+((n-1)-j)] = 1;
                            bottom_diagonal[i+j] = 1;
                            board[i][j] = 1;
                            
                            nQueen(board, i+1, 0, col_check, top_diagonal, bottom_diagonal, 4);
                            
                            col_check[j] = 0;
                            top_diagonal[i+((n-1)-j)] = 0;
                            bottom_diagonal[i+j] = 0;
                            board[i][j] = 0;
                        }
                    }
                }
            }
            
            for(int x = 0; x < n; x++) {
                if(board[i][x] == 1) {
                    break;
                }
                return;
            }
        }
    }
    
	public static void main(String[] args) {
		int n = 4;
        
        nQueen(new int[n][n], 0, 0, new int[4], new int[2*n-1], new int[2*n-1], 4);
	}
}