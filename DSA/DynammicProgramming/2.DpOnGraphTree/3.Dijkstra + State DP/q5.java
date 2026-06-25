// LeetCode 1786 - Number of Restricted Paths From First to Last Node

class Solution {

    long MOD =
            1000000007L;

    List<int[]>[] graph;

    long[] dist;

    Long[] dp;

    public int countRestrictedPaths(
            int n,
            int[][] edges) {

        graph =
                new ArrayList[n+1];

        for(int i=1;i<=n;i++)
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

        dijkstra(n);

        dp =
                new Long[n+1];

        return (int)dfs(1,n);
    }

    private long dfs(
            int node,
            int n){

        if(node==n)
            return 1;

        if(dp[node]!=null)
            return dp[node];

        long ans=0;

        for(int[] nxt
                : graph[node]){

            int v=nxt[0];

            if(dist[v]
               <
               dist[node]){

                ans=
                        (
                                ans+
                                        dfs(v,n)
                        )%MOD;
            }
        }

        return dp[node]=ans;
    }

    private void dijkstra(
            int n){

        dist =
                new long[n+1];

        Arrays.fill(
                dist,
                Long.MAX_VALUE
        );

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(
                        Comparator.comparingLong(
                                a->a[1]
                        )
                );

        dist[n]=0;

        pq.offer(
                new long[]{n,0}
        );

        while(!pq.isEmpty()){

            long[] cur =
                    pq.poll();

            int node =
                    (int)cur[0];

            long d =
                    cur[1];

            if(d>dist[node])
                continue;

            for(int[] nxt
                    : graph[node]){

                int v=nxt[0];

                long nd=
                        d+nxt[1];

                if(nd<dist[v]){

                    dist[v]=nd;

                    pq.offer(
                            new long[]{
                                    v,
                                    nd
                            });
                }
            }
        }
    }
}
