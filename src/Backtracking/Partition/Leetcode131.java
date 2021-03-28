package Backtracking.Partition;

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    private void backTracking(String s,int startIndex){
        //终止条件 //如果起始位置已经大于等于s的大小，说明找到了一组分割方案
        //注意这里是 >=
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if(isPalindrome(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
                backTracking(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        for (int i=start, j=end; i <= j ; i++,j--) {
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

}
