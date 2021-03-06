# 冒泡排序 or 选择排序
参考：
[Bubble Sort in Python](https://stackabuse.com/bubble-sort-in-python/)

## 做错原因
直接用了一个for循环，判断连着两位的大小，然后交换，但是最后结果并不是排完序的，因为需要进行比较不仅仅是连着的两位！
改成两个for循环成功了，但我认为效率有点低，可以怎么改进？
![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2021.35.45.png)
而且我写错了，这是选择排序！！！！！！不是冒泡排序

## 优化点
1.代码可以更简洁：
`our_list[i],our_list[j] = our_list[j],our_list[i]`


## 冒泡排序：
这才是冒泡排序，注意j是从0开始的![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2021.57.30.png)
区别:冒泡排序比较的一定是紧紧相邻的两个元素;而选择排序却不是每次比较紧邻的两个元素。
![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2022.01.25.png)
![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2022.01.34.png)
![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2022.01.51.png)
总结可以发现，一共进行了4轮，
第一轮确定了6的位置，因为冒泡一直是相邻的两个进行比较，最大值一定会被冒泡到最右边。所以第二轮其实可以不用比较6了
第二轮确定了5的位置，其实下一轮就不需要确定5的位置了。

## 优化思路：
1. 添加有序标记（flag），当没有元素交换时跳出循环
2. 记录有序/无序的边界，已经有序的原序不再需要被比较，因此每轮需要比较的数列长度会减少

优化1:
![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2022.12.44.png)
相比第一个写法，第一个写法需要遍历i*（i-1)次，这个写法如果list已经排序好，就跳出循环，少了排序好还比较的步骤

优化2:
我们可以做的另一个优化是利用Bubble Sort的工作方式，即在一个特定的迭代中，最大的元素最终会出现在数组的最后。
冒泡中，第一次通过列表时保证位置n是最大的元素，第二次通过时保证位置n-1是第二大的元素，以此类推。
这意味着，每一次连续的迭代，我们可以比之前少看一个元素。更准确地说，在第k次迭代中，只需要看前n-(k-1) = n-k+1个元素。若k从0开始便是每次看到位置n-k，再加上我们只需要看到n-1（因为每次比较i和i后面一个），所以for循环是for i in range(n-k-1):
![](%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%20or%20%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/%E6%88%AA%E5%B1%8F2020-11-16%2022.19.53.png)


