import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-27 7:05 PM
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long k = in.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int l = a.length-1;
        Arrays.sort(a);
        int i = 0;
        int max = a[l];
        while(k>0){
            if(i>=l){
                i=0;
            }
            if(a[i]<max&&i<l){
                a[i]+=1;
                k--;
                continue;
            }
            if(a[i]==max&&i<l){
                i++;
            }if(i==l){
                if(a[i]==max){
                    i=0;
                    a[i]+=1;
                    max=a[i];
                    k--;
                    continue;
                }else{
                    a[i]+=1;
                    k--;
                    continue;
                }
            }

//            }if(a[i]==max&&i==l){
//                if(a[l]<max){
//                    a[l]+=1;
//                    k--;
//                    continue;
//                }
//                i=0;
//                a[i]+=1;
//                max=a[i];
//                k--;
//                continue;
//            }
        }
        Arrays.sort(a);
        System.out.println(a[l]);
    }
}
