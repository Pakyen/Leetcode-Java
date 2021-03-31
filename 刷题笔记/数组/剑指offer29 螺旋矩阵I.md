# 剑指offer29 螺旋矩阵I

⚠️不会做，做不出来
![](%E5%89%91%E6%8C%87offer29%20%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5I/%E6%88%AA%E5%B1%8F2021-02-09%2016.36.47.png)
### 方法1:模拟（时间O(mn)，空间O(mn)）
三个注意事项：
	1. 从[0,0]开始模拟，初始方向向右（超出边界/进入访问过位置时转向）
	2. 需要创建一个辅助矩阵visited，代表是否被访问过
	3. 什么时候结束？ 记录路径长度，当路径长度等于元素数量时结束，正好可以for循环total次
	4. 使用二维数组代表方向，这样可以直接row+=[][0], col+=[][1]。代表下一步的行和列是什么
	5. 判断下一位置是否超出边界 or 访问过
	6. 如果5，那么转变方向，重新设置row和col，进入下一循环
	7. 如果没有，重新设置row和col，进入下一循环

```
class Solution{
    public int[] spiralOrder(int[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        //boolean数组默认值为false
        int total = rows*columns;
        int row=0, col=0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        //right, down, left, up
        //比如：
        //向右就row+directions[0][0]，行不变
        //col+directions[0][1]，列+1
        //代表哪个方向
        int directionIndex=0;
        int[] order = new int[total];

        for (int i = 0; i <total ; i++) {
            order[i] = matrix[row][col];
            visited[row][col]=true;
            int nextRow = row+ directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];

            if(nextRow<0 || nextRow>=rows || nextCol<0 || nextCol >=columns || visited[nextRow][nextCol]){
                directionIndex = (directionIndex+1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return order;
    }
}
```
![](%E5%89%91%E6%8C%87offer29%20%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5I/%E6%88%AA%E5%B1%8F2021-02-10%2014.59.33.png)







### 方法2:按层模拟（时间O(mn),空间O(1)）