// LeetCode 69 - Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x, ans = 0;

        while (l <= r) {
            long m = l + (r - l) / 2;

            if (m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return (int) ans;
    }
}