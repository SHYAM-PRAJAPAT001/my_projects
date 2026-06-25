// LeetCode 198 - House Robber

class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return dfs(0, nums, memo);
    }

    private int dfs(int i, int[] nums, Integer[] memo) {
        if (i >= nums.length) return 0;

        if (memo[i] != null) return memo[i];

        int take = nums[i] + dfs(i + 2, nums, memo);
        int notTake = dfs(i + 1, nums, memo);

        return memo[i] = Math.max(take, notTake);
    }
}