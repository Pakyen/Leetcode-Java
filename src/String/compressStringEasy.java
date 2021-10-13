public class compressStringEasy {
    public static void main(String[] args) {
        return;
    }
    public String compressString(String S) {
        if (S.length()==0) return S;
        StringBuilder res = new StringBuilder();
        int i=0;
        char cur = S.charAt(0);
        while(i<S.length()){
            int count = 1;
            while(i<S.length()-1 && S.charAt(i)==S.charAt(i+1)){
                count++;
                i++;
            }
            res.append(cur);
            res.append(count);
            i++;
            if(i<S.length()) cur = S.charAt(i);
        }
        if(res.length()>=S.length()) return S;
        return  res.toString();
    }
}