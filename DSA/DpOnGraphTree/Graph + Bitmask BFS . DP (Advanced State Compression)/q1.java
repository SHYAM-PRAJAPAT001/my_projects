// LeetCode 864 - Shortest Path to Get All Keys

class Solution {

    public int shortestPathAllKeys(String[] grid) {

        int n = grid.length;
        int m = grid[0].length();

        Queue<int[]> q =
                new LinkedList<>();

        boolean[][][] vis =
                new boolean[n][m][64];

        int keys = 0;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                char ch =
                        grid[i].charAt(j);

                if(ch=='@'){

                    q.offer(
                            new int[]{
                                    i,j,0
                            }
                    );

                    vis[i][j][0]=true;
                }

                if(ch>='a'&&ch<='f')
                    keys++;
            }
        }

        int target =
                (1<<keys)-1;

        int[][] dir =
                {
                        {1,0},
                        {-1,0},
                        {0,1},
                        {0,-1}
                };

        int steps=0;

        while(!q.isEmpty()){

            int size=q.size();

            while(size-- > 0){

                int[] cur=q.poll();

                int r=cur[0];
                int c=cur[1];
                int mask=cur[2];

                if(mask==target)
                    return steps;

                for(int[] d:dir){

                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<0||nc<0||
                       nr>=n||nc>=m)
                        continue;

                    char ch=
                            grid[nr]
                            .charAt(nc);

                    if(ch=='#')
                        continue;

                    int newMask=mask;

                    if(ch>='a'&&ch<='f')
                        newMask|=
                                1<<(ch-'a');

                    if(ch>='A'&&ch<='F'){

                        if(
                                (mask&
                                 (1<<(ch-'A')))
                                        ==0
                        )
                            continue;
                    }

                    if(!vis[nr][nc][newMask]){

                        vis[nr][nc][newMask]
                                =true;

                        q.offer(
                                new int[]{
                                        nr,
                                        nc,
                                        newMask
                                }
                        );
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
