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