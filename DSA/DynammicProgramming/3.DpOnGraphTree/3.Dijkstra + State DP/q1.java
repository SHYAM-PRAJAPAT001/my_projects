// LeetCode 787 - Cheapest Flights Within K Stops

class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        List<int[]>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] f : flights){

            graph[f[0]]
                    .add(
                            new int[]{
                                    f[1],
                                    f[2]
                            }
                    );
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a,b)->a[0]-b[0]
                );

        pq.offer(
                new int[]{
                        0,
                        src,
                        k+1
                }
        );

        while(!pq.isEmpty()){

            int[] cur =
                    pq.poll();

            int cost =
                    cur[0];

            int node =
                    cur[1];

            int stops =
                    cur[2];

            if(node==dst)
                return cost;

            if(stops>0){

                for(int[] nxt
                        : graph[node]){

                    pq.offer(
                            new int[]{
                                    cost+nxt[1],
                                    nxt[0],
                                    stops-1
                            }
                    );
                }
            }
        }

        return -1;
    }
}
