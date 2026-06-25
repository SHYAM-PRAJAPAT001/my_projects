// LeetCode 1482 - Minimum Number of Days to Make m Bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Integer.MAX_VALUE, r = 0;

        for (int b : bloomDay) {
            l = Math.min(l, b);
            r = Math.max(r, b);
        }

        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int count = 0, flowers = 0;

        for (int b : bloomDay) {
            if (b <= day) {
                flowers++;
                if (flowers == k) {
                    count++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return count >= m;
    }
}