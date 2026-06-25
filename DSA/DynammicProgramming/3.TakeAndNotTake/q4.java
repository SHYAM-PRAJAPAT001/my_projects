// LeetCode 494 - Target Sum

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();

        return dfs(0, 0, target, nums, memo);
    }

    private int dfs(int i,
                    int currSum,
                    int target,
                    int[] nums,
                    Map<String, Integer> memo) {

        if (i == nums.length) {
            return currSum == target ? 1 : 0;
        }

        String key = i + "," + currSum;

        if (memo.containsKey(key))
            return memo.get(key);

        int add =
            dfs(i + 1, currSum + nums[i],
                target, nums, memo);

        int subtract =
            dfs(i + 1, currSum - nums[i],
                target, nums, memo);

        int ans = add + subtract;

        memo.put(key, ans);

        return ans;
    }
}