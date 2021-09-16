/**
 * @author hbx
 * @date 2021-09-16 7:05 PM
 */
/*
二进制取反

 */
public class TencentMusic2 {
    public static void main(String[] args) {

    }
    public String maxLexicographical (String num) {
        boolean changed = false;
        for (int i = 0; i < num.length(); i++) {
            if(changed&&num.charAt(i)=='1'){
                break;
            }
            if(isAllOne(num,i)){
                continue;
            }else{
                if(num.charAt(i)!='1'){
                    num = num.replaceFirst(num.substring(i,i+1),"1");
                    changed=true;
                }
            }
        }
        return num;
//        char[] str = new char[num.length()];
//        str = num.toCharArray();
//        for (int i = 0; i < num.length(); i++) {
//            if(changed&&str[i]=='1'){
//                break;
//            }
//            if(isAllOne(str,i)){
//                continue;
//            }else{
//                if(str[i]!='1'){
//                    str[i]='1';
//                    changed=true;
//                }
//            }
//        }
//        num = str.toString();
//        System.out.println(num);
    }
    /*
    字符串从0到i]，是否都是1
     */
    public static boolean isAllOne(String num, int i){
        boolean res = true;
        for (int j = 0; j <= i; j++) {
            if(num.charAt(i)!='1'){
                res =false;
            }
        }
        return res;
    }
}