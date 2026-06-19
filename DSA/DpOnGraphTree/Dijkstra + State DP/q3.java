// LeetCode 1976 - Number of Ways to Arrive at Destination

class Solution {

    public int countPaths(
            int n,
            int[][] roads) {

        long MOD =
                1000000007L;

        List<long[]>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] r : roads){

            graph[r[0]]
                    .add(
                            new long[]{
                                    r[1],
                                    r[2]
                            });

            graph[r[1]]
                    .add(
                            new long[]{
                                    r[0],
                                    r[2]
                            });
        }

        long[] dist =
                new long[n];

        Arrays.fill(
                dist,
                Long.MAX_VALUE
        );

        long[] ways =
                new long[n];

        dist[0]=0;

        ways[0]=1;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(
                        Comparator.comparingLong(
                                a->a[1]
                        )
                );

        pq.offer(
                new long[]{0,0}
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

            for(long[] nxt
                    : graph[node]){

                int v =
                        (int)nxt[0];

                long nd =
                        d+nxt[1];

                if(nd<dist[v]){

                    dist[v]=nd;

                    ways[v]=ways[node];

                    pq.offer(
                            new long[]{
                                    v,
                                    nd
                            });
                }
                else if(nd==dist[v]){

                    ways[v]
                            =
                            (
                                    ways[v]
                                            +
                                            ways[node]
                            )%MOD;
                }
            }
        }

        return (int)ways[n-1];
    }
}
