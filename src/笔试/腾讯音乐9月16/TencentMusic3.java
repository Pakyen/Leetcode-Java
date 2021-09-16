/**
 * @author hbx
 * @date 2021-09-16 7:31 PM
 */
/*
30分，ac10.53%
 */
public class TencentMusic3 {
    //     * @param n int整型
//     * @param k int整型
//     * @return long长整型
    // k 表示k进制
    // m 表示数字1-m
    // F(m,k) = 数字1-m中1出现的次数
    // F(m,k)>=n的最小m
    /*
    思路：
        对于每一个m,保存F(m,k)出现的次数
        对于m+1，F(m,k) = F(m-1,k) + m用k进制表示1出现了多少次
        所以问题化简为对于一个数来说，k进制下1出现了多少次
        1出现了多少次，又可以等同于，k进制下，要表示数字k，需要多少个k的1次方 + 多少个3的0次方
     */
    public static long minM (int n, int k) {
        long m=1;
        long sum = F(m,k);  //1-m, 1的数量
        if(sum>=n) return (long)m;
        m=2;
        while(true){
            if(sum+F(m,k)>=n){
                break;
            }else{
                sum += F(m,k);
                m++;
            }
        }
        return m-1;
    }
    public static long F(long num, int k){
        // F(num, k) 对于K进制来说，数字num包含了多少个1
        // s, k的s次方，大于等于num

        double ss=0;
        double kk = k;
//        while(ss<num){
//            ss = Math.pow(kk,ss);
//        }
        double ks = Math.pow(kk,ss);
        while(ks<num){
            ks = Math.pow(kk,ss);
            ss+=1;
        }
        long res = 0;
        if(num==1||num==k){
            res=1;
        }
        while(num>k){
            if(Math.pow(kk,ss)>num){
                ss-=1;
                continue;
            }
            if(num==1){
                res+=1;
                break;
            }
            if(num>1&&num<k){
                break;
            }
            if((int)ss==1){
                res+=1;
            }
            num = num - (int)Math.pow(kk,ss);
            ss-=1;
        }

        return res;
    }
}
