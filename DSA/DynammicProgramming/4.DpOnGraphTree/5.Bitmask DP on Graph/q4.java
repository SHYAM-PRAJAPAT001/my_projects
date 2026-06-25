// LeetCode 1066 - Campus Bikes II

class Solution {

    int[][] dp;

    int[][] workers;
    int[][] bikes;

    public int assignBikes(
            int[][] workers,
            int[][] bikes) {

        this.workers =
                workers;

        this.bikes =
                bikes;

        dp =
                new int[
                        workers.length
                                +1
                        ][
                        1<<bikes.length
                        ];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return dfs(0,0);
    }

    private int dfs(
            int worker,
            int mask){

        if(worker
           ==
           workers.length)
            return 0;

        if(dp[worker][mask]
           !=
           -1)
            return dp[worker][mask];

        int ans =
                Integer.MAX_VALUE;

        for(int bike=0;
            bike<bikes.length;
            bike++){

            if(
                    (mask&(1<<bike))
                            !=0
            )
                continue;

            int dist =
                    Math.abs(
                            workers[worker][0]
                                    -
                                    bikes[bike][0]
                    )
                            +
                            Math.abs(
                                    workers[worker][1]
                                            -
                                            bikes[bike][1]
                            );

            ans =
                    Math.min(
                            ans,
                            dist
                                    +
                                    dfs(
                                    worker+1,
                                    mask|(1<<bike)
                            )
                    );
        }

        return dp[worker][mask]
                =
                ans;
    }
}
