package Array.offer.offer04;

//class Cqueue {
//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
////  因为从左到右递增，从上到下递增
////  所以在循环的时候，如果[i][j] > target,可以直接跳到下一行
//    boolean exists = false;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[matrix.length-1].length; j++) {
//                if(matrix[i][j] == target){
//                    exists = true;
//                    break;
//                }
//                if(matrix[i][j]>target) break;
//            }
//            if(exists==true) break;
//        }
//        return exists;
//    }
//}

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
