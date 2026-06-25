// LeetCode 931 - Minimum Falling Path Sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int up = dp[i-1][j];

                int leftDiag = (j > 0)
                    ? dp[i-1][j-1]
                    : Integer.MAX_VALUE;

                int rightDiag = (j < n-1)
                    ? dp[i-1][j+1]
                    : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] +
                    Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}