package LinkedList.offer.offer22;
//public class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x) {val=x;}
//}

//class Cqueue {
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode node = head;
//        int n = 0;
//        while(node.next!=null){
//            n++;
//            node = node.next;
//        }
//        node = head;
//        for (int i = 0; i <= n-k; i++) {
//            node = node.next;
//        }
//        return node;
//    }
//}
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            //former先走k步
            //但要考虑k大于链表长度的情况（越界问题）
            if(former==null) return null;
            former = former.next;
        }
        while(former!=null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}