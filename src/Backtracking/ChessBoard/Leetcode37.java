package Backtracking.ChessBoard;

/**
 * @author hbx
 * @date 2021-04-05 10:27
 */
public class Leetcode37 {
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    private boolean backTracking(char[][] board){
        for(int i=0;i<9;i++){ //
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') continue;
                for(char k='1'; k<='9'; k++){
                    if(isValid(board,i,j,k)){
                        board[i][j]=k;
                        if(backTracking(board)) return true;
                        board[i][j]='.';
                    }
                }
                return false;   //IF 1-9 doesn't fit this grid, then return false
            }
        }
        return true;
    }

    private boolean isValid(char[][] board,int row, int col, char val){
        for(int i=0;i<9;i++){ //same row
            if(board[row][i]==val) return false;
        }
        for(int i=0; i<9; i++){ // same column
            if(board[i][col]==val) return false;
        }
        // 9 space
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol; j<startCol+3; j++){
                if(board[i][j]==val) return false;
            }
        }
        return true;
    }
}
