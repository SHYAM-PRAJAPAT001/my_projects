// LeetCode 2642 - Design Graph With Shortest Path Calculator

class Graph {

    int[][] dist;

    public Graph(
            int n,
            int[][] edges) {

        dist =
                new int[n][n];

        for(int i=0;i<n;i++){

            Arrays.fill(
                    dist[i],
                    1000000000
            );

            dist[i][i] = 0;
        }

        for(int[] e : edges){

            dist[e[0]][e[1]]
                    =
                    Math.min(
                            dist[e[0]][e[1]],
                            e[2]
                    );
        }

        floyd(n);
    }

    public void addEdge(
            int[] edge) {

        int u=edge[0];
        int v=edge[1];
        int w=edge[2];

        if(w >= dist[u][v])
            return;

        dist[u][v] = w;

        int n = dist.length;

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                dist[i][j]
                        =
                        Math.min(
                                dist[i][j],
                                dist[i][u]
                                        +
                                        w
                                        +
                                        dist[v][j]
                        );
            }
        }
    }

    public int shortestPath(
            int node1,
            int node2) {

        return dist[node1][node2]
                >= 1000000000
                ? -1
                : dist[node1][node2];
    }

    private void floyd(
            int n){

        for(int k=0;k<n;k++){

            for(int i=0;i<n;i++){

                for(int j=0;j<n;j++){

                    dist[i][j]
                            =
                            Math.min(
                                    dist[i][j],
                                    dist[i][k]
                                            +
                                            dist[k][j]
                            );
                }
            }
        }
    }
}
