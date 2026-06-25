// LeetCode 875 - Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;

        for (int p : piles) r = Math.max(r, p);

        int ans = r;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (canEat(piles, h, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    private boolean canEat(int[] piles, int h, int k) {
        long hours = 0;

        for (int p : piles) {
            hours += (p + k - 1) / k;
        }

        return hours <= h;
    }
}