import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-28 1:38 PM
 */
/*
删除链表中间节点

对给定链表，实现删除链表第K个节点的函数

输入：
n，长度
m，表示k

输出：
在给定函数中返回链表的头指针
 */
/*
ac75%，超时。没搞懂哪里超时了

 */
public class Shein {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        ListNode head = new ListNode(in.nextInt());
        ListNode cur = head;
        for (int i = 1; i < n ; i++) {
            cur.next = new ListNode(in.nextInt());
            cur = cur.next;
        }
        head = deleteNode(head,n,k);
        for (int i = 0; i < n-1; i++) {
            System.out.print(head.getVal());
            if(i<n-2){
                System.out.print(' ');
            }
            head = head.next;
        }
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
        public int getVal() {
            return val;
        }
    }
    public static ListNode deleteNode(ListNode head, int n, int k){
        int c = 0;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            if(c==k-2){
                //此时位置在删除节点的前一个节点
                // cur nodeK nodeK.next
                cur.next = cur.next.next;
                return head;
            }else{
                c++;
                cur = cur.next;
            }
        }
        return head;
    }
}
