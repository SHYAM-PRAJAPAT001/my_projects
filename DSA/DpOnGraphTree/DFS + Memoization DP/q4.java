// LeetCode 879 - Profitable Schemes

class Solution {

    int MOD = 1000000007;

    Integer[][][] dp;

    public int profitableSchemes(
            int n,
            int minProfit,
            int[] group,
            int[] profit) {

        dp = new Integer[group.length + 1][n + 1][minProfit + 1];

        return dfs(
                0,
                n,
                0,
                minProfit,
                group,
                profit
        );
    }

    private int dfs(
            int idx,
            int people,
            int curProfit,
            int minProfit,
            int[] group,
            int[] profit) {

        if (idx == group.length)
            return curProfit >= minProfit ? 1 : 0;

        curProfit = Math.min(curProfit, minProfit);

        if (dp[idx][people][curProfit] != null)
            return dp[idx][people][curProfit];

        long ans =
                dfs(
                        idx + 1,
                        people,
                        curProfit,
                        minProfit,
                        group,
                        profit
                );

        if (people >= group[idx]) {

            ans += dfs(
                    idx + 1,
                    people - group[idx],
                    Math.min(
                            minProfit,
                            curProfit + profit[idx]
                    ),
                    minProfit,
                    group,
                    profit
            );
        }

        return dp[idx][people][curProfit] =
                (int)(ans % MOD);
    }
}
