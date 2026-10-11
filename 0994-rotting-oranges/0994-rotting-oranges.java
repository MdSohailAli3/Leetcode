class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> q = new LinkedList<>();
        //count total fresh and inserting rotten into que
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){    
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int[][] direction = {
            {1,0},//down
            {-1,0},//up
            {0,1},//right
            {0,-1}//left
        };
        while(fresh>0 && !q.isEmpty()){
            int level = q.size();// we need to process them level by level so that we can have record of how many should be processd per minute

            for(int i=0; i<level; i++){
                int[] node  = q.poll();
                int row = node[0];
                int col = node[1];
                for(int[] d: direction){
                    int nrow = row + d[0];
                    int ncol = col + d[1];
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        fresh--;
                        grid[nrow][ncol] = 2;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            }
            minutes++;
            
        }
        if(fresh > 0) return -1;
        return minutes;

    }
}