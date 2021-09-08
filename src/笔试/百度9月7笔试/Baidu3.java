import java.util.*;

/**
 * @author hbx
 * @date 2021-09-07 11:43 PM
 */
/*
子序列
对于一个长度为n的仅由小写字母组成的字符串s

s由多少个子序列恰好包含k个字母？

 */
/*
报错，
ac25%

 */
public class Baidu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();
        char[] arr = str.toCharArray();
        List<List<Character>> res = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        backTracking(arr,0,path,res);
//        for (int i = 0; i < res.size() ; i++) {
//            System.out.println(res.get(i));
//        }
        System.out.println(count(res,k));
    }
    public static void backTracking(char[] arr, int startIndex, List<Character> path, List<List<Character>> res){
        if(startIndex>=arr.length) return;
        //同层去重
        Set<Character> set = new HashSet<>();
        for (int i = startIndex; i < arr.length; i++) {
//            if(!path.isEmpty() && set.contains(arr[i])){
//                continue;
//            }
            set.add(arr[i]);
            path.add(arr[i]);
            if(path.size()>1) res.add(new ArrayList<>(path));
            backTracking(arr,i+1,path,res);
            path.remove(path.size()-1);
        }
    }
    public static int count(List<List<Character>> res, int k){
        long sum = 0;
        for (int i = 0; i < res.size(); i++) {
            List<Character> path = res.get(i);
            Set<Character> set = new HashSet<>();
            set.addAll(path);
            if(set.size()==k){
                sum = (sum + 1)%1000000007;
            }
        }
        return (int)(sum%1000000007);
    }
}

