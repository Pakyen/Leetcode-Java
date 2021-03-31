# 腾讯高频4：合并两个有序链表（Leetcode21）

[力扣](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

## 题目描述
将两个升序链表合并为一个新的 **升序** 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的

## 解题思路
	* 使用递归实现
	* 终止条件：两条链表分别名为l1和l2，当l1为空或l2位空时结束
	* 返回值，每一层调用都返回排序好的链表头
	* 每层递归：如果l1更小，则将l1.next与排序好的链表头相连；l2同理
	* 时间复杂度（O(m+n)）

![](%E8%85%BE%E8%AE%AF%E9%AB%98%E9%A2%914%EF%BC%9A%E5%90%88%E5%B9%B6%E4%B8%A4%E4%B8%AA%E6%9C%89%E5%BA%8F%E9%93%BE%E8%A1%A8%EF%BC%88Leetcode21%EF%BC%89/75FF5797-A2F4-4EFE-A608-49BEBA5D9D4A.png)

## 代码
```
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
```