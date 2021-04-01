package Backtracking.Partition;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    List<String> res = new ArrayList<>();
    int pointNum = 0;

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backTracking(sb,0,0);
        return res;
    }
    private void backTracking(StringBuilder s, int startIndex, int pointNum){
        if(pointNum==3){
            //三个逗号 分割结束
            if(isValid(s,startIndex,s.length()-1)){
                res.add(s.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if(isValid(s,startIndex,i)){
                s.insert(i+1,'.');
                pointNum+=1;
                backTracking(s,i+2,pointNum);
                pointNum-=1;
                s.deleteCharAt(i+1);
            }else break;
        }

    }
    private boolean isValid(StringBuilder s, int start, int end){
        if(start>end || start>=s.length()) return false;
        if(s.charAt(start)=='0'&&start!=end) return false;
        int num =0;
        for (int i = start; i <= end; i++) {
            if(s.charAt(i)>'9'||s.charAt(i)<'0') return false;
            num = num*10 + (s.charAt(i) - '0');
            if(num>255) return false;
        }
        return true;
    }
}
