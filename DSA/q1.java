class Solution {

    int[][] dp;

    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        dp = new int[n][m];

        int ans = 0;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                ans = Math.max(
                    ans,
                    dfs(i,j,matrix)
                );
            }
        }

        return ans;
    }

    int dfs(int r,int c,int[][] mat){

        if(dp[r][c] != 0)
            return dp[r][c];

        int best = 1;

        int n = mat.length;
        int m = mat[0].length;

        for(int k=0;k<4;k++){

            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr<0 || nc<0 ||
               nr>=n || nc>=m)
                continue;

            if(mat[nr][nc] > mat[r][c]){

                best = Math.max(
                    best,
                    1 + dfs(nr,nc,mat)
                );
            }
        }

        return dp[r][c] = best;
    }
}
