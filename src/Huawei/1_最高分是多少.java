/*
https://www.nowcoder.com/questionTerminal/3897c2bcc87943ed98d8e0b9e18c4666
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.

输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输出描述:
对于每一次询问操作，在一行里面输出最高成绩.

输入例子1:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子1:
5
6
5
9

此题需要注意的地方：
1,不止输入一组n m ;

2,AB之间，可能A>B（大坑）

3.学生ID是从1开始编号的！！
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //1. 处理输入N M
            String line = sc.nextLine();
            String[] str = line.split("\\s");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            //2. 存储学生成绩
            line = sc.nextLine();
            str = line.split("\\s");
            int[] grades = new int[N];
            for (int i = 0; i < N; i++) {
                grades[i] = Integer.parseInt(str[i]);
            }
            //3. 处理查询和更新
            for (int i = 0; i <M ; i++) {
                line = sc.nextLine();
                str = line.split("\\s");
                String c = str[0];
                int A = Integer.parseInt(str[1]);
                int B = Integer.parseInt(str[2]);

                if(c.equals("Q")){
                    System.out.println(maxGrade(A-1,B-1,grades));
                }
                if(c.equals("U")){
                    grades[A-1] = B;
                }
            }
        }
    }
    public static int maxGrade(int a, int b, int[] ass){
        if(a>b)
            return maxGrade(b,a,ass);
        //最大堆
        PriorityQueue<Integer> tmp = new PriorityQueue<>((x,y)->y-x);
        for (int i = a; i <=b ; i++) {
            tmp.add(ass[i]);
        }
        return tmp.peek();
    }
}