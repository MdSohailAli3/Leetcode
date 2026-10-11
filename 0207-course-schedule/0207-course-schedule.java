class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //if there is a cycle, we cant finish courses
        
        //create adjecentcy list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int len = prerequisites.length;
        for(int i=0; i<len; i++){
            int row = prerequisites[i][0];
            int col = prerequisites[i][1];
            adj.get(row).add(col);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses]; // keep track that the cyclic node should be in curretn path
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,pathVis)) return false;//if cycle found then return false
            }
        }
        return true;


        
    }
    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                if(dfs(i,adj,vis,pathVis)) return true;
            }
            else if(pathVis[i]) return true;// if nod is already vis and its pathvis is also set, means the cyclic node comes in current path ,  so directed cycle is found
        }
        pathVis[node] = false;//if one path finishes nad no cycle found then we need to unset the current node, so that it can contribute to next path
        // ex 
        //path 1= 1->2->3->4->5->6
        // path 2 = 1->2->3->7->5->6
        // but 3 4 7 5 forms a undirected cycle, but we need to find directed cycle
        return false;
    }
}