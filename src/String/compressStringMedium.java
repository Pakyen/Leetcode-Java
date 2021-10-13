/**
 * @author hbx
 * @date 2021-10-13 11:00 AM
 */
/*
    source: https://leetcode-cn.com/problems/string-compression/
 */
/*
    要求：只使用常量额外空间 -> 结果还保存在chars中
 */

public class compressStringMedium {
    public static void main(String[] args) {
        return;
    }
    public int compress(char[] chars) {
        int i = 0; //读指针
        int w = 0; //写指针
        char cur = chars[0];

        while(i<chars.length){
            int count = 1;
            while(i<chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            chars[w++] = cur;
            if(count>=10){
                //count>=10
                char[] numArr = String.valueOf(count).toCharArray();
                for (int j = 0; j < numArr.length ;j++) {
                    chars[w++] = numArr[j];
                }
            }else if(count>1){
                chars[w++] = Integer.toString(count).charAt(0);
            }
            i++;
            if(i<chars.length) cur = chars[i];
        }
        return w;
    }
}
