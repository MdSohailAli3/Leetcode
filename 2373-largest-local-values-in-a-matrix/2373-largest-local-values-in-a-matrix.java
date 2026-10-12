class Solution {
    public int[][] largestLocal(int[][] grid) {
        int row = grid.length;
        int[][] ans = new int[row-2][row-2];
        for(int i=0; i<row-2; i++){
            for(int j=0; j<row-2; j++){
                int rows = i;
                int cols = j;
                int max = -1;
                for(int k=i; k<rows+3; k++){
                    for(int l=j; l<cols+3; l++){
                        max = Math.max(max,grid[k][l]);
                    }
                }
                ans[i][j]= max;
            }
        }
        return ans;
    }

}