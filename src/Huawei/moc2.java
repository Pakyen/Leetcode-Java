/*
输入一个字符串，去除重复的元素，仅保留第一个元素，且保证去除重复元素后顺序不变
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Set<Character> tmp = new LinkedHashSet<>();
//        Character[] res = new Character[input.length()];
        String res = new String();
        for (int i = 0; i < input.length(); i++) {
            if(tmp.add(input.charAt(i))){
                res += input.charAt(i);
            }
        }
        System.out.println(res);
    }
}