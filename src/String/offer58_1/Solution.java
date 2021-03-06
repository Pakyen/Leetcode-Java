package String.offer58_1;

public class Solution {
    public String reverseWords(String s){
        //该方法返回一个去除首尾空格的copy
        s = s.trim();
        int j =s.length()-1;
        int i=j;
        StringBuilder res = new StringBuilder();
        while(i>=0){
            //1.搜索首个空格
            while(i>=0 && s.charAt(i)!=' ')
                i--;
            res.append(s.substring(i+1,j+1) + ' ');
            //ps: substring左闭右开

            //2.跳过单词间的空格
            while(i>=0 && s.charAt(i)==' ')
                i--;
            //j指向下个单词的尾字符
            j=i;
        }
        return res.toString().trim();//转化为字符串并返回
    }
}
