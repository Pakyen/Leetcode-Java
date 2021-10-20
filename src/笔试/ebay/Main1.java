import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-19 8:06 PM
 */
/*
ebay1:
判断几乎回文字符串
几乎回文字符串 = 回文字符串 + 修改1个字符就能变成回文字符串

 ac100%
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            if(isHuiWen(str)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    private static boolean isHuiWen(String str){
        StringBuffer str2 = new StringBuffer(str);
        str2.reverse();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=str2.charAt(i)){
                count++;
            }
        }
        if(count<=2){
            return true;
        }else{
            return false;
        }
    }
}
