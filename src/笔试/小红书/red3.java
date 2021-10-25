import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-23 11:00 AM
 */
//ac80%
    /*
    输入描述
第一行是一个字符串数组，表示一组词库

第二行是一个文本，表示要检查的文本内容

输出描述
该文本是否能用输入的词组分词成功


样例输入
my name is red
ismynamered
样例输出
true
     */
public class red3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ar = in.nextLine();
        String str = in.nextLine();
        String[] arr = ar.split(" ");
        int[] res = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            int j = str.indexOf(arr[i]);
            if(j>=0){
                int left = j;
                int right = j+arr[i].length();
                for (int k = left; k < right; k++) {
                    res[k] = 1;
                }
            }
        }
        boolean result = true;
        for (int i = 0; i < res.length; i++) {
            if(res[i]!=1){
                result=false;
            }
        }
        System.out.println(result);
    }
}
