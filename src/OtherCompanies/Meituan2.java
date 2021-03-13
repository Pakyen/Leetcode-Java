import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
美团2
寻找数字

很多数字被藏进了仅包含小写英文字母的字符串中

给定一个字符串s，仅包含小写英文字母和数字，找出其中所有数。一个数是指其中一段无法延伸的连续数字串。如a1254b中仅包含1254这一个数，125则不是，因为125还可以向右延伸成1254。如果该字符串包含前导零，则抹掉前导零。

例如a0125b1c0d00中包含四个数0125，1，0，00，按照规则抹掉前导零后，最终这个字符串包含的四个数为125，1，0，0。即，0125->125，00->0，其中1和0无前导零，无需变更。

AC 45%
*/
public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String tmp = "";
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>=48&&str.charAt(i)<=57){
                tmp+=str.charAt(i);
            }else{
                res.add(tmp);
                tmp="";
            }
        }
        res.add(tmp);
        //转int
        //去前导0
        //排序
        PriorityQueue<Integer> queue  = new PriorityQueue<>();
        for (int i = 0; i < res.size() ; i++) {
            if(res.get(i)!=""){
                queue.add(Integer.parseInt(res.get(i)));
//                System.out.println(Integer.parseInt(res.get(i)));
            }
        }
//        System.out.println(" ");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
