import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-05 8:55 PM
 */
/*
一个序列，一开始只有n，
每次取一个数x，用[x/2, x mod 2, x/2]代替x，x/2向下取整
如n=5，开始序列为[5]
操作一次变成[2,1,2]
再操作两次变成[1 0 1，1，1 0 1]

问：
最后得到的01序列中，区间[l,r]内有多少个1，序列和区间的下标从1开始


输入 n l r
输出一个整数
 */
/*
ac 30%
 */
public class Tencent4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(n);

        for (int i = 0; i < list.size();) {
            if(list.get(i)>1){
                List<Integer> sublist = new ArrayList<>();
                sublist.add(list.get(i)/2);
                sublist.add(list.get(i)%2);
                sublist.add(list.get(i)/2);
                list.remove(i);
                list.addAll(i,sublist);
            }else{
                i++;
            }
        }
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }
        int res = 0;
        for (int i = l-1; i <= r-1; i++) {
            res += list.get(i);
        }
        System.out.println(res);
    }
}
