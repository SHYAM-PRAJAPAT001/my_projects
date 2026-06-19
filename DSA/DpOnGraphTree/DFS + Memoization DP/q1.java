// LeetCode 377 - Combination Sum IV

class Solution {

    Integer[] dp;

    public int combinationSum4(int[] nums, int target) {

        dp = new Integer[target + 1];

        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {

        if (target == 0)
            return 1;

        if (target < 0)
            return 0;

        if (dp[target] != null)
            return dp[target];

        int ans = 0;

        for (int num : nums) {
            ans += dfs(nums, target - num);
        }

        return dp[target] = ans;
    }
}