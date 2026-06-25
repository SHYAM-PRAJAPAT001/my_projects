// LeetCode 576 - Out of Boundary Paths

class Solution {

    int MOD =
            1000000007;

    Integer[][][] memo;

    int m,n;

    int[] dr =
            {-1,1,0,0};

    int[] dc =
            {0,0,-1,1};

    public int findPaths(
            int m,
            int n,
            int maxMove,
            int startRow,
            int startColumn) {

        this.m=m;
        this.n=n;

        memo =
                new Integer
                        [m]
                        [n]
                        [maxMove+1];

        return dfs(
                startRow,
                startColumn,
                maxMove
        );
    }

    int dfs(
            int r,
            int c,
            int moves){

        if(r<0||c<0||
           r>=m||c>=n)
            return 1;

        if(moves==0)
            return 0;

        if(memo[r][c][moves]
           !=
           null)
            return memo[r][c][moves];

        long ans=0;

        for(int k=0;k<4;k++){

            ans+=dfs(
                    r+dr[k],
                    c+dc[k],
                    moves-1
            );

            ans%=MOD;
        }

        return memo[r][c][moves]
                =
                (int)ans;
    }
}
