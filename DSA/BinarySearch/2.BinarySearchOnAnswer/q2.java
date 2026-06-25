// LeetCode 1011 - Capacity To Ship Packages Within D Days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        int ans = r;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (canShip(weights, days, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int d = 1, sum = 0;

        for (int w : weights) {
            if (sum + w > cap) {
                d++;
                sum = 0;
            }
            sum += w;
        }

        return d <= days;
    }
}