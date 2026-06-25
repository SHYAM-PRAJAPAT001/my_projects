// LeetCode 374 - Guess Number Higher or Lower

public class Solution {
    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (guess(m) == 0) return m;
            else if (guess(m) == -1) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }

    private int guess(int num) {
        return 0; // provided by LeetCode
    }
}