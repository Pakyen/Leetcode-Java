import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-09 8:41 PM
 */
/*
题目描述：
小明手中有n块积木，并且小明知道每块积木的重量。现在小明希望将这些积木堆起来，要求是任意一块积木如果想堆在另一块积木上面，那么上面积木的重量减去下面积木的重量不能超过x（每堆中最下面的积木没有重量要求）。现在小明有一个机会，除了这n块积木，还可以获得k块任意重量的积木。小明希望将积木堆在一起，同时希望积木堆的数量越少越好，你能帮他找到最好的方案么？
 */
/*
输入描述
第一行三个整数n,k,x，1<=n<=200000，0<=x,k<=1000000000

第二行n个整数，表示积木的重量，任意整数范围都在[1,1000000000]

数字间均有空格隔开

输出描述
一个整数，表示可以堆出的最少积木堆的数量。


样例输入
8 2 3
1 1 5 8 12 13 20 22
样例输出
2

提示
样例2：

输入：

13 0 37

20 20 80 70 70 70 420 5 1 5 1 60 90

输出：

3

解释：

三堆分别是

1 1 5 5 20 20；

60 70 70 70 80 90；

420
 */
/*
ac 9%
 */
public class JD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input0 = in.nextLine();
        String[] nArr = input0.split(" ");
        int n = Integer.parseInt(nArr[0]);
        int k = Integer.parseInt(nArr[1]);
        int x = Integer.parseInt(nArr[2]);

        String input = in.nextLine();
        String[] strArr = input.split(" ");
        //重量
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);
        // list (list)
        // n k x
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(arr[0]);
        res.add(new ArrayList<>(path));

        for (int i = 1; i < n; i++) {
            //遍历list，看看能不能添加
            //i指当前积木
            //j指list序号
            boolean addSuccess = false;
            for (int j = 0; j < res.size(); j++) {
//                res.get(j);//list
                ArrayList<Integer> list = res.get(j);
                if((arr[i]-list.get(list.size()-1))<=x ){
                    list.add(arr[i]);
                    addSuccess = true;
                    res.remove(j);
                    res.add(j,new ArrayList<>(list));
                }
            }
            if(!addSuccess){
                ArrayList<Integer> p = new ArrayList<>();
                p.add(arr[i]);
            }
        }
        int L = res.size();
        int result = L;
        for (int i = 1; i < L; i++) {
            //对于每个list , i

            for (int j = 1; j <= k; j++) {
                int cha = res.get(i).get(0) - res.get(i-1).get(res.get(i-1).size()-1);
                if(cha <= x*(k+1)) {
                    result-=1;
                    int num = cha/x;
                    k-=num;
                }
            }
        }
        System.out.println(result+1);
    }
}
