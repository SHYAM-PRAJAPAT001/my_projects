// LeetCode 1129 - Shortest Path with Alternating Colors

class Solution {

    public int[] shortestAlternatingPaths(
            int n,
            int[][] redEdges,
            int[][] blueEdges) {

        List<int[]>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] e:redEdges)
            graph[e[0]]
                    .add(
                            new int[]{
                                    e[1],
                                    0
                            });

        for(int[] e:blueEdges)
            graph[e[0]]
                    .add(
                            new int[]{
                                    e[1],
                                    1
                            });

        int[][] dist =
                new int[n][2];

        for(int[] row:dist)
            Arrays.fill(
                    row,
                    Integer.MAX_VALUE
            );

        Queue<int[]> q =
                new LinkedList<>();

        q.offer(
                new int[]{
                        0,
                        0
                });

        q.offer(
                new int[]{
                        0,
                        1
                });

        dist[0][0]=0;
        dist[0][1]=0;

        while(!q.isEmpty()){

            int[] cur =
                    q.poll();

            int node =
                    cur[0];

            int color =
                    cur[1];

            for(int[] nxt :
                    graph[node]){

                int v =
                        nxt[0];

                int nc =
                        nxt[1];

                if(nc==color)
                    continue;

                if(dist[v][nc]
                   >
                   dist[node][color]
                   +1){

                    dist[v][nc]
                            =
                            dist[node][color]
                            +1;

                    q.offer(
                            new int[]{
                                    v,
                                    nc
                            });
                }
            }
        }

        int[] ans =
                new int[n];

        for(int i=0;i<n;i++){

            int d =
                    Math.min(
                            dist[i][0],
                            dist[i][1]
                    );

            ans[i] =
                    d==
                    Integer.MAX_VALUE
                    ? -1
                    : d;
        }

        return ans;
    }
}
