// LeetCode 688 - Knight Probability in Chessboard

class Solution {

    Double[][][] dp;

    int[][] dirs = {
        {2,1},{2,-1},
        {-2,1},{-2,-1},
        {1,2},{1,-2},
        {-1,2},{-1,-2}
    };

    public double knightProbability(
            int n,
            int k,
            int row,
            int column) {

        dp = new Double[n][n][k + 1];

        return dfs(n, k, row, column);
    }

    private double dfs(
            int n,
            int k,
            int r,
            int c) {

        if (r < 0 || c < 0 ||
            r >= n || c >= n)
            return 0.0;

        if (k == 0)
            return 1.0;

        if (dp[r][c][k] != null)
            return dp[r][c][k];

        double ans = 0;

        for (int[] d : dirs) {

            ans += dfs(
                    n,
                    k - 1,
                    r + d[0],
                    c + d[1]
            ) / 8.0;
        }

        return dp[r][c][k] = ans;
    }
}
