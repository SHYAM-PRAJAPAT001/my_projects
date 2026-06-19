// LeetCode 743 - Network Delay Time

class Solution {

    public int networkDelayTime(
            int[][] times,
            int n,
            int k) {

        List<int[]>[] graph =
                new ArrayList[n + 1];

        for(int i=1;i<=n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] t : times){

            graph[t[0]]
                    .add(
                            new int[]{
                                    t[1],
                                    t[2]
                            });
        }

        int[] dist =
                new int[n + 1];

        Arrays.fill(
                dist,
                Integer.MAX_VALUE
        );

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a,b)->a[1]-b[1]
                );

        dist[k] = 0;

        pq.offer(
                new int[]{k,0}
        );

        while(!pq.isEmpty()){

            int[] cur =
                    pq.poll();

            int node =
                    cur[0];

            int d =
                    cur[1];

            if(d > dist[node])
                continue;

            for(int[] nxt :
                    graph[node]){

                int v =
                        nxt[0];

                int nd =
                        d + nxt[1];

                if(nd < dist[v]){

                    dist[v] = nd;

                    pq.offer(
                            new int[]{
                                    v,
                                    nd
                            });
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++){

            if(dist[i]
               ==
               Integer.MAX_VALUE)
                return -1;

            ans =
                    Math.max(
                            ans,
                            dist[i]
                    );
        }

        return ans;
    }
}
