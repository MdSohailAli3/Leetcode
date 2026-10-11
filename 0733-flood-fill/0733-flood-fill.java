class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        dfs(image,sr,sc,oldColor,color);
        return image;
    }
    private static void dfs(int[][] image, int sr,int sc, int old, int color){
        int rl = image.length;
        int cl = image[0].length;
        int[][] dir = {
            {1,0}, // down
            {-1,0}, // up
            {0,1}, // right
            {0,-1}  // left
        };
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!stk.isEmpty()){
            int[] node = stk.pop();
            int r = node[0];
            int c = node[1];
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr<rl && nc>=0 && nc<cl && image[nr][nc] == old){
                    stk.push(new int[]{nr,nc});
                    image[nr][nc] = color;
                }
            }
        }


    }
}