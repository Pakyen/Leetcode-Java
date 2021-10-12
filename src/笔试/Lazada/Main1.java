import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-09 9:28 PM
 */
/*
压缩字符串
输入：
abcdabcde
xxxrryyyyyyzzg

输出：
abcdabcde
3x2r6y2zg
 */
/*
ac40%
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        while (in.hasNext()){
            String str = in.next();
            input.add(str);
        }
        for (int k = 0; k < input.size(); k++) {
            StringBuilder res = new StringBuilder();
            int len = input.get(k).length();
            String str = input.get(k);
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                if(i==len-1) res.append(str.charAt(i));
                if (i<len-1&&str.charAt(i)!=str.charAt(i+1)){
                    res.append(str.charAt(i));
                }else{
                    int count = 1;
                    for (int j = i+1; j < str.length(); j++) {
                        if(str.charAt(i)==str.charAt(j)){
                            count++;
                        }else{
                            res.append(count);
                            res.append(str.charAt(i));
                            i=j-1;
                            break;
                        }
                    }
                }
            }
            System.out.println(res.toString());
        }
    }
}
