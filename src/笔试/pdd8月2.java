/**
 * @author hbx
 * @date 2021-08-31 7:29 PM
 */
/*
一类字符串：
一个字符串S，长Len，对于0<=i<=Len
下标index和Len-index-1位置的字符串可以交换位置
如长为4，
则0跟4-0-1=3换
1跟4-1-1=2换


定义字符串A和B的顺序大小关系：
只有当某一个形态的A的字典序 小于 B的所有形态时，才说A小于B

如果某一个形态的B小于所有的A，则B小于A'

否则认为A和B相等。


输入n个字符串，输出排序（字典序从小到大），字典序相等时，先输出先出现的字符串

输入：
2
dcba
abcd
输出：
dcba
abcd

输入：
2
abcde
abcdeaf
输出"
abcdeaf
abcde
 */
public class Main2 {
}
