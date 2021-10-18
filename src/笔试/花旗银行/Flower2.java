/**
 * @author hbx
 * @date 2021-10-15 7:57 PM
 */
/*
    合并有序数组 nums1, nums2（升序）
    长度m n
    合并成一个升序数组

    最后排好序的数组不应该被函数返回，应该存在nums1中.（nums1长度为m+n）

    时间要求：O(m+n)

 */
public class Flower2 {
    public static void main(String[] args) {
        return;
    }
    public String merge (int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] res = new int[n+m];
        while(i<m && j<n){
            if(nums2[j]<=nums1[i]){
                res[k++] = nums2[j++];
            }else{
                res[k++] = nums1[i++];
            }
        }

        while(i<m){
            res[k++] = nums1[i++];
        }
        while(j<n){
            res[k++] = nums2[j++];
        }
//        for (int l = 0; l < n+m; l++) {
//            System.out.print(res[l]);
//            System.out.print(" ");
//        }
        String str = "";
        for (int l = 0; l < n+m; l++) {
            str+= String.valueOf(res[l]);
        }
        return str;
    }
}

