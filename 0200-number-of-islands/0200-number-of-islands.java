class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int island = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    traverse(i,j,visited,grid,m,n);
                    island++;
                }
            }
        }
        return island;
    }
    private static void traverse(int row, int col, boolean[][] visited, char[][] grid,int m,int n){
        Deque<int[]> stk = new ArrayDeque<>(); // it will store row & col
        stk.push(new int[]{row,col});
        visited[row][col] = true;
        int[][] directions = {
            {-1, 0},  // Up
            {1, 0},   // Down
            {0, -1},  // Left
            {0, 1}    // Right
        };
        while(!stk.isEmpty()){
            
            int[] node = stk.pop();
            int r = node[0];
            int c = node[1];

            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    stk.push(new int[]{nr,nc});
                }
            }
            
        }
    }
}