import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


/*
jingodng bishi1 youjihuahewu

小明最近在学习《有机化学》。在化学中，有机化合物简称为有机物，是指含碳元素的化合物，其组成元素除碳外，通常还含有氢、氧、氮、硫、磷、卤素等元素。

小明想写个小程序来计算简单有机化合物的分子量（相对分子量），假设需要计算分子量的有机物中只包含C、H、O、N四种元素，其相对原子质量分别如下：

C: 12，H: 1，O：16，N: 14。

例如某有机物的分子式为：C4H9OH，其相对分子量为12*4+1*9+16+1 = 74。

请你帮他实现这个计算相对分子量的程序
 */
/*
单组输入。

输入一行，包含一个只包含字母C、H、O、N和数字的分子式，如果字母后面没有数字则表示该原子只出现1次。在一个分子式中，允许一个元素在不同位置出现多次。分子式的长度不超过100个字符。

输出一个正整数，即计算所得的相对分子量。
 */

// AC 64%
public class JD1 {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('C',12);
        map.put('H',1);
        map.put('O',16);
        map.put('N',14);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();

        int sum = 0;

        int num =0;
        char temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if(c>='0'&&c<='9'){
                num*=10;
                num+=c-'0';
            }else{
                if(num==0){
                    sum += map.get(temp);
                }else{
                    sum += map.get(temp)*num;
                }
                num=0;
                temp = c;
            }
        }
        if(!str.endsWith("\\d+")){
            sum+=map.get(temp);
        }
        System.out.println(sum);
    }
}
//        int i=0;
//        while(i<arr.length){
//            if(map.containsKey(arr[i])){
//                //如果遇到了字母
//                if(i<arr.length-1 &&!map.containsKey(arr[i+1])){
//                    //并且下一位是数字
//                    //但是有可能数字不是个位数
//                    int tmp = 0, t=i;
//                    while(!map.containsKey(arr[t+1])&&t<arr.length-1){
//                        tmp *=10;
//                        tmp+=Character.getNumericValue(arr[t+1]);
//                        t++;
//                    }
//
//                    sum += map.get(arr[i]) * tmp;
//
//                }else{
//                    //或者下一位是字母，或者自己是最后一位
//                    sum += map.get(arr[i]);
//                }
//            }
//            i++;
//        }