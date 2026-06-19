// LeetCode 787 - Cheapest Flights Within K Stops (Bellman Ford)

class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        int[] dist =
                new int[n];

        Arrays.fill(
                dist,
                Integer.MAX_VALUE
        );

        dist[src] = 0;

        for(int i=0;i<=k;i++){

            int[] temp =
                    dist.clone();

            for(int[] e : flights){

                int u=e[0];
                int v=e[1];
                int w=e[2];

                if(dist[u]
                   ==
                   Integer.MAX_VALUE)
                    continue;

                temp[v]
                        =
                        Math.min(
                                temp[v],
                                dist[u]+w
                        );
            }

            dist = temp;
        }

        return dist[dst]
                ==
                Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}
