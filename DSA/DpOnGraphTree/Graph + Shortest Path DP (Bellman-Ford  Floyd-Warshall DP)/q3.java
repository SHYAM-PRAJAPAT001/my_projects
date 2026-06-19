// LeetCode 1334 - Find the City With the Smallest Number of Neighbors

class Solution {

    public int findTheCity(
            int n,
            int[][] edges,
            int distanceThreshold) {

        int[][] dist =
                new int[n][n];

        for(int i=0;i<n;i++){

            Arrays.fill(
                    dist[i],
                    100000000
            );

            dist[i][i]=0;
        }

        for(int[] e : edges){

            dist[e[0]][e[1]]
                    = e[2];

            dist[e[1]][e[0]]
                    = e[2];
        }

        for(int via=0;
            via<n;
            via++){

            for(int i=0;
                i<n;
                i++){

                for(int j=0;
                    j<n;
                    j++){

                    dist[i][j]
                            =
                            Math.min(
                                    dist[i][j],
                                    dist[i][via]
                                            +
                                            dist[via][j]
                            );
                }
            }
        }

        int city = -1;
        int minCount = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            int count = 0;

            for(int j=0;j<n;j++){

                if(dist[i][j]
                   <=
                   distanceThreshold)
                    count++;
            }

            if(count <= minCount){

                minCount = count;

                city = i;
            }
        }

        return city;
    }
}
