///**
//
///**
// * @author hbx
// * @date 2021-09-05 8:03 PM
// */
//
//import java.util.*;
//
///*
// * public class ListNode {
// *   int val;
// *   ListNode next = null;
// *   public ListNode(int val) {
// *     this.val = val;
// *   }
// * }
// */
///*
//ac 100%
// */
//public class Tencent1 {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param a ListNode类一维数组 指向这些数链的开头
//     * @return ListNode类
//     */
//    public ListNode solve (ListNode[] a) {
//        ListNode res = new ListNode(0);
//        ListNode head = new ListNode(0);
//        head.next = res;
//        while(true){
//            int flag = 0;
//            for (int i = 0; i < a.length; i++) {
//                if(a[i]!=null){
//                    res.next = a[i];
//                    a[i] = a[i].next;
//                    res = res.next;
//                    flag = 1;
//                }
//            }
//            if(flag==0) break;
//        }
//        return head.next.next;
//    }
//}
//*/