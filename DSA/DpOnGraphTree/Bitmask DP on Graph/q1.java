// LeetCode 847 - Shortest Path Visiting All Nodes

class Solution {

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        int finalMask = (1 << n) - 1;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis =
                new boolean[n][1 << n];

        for(int i = 0; i < n; i++){

            int mask = 1 << i;

            q.offer(new int[]{i, mask});

            vis[i][mask] = true;
        }

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                int[] cur = q.poll();

                int node = cur[0];
                int mask = cur[1];

                if(mask == finalMask)
                    return steps;

                for(int nxt : graph[node]){

                    int newMask =
                            mask | (1 << nxt);

                    if(!vis[nxt][newMask]){

                        vis[nxt][newMask] = true;

                        q.offer(
                                new int[]{
                                        nxt,
                                        newMask
                                }
                        );
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
