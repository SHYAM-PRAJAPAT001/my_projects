// LeetCode 2328 - Number of Increasing Paths in a Grid

class Solution {

    int MOD =
            1000000007;

    int[][] dp;

    int[] dr =
            {-1,1,0,0};

    int[] dc =
            {0,0,-1,1};

    public int countPaths(
            int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        dp =
                new int[n][m];

        long ans = 0;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                ans += dfs(i,j,grid);

                ans %= MOD;
            }
        }

        return (int)ans;
    }

    private int dfs(
            int r,
            int c,
            int[][] grid){

        if(dp[r][c]!=0)
            return dp[r][c];

        long ans = 1;

        for(int k=0;k<4;k++){

            int nr =
                    r+dr[k];

            int nc =
                    c+dc[k];

            if(
                    nr<0
                    ||
                    nc<0
                    ||
                    nr>=grid.length
                    ||
                    nc>=grid[0].length
            )
                continue;

            if(
                    grid[nr][nc]
                    >
                    grid[r][c]
            ){

                ans += dfs(
                        nr,
                        nc,
                        grid
                );

                ans %= MOD;
            }
        }

        return dp[r][c]
                =
                (int)ans;
    }
}
