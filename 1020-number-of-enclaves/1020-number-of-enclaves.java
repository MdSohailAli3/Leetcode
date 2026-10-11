class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //traverse only boundaries where num==1
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && (i==0 || j==0 || i==m-1 || j==n-1)){
                    dfs(grid, i, j, m, n);
                }
            }
        }
        //count remaining 1's
        int count = 0;
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int[][] grid, int row, int col, int m, int n){
        if(row<0 || row>=m || col<0 || col>=n) return;

        if(grid[row][col] == 0) return;
        grid[row][col] = 0;
        dfs(grid,row+1,col,m,n);
        dfs(grid,row-1,col,m,n);
        dfs(grid,row,col-1,m,n);
        dfs(grid,row,col+1,m,n);
    }
}