// LeetCode 1928 - Minimum Cost to Reach Destination in Time

class Solution {

    public int minCost(
            int maxTime,
            int[][] edges,
            int[] fees) {

        int n = fees.length;

        List<int[]>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] e : edges){

            graph[e[0]]
                    .add(
                            new int[]{
                                    e[1],
                                    e[2]
                            });

            graph[e[1]]
                    .add(
                            new int[]{
                                    e[0],
                                    e[2]
                            });
        }

        int[][] dist =
                new int[n][maxTime+1];

        for(int[] row:dist)
            Arrays.fill(
                    row,
                    Integer.MAX_VALUE
            );

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a,b)->a[0]-b[0]
                );

        pq.offer(
                new int[]{
                        fees[0],
                        0,
                        0
                });

        dist[0][0]=fees[0];

        while(!pq.isEmpty()){

            int[] cur =
                    pq.poll();

            int cost =
                    cur[0];

            int node =
                    cur[1];

            int time =
                    cur[2];

            if(node==n-1)
                return cost;

            for(int[] nxt
                    : graph[node]){

                int v=nxt[0];

                int nt=
                        time+nxt[1];

                int nc=
                        cost+fees[v];

                if(nt<=maxTime
                   &&
                   nc<dist[v][nt]){

                    dist[v][nt]=nc;

                    pq.offer(
                            new int[]{
                                    nc,
                                    v,
                                    nt
                            });
                }
            }
        }

        return -1;
    }
}
