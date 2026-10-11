class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        int len = edges.length;
        for(int i=0; i<len; i++){
            ls.get(edges[i][0]).add(edges[i][1]);
            ls.get(edges[i][1]).add(edges[i][0]);
        }
        // now bfs
        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        boolean[] visited = new boolean[n];
        while(!que.isEmpty()){
            int val = que.poll();
            if(!visited[val]){
                int lenList = ls.get(val).size();
                for(int i=0; i<lenList; i++){
                    que.offer(ls.get(val).get(i));
                    visited[val] = true;
                }
            }
        }
        return visited[destination];
    }
}