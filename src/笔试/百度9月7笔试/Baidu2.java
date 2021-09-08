import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-07 11:33 PM
 */
/*
十进制整数x

如果x的每一位只能是1，2，3中的一个，则x是完美数
如，123，1，3321都是；而5，1234则不是

函数f(n)，返回最大的，不大于n的完美数
 */
public class Baidu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine()); //t
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            int[] arr = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                arr[j] = str.charAt(j) -'0';
            }
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if(flag){
                    arr[j] = 3;
                }else if(arr[j]>=1 &&arr[j]<=3){
                    continue;
                }else if(arr[j]>3){
                    flag = true;
                    arr[j] = 3;
                }else{
                    if(!flag){
                        int tmp = j-1;
                        while(tmp!=0&&arr[tmp]==1){
                            tmp--;
                        }
                        arr[tmp]--;
                        tmp++;
                        for (;tmp<j;tmp++){
                            arr[tmp]=3;
                        }
                        flag = true;
                    }
                    arr[j]=3;
                }
            }
            int x = 0;
            for (; x < arr.length; x++) {
                if(arr[x]!=0){
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (;x<arr.length;x++) {
                sb.append(arr[x]);
            }
            System.out.println(sb);
        }

    }
}
