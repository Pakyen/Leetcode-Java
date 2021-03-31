# 剑指offer04 二维数组中的查找

![](%E5%89%91%E6%8C%87offer04%20%E4%BA%8C%E7%BB%B4%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E6%9F%A5%E6%89%BE/%E6%88%AA%E5%B1%8F2021-02-09%2015.52.54.png)
### 我的解法：
```
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//  因为从左到右递增，从上到下递增
//  所以在循环的时候，如果[i][j] > target,可以直接跳到下一行
    boolean exists = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[matrix.length-1].length; j++) {
                if(matrix[i][j] == target){
                    exists = true;
                    break;
                }
                if(matrix[i][j]>target) break;
            }
            if(exists==true) break;
        }
        return exists;
    }
}

```
时间复杂度，最多运行n*m次，时间复杂度还是O(nm)

### 官方解法：**线性查找**

	* 要注意数组为空的情况，应该返回false

	* 右上角开始查找最好，右上角的数是最中心的数，时间复杂度直接减少一半

由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，可以排除数组中的部分元素。

从二维数组的**右上角开始查找**。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则**移到左边一列**。如果当前元素小于目标值，则**移到下边一行**。

可以证明这种方法不会错过目标值。如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。

```
class Solution{
    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row=0, column=columns -1; //从右上角开始
        //不需要for循环，用while直到行或列跳出边界即可
        while(row<rows && column >=0){
            int num = matrix[row][column];
            if(num==target) return true;
            else if (num > target) column--; // 比target大，就往左一列
            else row++;
        }
        return false;
    }
}
```

::时间复杂度::：O(n+m)，访问到的下标的行最多增加 n 次，列最多减少 m 次，因此循环体最多执行 n + m 次
::空间复杂度::：O(1)