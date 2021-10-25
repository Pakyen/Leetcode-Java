import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hbx
 * @date 2021-10-25 3:58 PM
 */
/*
    判断字符串字母分布是否均匀

    如果字符串的所有字符的出现次数相同，则认为该字符串是有效的
    或者，如果可以在字符串的某一个索引处删除1个字符，并且其余字符出现的次数相同，那么它也是有效的

    备注：
        1. 可以假设字符串仅包含小写字母
        2. 0 <= length(inputStr) <= 10000

    "shopee"
    true

 */
/*
20分，ac84
 */
public class Main3 {
    public static void main(String[] args) {
        return;
    }
    public boolean isStringBalance(String inputStr) {
        if(inputStr.length()==0) return true;
        HashMap<Character,Integer> map = new HashMap<>();
        //<char, int>
        for (int i = 0; i < inputStr.length(); i++) {
            if(map.containsKey(inputStr.charAt(i))){
                map.put(inputStr.charAt(i), map.get(inputStr.charAt(i))+1);
            }else{
                map.put(inputStr.charAt(i),1);
            }
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;
        int change = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int i = entry.getValue();
            if(change==0&&i<small){
                small = i;
                change++;
            }
            if(change!=0 && i>small){
                change++;
            }
            if(change!=0 && i<small){
                big = small;
                small = i;
                change++;
            }
        }
        if(change<=2 && big<=small+1){
            return true;
        }
        return false;

    }
}
//if(inputStr.length()==2){
//        if( Math.abs(map.get(inputStr.charAt(1)-times)) <=1){
//        return true;
//        }else{
//        return false;
//        }
//        }
