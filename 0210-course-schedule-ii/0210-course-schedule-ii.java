class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //kahns algo bfs
        //create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int len = prerequisites.length;
        for(int i=0; i<len; i++){
            int row = prerequisites[i][0];
            int col = prerequisites[i][1];
            adj.get(col).add(row);// because here condition is reversed
        }
        //to keep track the number of incoming edges
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        // inserting nodes in q whose indegree is 0, they can be the first in sort order
        Deque<Integer> q  = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }


        int[] ans = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
            ans[idx++] = node;

        }
        //check if ans is valid
        if(idx==numCourses) return ans;
        return new int[]{};


    }
}