/**
 * @author hbx
 * @date 2021-10-09 4:05 PM
 */
import java.util.*;
public class Oppo {
    public static void main(String[] args){
        int[] a = {1,3,5,7,9};
        int[] b = {2,6,8,10,12};
        int[] res = new int[10];
        res = mergeArray(a,b);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(' ');
        }
    }
    public static int[] mergeArray(int[] a,int[] b ){
        int n1 = a.length;
        int n2 = b.length;
        int[] res = new int[n1+n2];
        int f = 0;
        int i = 0, j =0;
        while(i<n1&&j<n2){
            if(a[i]<a[j]){
                res[f] = a[i];
                f++;
                i++;
            }else{
                res[f] = b[j];
                f++;
                j++;
            }
        }
        if(i<n1-1){
            for (int k = i; k < n1; k++) {
                res[f] = a[k];
                f++;
            }
        }else if(j<n2-1){
            for (int k = j; k < n2; k++) {
                res[f] = b[k];
                f++;
            }
        }
        return res;
    }
}
