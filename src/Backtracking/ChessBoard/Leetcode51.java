package Backtracking.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backTracking(n,0);
        return res;
    }
    private void backTracking(int n, int row){
        if(path.size()==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int col=0; col<n; col++){
            if(isValid(row,col,n)){
                path.add(generateString(col,n));
                backTracking(n,row+1);
                path.remove(path.size()-1);
            }else{
                continue;
            }
        }
    }
    private boolean isValid(int row, int col, int n){
        //JUDGE COLUMN

        for(int i=row-1;i>=0;i--){
            if(path.get(i).charAt(col) == 'Q') return false;
        }
        for(int i=row-1,j=col-1; i>=0&&j>=0; i--,j--){
            if(path.get(i).charAt(j) == 'Q') return false;
        }
        for(int i=row-1,j=col+1; i>=0&&j<n ;i--,j++){
            if(path.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
    private String generateString(int pos, int n){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<pos;i++) str.append(".");
        str.append("Q");
        for(int i=pos+1;i<n;i++) str.append(".");
        return str.toString();
    }
}
