import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-27 11:24 AM
 */
/*
通配符匹配
? 一次
# 0或1次
* 0或多次
a?c
abc
匹配返回1，不匹配返回0

ac63%
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        if(isMatch(s1,s2)){
            System.out.println('1');
        }else{
            System.out.println('0');
        }
    }
    static boolean isMatch(String s1, String s2){
        int i=0,j=0;
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)=='?'){
                i++;
                j++;
                continue;
            } else if(s1.charAt(i)=='#'){
                if(isMatch(s1.substring(0,i)+s1.substring(i+1,s1.length()),s2)) return true;
                i++;
                continue;
            } else if(s1.charAt(i)=='*'){
                return true;
            }else{
                if(s1.charAt(i)!=s2.charAt(j)){
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }


}
