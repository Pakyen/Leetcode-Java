/**
 * @author hbx
 * @date 2021-10-25 3:53 PM
 */
/*
    反转语句，保持空格和单词的顺序不变
    "hello world, my friends"
    "olleh ,dlrow ym sdneirf"

    在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
/*
15分，ac100%
 */
public class Main2 {
    public static void main(String[] args) {
        return;
    }
    private static String ReverseString(String originStr){
        String[] arr = originStr.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(reverseWord(arr[i]));
            if(i!=arr.length-1){
                res.append(" ");
            }
        }
        return res.toString();
    }
    private static String reverseWord(String str){
        StringBuilder res = new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
