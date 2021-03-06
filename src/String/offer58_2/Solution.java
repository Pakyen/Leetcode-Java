package String.offer58_2;

//class Cqueue {
//    public String reverseLeftWords(String s, int n) {
//        if(n==0 || n==s.length()) return s;
//        String tail = s.substring(0,n);
//        return s.substring(n,s.length()).concat(tail);
//    }
//}

class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n+s.length(); i++) {
            res.append(s.charAt(i%s.length()));
        }
        return res.toString();
    }
}