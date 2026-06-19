// LeetCode 935 - Knight Dialer

class Solution {

    int MOD = 1000000007;

    int[][] moves = {
        {4,6},
        {6,8},
        {7,9},
        {4,8},
        {0,3,9},
        {},
        {0,1,7},
        {2,6},
        {1,3},
        {2,4}
    };

    Integer[][] dp;

    public int knightDialer(int n) {

        dp = new Integer[10][n + 1];

        long ans = 0;

        for (int i = 0; i < 10; i++) {
            ans = (ans + dfs(i, n - 1)) % MOD;
        }

        return (int) ans;
    }

    private int dfs(int digit, int remain) {

        if (remain == 0)
            return 1;

        if (dp[digit][remain] != null)
            return dp[digit][remain];

        long ans = 0;

        for (int next : moves[digit]) {
            ans = (ans + dfs(next, remain - 1)) % MOD;
        }

        return dp[digit][remain] = (int) ans;
    }
}
