/**
 * @author hbx
 * @date 2021-10-13 7:29 PM
 */
/*
给定两个字符串A和B，每个字符串都由许多个字符组成，且在A和B中，每个字符都各只出现最多一次。

将字符串A中，A和B共有的字符的位置顺序，调整为这些字符在B中出现的顺序。
 */
//ac100%
public class bilibili2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String res;
//
//        String _a;
//        try {
//            _a = in.nextLine();
//        } catch (Exception e) {
//            _a = null;
//        }
//
//        String _b;
//        try {
//            _b = in.nextLine();
//        } catch (Exception e) {
//            _b = null;
//        }
//
//        res = new Solution().reorder(_a, _b);
//        System.out.println(res);
    }
    public String reorder(String a, String b) {
        char[] seq = b.toCharArray();
        char[] arr = a.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if(arr[i]==seq[j]){
                    arr[i] = '0';
                    break;
                }
            }
        }
        int i=0;
        int j=0;
        while(i<a.length()){
            if(arr[i]=='0'){
                arr[i] = seq[j];
                j++;
            }
            i++;
        }
        return String.valueOf(arr);
    }
}
