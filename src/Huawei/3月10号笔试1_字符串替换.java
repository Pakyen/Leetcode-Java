import java.util.Scanner;

/*
华为1 字母替换
小写字母字符串，小红的比小明的长，小红可以有限次地替换一个字母为另一个字母
小明：str1 abba
小红：str2 adbba

1. 没有超过最大替换次数，str2，替换了字母变成str1，输出最少替换次数
2. 如果不可以，或者不需要替换就满足，输出0
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int n = sc.nextInt();
        int[] minRep = new int[str2.length()-str1.length()+1];
        int l =0, r=0;
        for (int i = 0; i < str2.length()-str1.length()+1; i++) {
            int count =0;
            for (int j = 0; j < str1.length(); j++) {
                if(str1.charAt(j)!=str2.charAt(j+i)){
                    count++;
                }
            }
            minRep[i] = count;
        }
        int min = minRep[0];
        for (int i = 1; i < str2.length()-str1.length()+1; i++) {
            if(minRep[i]<min){
                min = minRep[i];
            }
        }
        if(min==0||min>n){
            System.out.println('0');
        }else{
            System.out.println(min);
        }

    }
}
