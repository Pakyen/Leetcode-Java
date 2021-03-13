/*
美团3 数数
小美正在统计她公司的数据。她想要知道一定时间段内的某种特征，因此，她将n条数据按时间排好序依次给出，想要知道以某条数据开始的一个连续数据段内数据的众数情况。

形式化地，给出n个数a1,.....,an分别表示时刻1,2,....,n的数据值。小美想要知道连续K条数据的情况，即ai,...,ai+K-1。请你求出当i=1,2,...,n-K+1时，ai,...,ai+K-1这些数据中的"众数"。如果"众数"有多个，输出最小的那一个。

注意，此处“众数”的定义与通常定义有些许区别。我们这样定义 “众数”：如果出现次数最多的数只有一个数，那么“众数”就是它；否则，众数为出现次数最多的数中，数值最小的那一个。

例如，序列[1 2 3 3]中， 3出现了两次，其他数仅出现了一次，所以“众数”为3。

序列[1 2 3]中，三个数出现次数都为1次，都是出现次数最多的数（不存在出现次数大于1的数），所以“众数”是其中的数值最小的1。

序列[5 2 5 2 3 3 4]中，5、2、3均出现了2次，都是出现次数最多的数（不存在出现次数大于2的数），所以“众数”是其中的数值最小的2。

输入描述
第一行两个数n和K分别表示数据总量以及她想要了解的连续数据长度。

第二行n个数a1,...,an，表示各个数据值。

1≤K≤n≤105， 1≤ai≤109

输出描述
输出n-K+1行，每行一个数，依次表示从i=1到i=n-K+1时，ai,...,ai+K-1中的众数。如果众数有多个，输出最小的那一个。


样例输入
5 3
1 2 2 1 3
样例输出
2
2
1

提示
i=1时，1 2 2中众数为2
i=2时，2 2 1 中众数为2
i=3时，2 1 3中三个数次数均相同，输出最小的那一个数1
 */
/*
说明：
所有测试数据正确率为 73%！
可以尝试再次完善代码，并调试，争取全部AC通过

温馨提示：有时候，申请大的全局数组会导致超时，如果有此类情况，请检查您的全局数组是否超过题目要求的内存大小。
排除这个错误后，再检查别的情况引起的超时错误：例如死循环、循环结束条件错误等，或者需要更好的算法！
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int t = 0; t < n-k+1; t++) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = t; i <= t+k-1; i++) {
                int x = arr[i];
                if(map.containsKey(x)){
                    map.put(x,map.get(x)+1);
                }else{
                    map.put(x,1);
                }
            }
            PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                queue.add(entry);
            }
            PriorityQueue<Integer> res = new PriorityQueue<>();
            int num = queue.peek().getValue();
            while(!queue.isEmpty()&&queue.peek().getValue()==num){
                res.add(queue.poll().getKey());
            }

            System.out.println(res.peek());
        }
    }
}
