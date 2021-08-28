/**
 * @author hbx
 * @date 2021-08-14 9:51 AM
 */
/*
将输入的字符串转换为驼峰（camelCase）风格。
1. 转换后的字符串只保留字母[a-zA-Z]和数字[0-9]，去除其他字符；
2. 输入字符串中的字母字符的前一字符如非字母或数字，该字母转换后为大写，其他字母转换后为小写；
    例外：转换后的字符串第一个字符如果是字母，则该字母转换后为小写；
3. 转换后的字符串保留数字字符。

 */
/*
hbx:
1. 去除除了a-zA-z和0-9之外的字符
2.输入的字符串中，有字母字符，如果字母字符的前面一个字符，不是字母or数字，这个字母转换为答谢，其他字母转为消协

 */
import java.util.Scanner;

public class Shoppe1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder re = new StringBuilder();
        int len = str.length();
        boolean up = false;
        int i=0,j=0,k=0;
        while(i<len) {
            if(Character.isLetter(str.charAt(i))) {
                //如果是字母
                if (i == j) up = true;
                i++;
                k++;
            }else if(Character.isDigit(str.charAt(i))){
                //如果是数字
                i++;
                k++;
            }else{
                //如果不是字母也不是数字
                String s = str.substring(j,i).toLowerCase();
                if(up){
                    re.append(Character.toUpperCase(s.charAt(0))+s.substring(1,s.length()));
                    up = false;
                }else{
                    re.append(s.substring(0,s.length()));
                }
                i++;
                j=i;
            }
        }
        if(i!=j){
            String s = str.substring(j,i).toLowerCase();
            if(up){
                re.append(Character.toUpperCase(s.charAt(0))+s.substring(1,s.length()));
                up=false;
            }else{
                re.append(s.substring(0,s.length()));
            }
        }
        if(Character.isLetter(re.charAt(0))){
            System.out.println(Character.toLowerCase(re.charAt(0))+re.substring(1,re.length()));
        }else{
            System.out.println(re.toString());
        }

    }
}
