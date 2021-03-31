# 剑指offer 22 链表中倒数第7个节点
![](%E5%89%91%E6%8C%87offer%2022%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC7%E4%B8%AA%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-12%2019.31.00.png)
返回倒数第7个节点，其实就是找到正数第n-k个节点

## 解法1 遍历
先遍历链表得出链表长度，再返回第n-k个节点
时间复杂度：O(n)
空间复杂度：O(1)
```
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        int n = 0;
        while(node.next!=null){
            n++;
            node = node.next;
        }
        node = head;
        for (int i = 0; i < n-k+1; i++) {
            node = node.next;
        }
        return node;
    }
}
```

## 解法2 双指针（可以不用统计链表长度）

![](%E5%89%91%E6%8C%87offer%2022%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC7%E4%B8%AA%E8%8A%82%E7%82%B9/148607B7-1C15-4074-9080-B9DF60A23761.png)
![](%E5%89%91%E6%8C%87offer%2022%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC7%E4%B8%AA%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-12%2019.54.06.png)
时间复杂度：O(N)
空间复杂度：O(1)，双指针 former , latter 使用常数大小的额外空间。
```
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
```









