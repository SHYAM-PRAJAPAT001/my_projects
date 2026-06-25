// LeetCode 410 - Split Array Largest Sum

class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;

        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }

        int ans = r;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (canSplit(nums, k, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1, sum = 0;

        for (int n : nums) {
            if (sum + n > maxSum) {
                count++;
                sum = 0;
            }
            sum += n;
        }

        return count <= k;
    }
}