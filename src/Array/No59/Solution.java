package Array.No59;

class Solution {
    public int[][] generateMatrix(int n) {
        int startx=0,starty=0; //定义每循环一个圈的起始位置
        int[][] array = new int[n][n];
        int loop = n/2; //当n为奇数，比如n为3，那么只需要循环一圈，矩阵中间的值需要单独处理
        int count = 1; //用来给数组赋值
        int offset = 1; //每一圈循环，需要控制遍历的边的长度
        int i,j;
        //如果n=1，loop=0，直接没有循环
        while(loop>0){
            i = startx;
            j = starty;
            //模拟填充上行从左到右，左闭右开
            for (j = starty; j < starty+n-offset; j++) {
                array[startx][j] = count++;
            }
            //模拟填充右列从上到下，左闭右开
            for (i = startx; i < startx+n-offset; i++) {
                //j正好++后，就到了左闭右开的下一列
                array[i][j] = count++;
            }
            //模拟填充下列从下到上，左闭右开
            for(;j>starty;j--){
                //i正好++后，就到了左闭右开的下一行
                array[i][j] = count++;
            }
            for(;i>startx;i--){
                array[i][j] = count++;
            }

            offset+=2; //注意，offset控制每一圈遍历的长度，应该-2，因为x和y会+1
            startx++;
            starty++;
            loop--;
        }
        //如果n是奇数，需要单独填充中间位置。如果n为1，也可以填充
        if(n%2==1){
            //如果是基数，中间位置单独填充
            array[n/2][n/2]=count;
        }
        return array;
    }
}