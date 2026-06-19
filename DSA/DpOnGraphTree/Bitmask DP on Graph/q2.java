// LeetCode 1494 - Parallel Courses II

class Solution {

    public int minNumberOfSemesters(
            int n,
            int[][] relations,
            int k) {

        int[] prereq =
                new int[n];

        for(int[] r : relations){

            prereq[r[1]-1]
                    |=
                    (1 << (r[0]-1));
        }

        int N = 1 << n;

        int[] dp =
                new int[N];

        Arrays.fill(
                dp,
                Integer.MAX_VALUE
        );

        dp[0] = 0;

        for(int mask=0; mask<N; mask++){

            int available = 0;

            for(int i=0;i<n;i++){

                if(
                        (mask&(1<<i))==0
                                &&
                                (prereq[i]&mask)
                                        ==
                                        prereq[i]
                ){
                    available |= (1<<i);
                }
            }

            for(
                    int sub = available;
                    sub > 0;
                    sub =
                            (sub-1)&available
            ){

                if(
                        Integer.bitCount(sub)
                                > k
                )
                    continue;

                int next =
                        mask | sub;

                dp[next]
                        =
                        Math.min(
                                dp[next],
                                dp[mask]+1
                        );
            }
        }

        return dp[N-1];
    }
}
