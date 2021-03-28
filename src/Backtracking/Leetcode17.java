package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    List<String> res = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>();
    StringBuilder str = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        //这里如果输入为"" ，要返回[] 而不是[""]
        //所以//这里不能判断digits=="",要判断digits.length()==0
        if(digits.length()==0) return res;

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTracking(digits, 0);
        return res;
    }
    private void backTracking(String digits, int index){
        //确定返回条件, index用来记录遍历到第几个数字了
        if(index==digits.length()){
            res.add(new String(str));
            return;
        }

        //取index位指向的数字
        char d = digits.charAt(index);
        //数字对应的字母集
        String letters = map.get(d);
        //在数字对应的字母集里循环
        for (int i = 0; i < letters.length(); i++) {
            str.append(letters.charAt(i));
            backTracking(digits,index+1);
            str.deleteCharAt(str.length()-1);
        }

    }
}
