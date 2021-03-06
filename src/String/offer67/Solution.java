package String.offer67;

class Solution {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length==0) return 0;
        int res = 0;
        int boundary = Integer.MAX_VALUE/10;
        //i表示位数，如果有符号，数字应该从第1位开始看起而不是第0位
        int i=1,sign=1;
        if(c[0]=='-') sign=-1;
        else if(c[0]!='+') i=0;
        for (int j = i; j < c.length; j++) {
            if(c[j]<'0' || c[j]>'9') break;
            if(res>boundary || res==boundary&&c[j]>'7')
                return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10 + (c[j]-'0');
        }
        return sign*res;
    }
}
