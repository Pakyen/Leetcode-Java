import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-04 5:07 PM
 */
/*
题目描述：
小美天天刷题，收获了很多ac。为了纪念这些ac，小美记下了一个长度为n的仅有a和c组成的字符串。小团天天摸鱼不刷题，所以ac没有小美多。小团决定在小美睡觉的时候把小美字符串中的ac通过交换相邻两个字符全部消除。即通过一系列交换相邻字符的操作使得操作后的串中不存在ac这个字串。小团想知道他至少要交换多少次才能达成他的目的。

输入描述
第一行有一个整数n(1<=n<=100000)，代表小美拥有的字符串长度。

第二行有一个仅由a和c组成的字符串，代表小美的字符串。

输出描述
输出一个整数，代表小团想知道的答案。

如样例中先交换前两个字符再交换中间两个字符即可使小美的字符串变成ccaa。


样例输入
4
acca
样例输出
2
 */


/*
ac 91%
 */
public class Meituan3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        StringBuilder str = new StringBuilder(s);
        int res = 0;
        int i=0;
        if(n<2){
            System.out.println('0');
            return;
        }
        for (int j = 0; j < n; j++) {
            int flag = 0;
            while(i<n-1){
                if(str.charAt(i)=='a' && str.charAt(i+1)=='c'){
                    res+=1;
                    str.replace(i,i+2,"ca");
                    flag = 1;
                }
                i++;
            }
            i=0;
            if(flag==0){
                break;
            }
        }
        System.out.println(res);
    }
}
