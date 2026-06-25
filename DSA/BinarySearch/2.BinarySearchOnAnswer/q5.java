// LeetCode 1283 - Find the Smallest Divisor Given a Threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 0;

        for (int n : nums) r = Math.max(r, n);

        int ans = r;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (canDivide(nums, threshold, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    private boolean canDivide(int[] nums, int threshold, int div) {
        long sum = 0;

        for (int n : nums) {
            sum += (n + div - 1) / div;
        }

        return sum <= threshold;
    }
}