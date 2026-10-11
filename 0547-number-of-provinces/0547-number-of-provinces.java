class Solution {
    public int findCircleNum(int[][] isConnected) {
        // we are given adjecency matrix,
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        for(int i=0; i<len; i++){
            if(!visited[i]){
                // here dfs will traverse all the connected components, and marked true in visited
                traverse(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
     private static void traverse(int node, boolean[] visited, int[][] matrix){
        //dfs
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(node);
        visited[node] = true;
        while(!stk.isEmpty()){
            int val = stk.pop();
            int len = matrix[val].length;
            for(int i=0; i<len; i++){
                if(matrix[val][i] == 0) continue;// because adj matrix is giveen, we need to skip 0 entries, which shows no connection
                if(!visited[i]){
                    visited[i] = true;
                    stk.push(i);
                }
            }
        }
     }
}