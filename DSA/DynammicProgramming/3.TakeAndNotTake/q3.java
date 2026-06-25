// LeetCode 416 - Partition Equal Subset Sum

class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return dfs(0, target, nums, memo);
    }

    private boolean dfs(int i, int target,
                        int[] nums,
                        Boolean[][] memo) {

        if (target == 0) return true;

        if (i == nums.length || target < 0)
            return false;

        if (memo[i][target] != null)
            return memo[i][target];

        boolean take =
            dfs(i + 1, target - nums[i], nums, memo);

        boolean notTake =
            dfs(i + 1, target, nums, memo);

        return memo[i][target] = take || notTake;
    }
}