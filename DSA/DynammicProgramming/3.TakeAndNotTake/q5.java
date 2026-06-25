// LeetCode 322 - Coin Change

class Solution {

    public int coinChange(int[] coins, int amount) {

        Integer[] memo = new Integer[amount + 1];

        int ans = dfs(amount, coins, memo);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int amount,
                    int[] coins,
                    Integer[] memo) {

        if (amount == 0) return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (memo[amount] != null)
            return memo[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {

            int res =
                dfs(amount - coin, coins, memo);

            if (res != Integer.MAX_VALUE) {
                minCoins =
                    Math.min(minCoins, 1 + res);
            }
        }

        return memo[amount] = minCoins;
    }
}