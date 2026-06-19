// LeetCode 909 - Snakes and Ladders

class Solution {

    public int snakesAndLadders(
            int[][] board) {

        int n = board.length;

        Queue<Integer> q =
                new LinkedList<>();

        boolean[] vis =
                new boolean[n*n+1];

        q.offer(1);

        vis[1] = true;

        int moves = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                int cur = q.poll();

                if(cur == n*n)
                    return moves;

                for(int d=1;d<=6;d++){

                    int next = cur+d;

                    if(next > n*n)
                        continue;

                    int[] pos =
                            getPos(next,n);

                    int r = pos[0];
                    int c = pos[1];

                    if(board[r][c] != -1)
                        next = board[r][c];

                    if(!vis[next]){

                        vis[next]=true;

                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getPos(
            int num,
            int n){

        int r =
                (num-1)/n;

        int c =
                (num-1)%n;

        if(r%2==1)
            c=n-1-c;

        return new int[]{
                n-1-r,
                c
        };
    }
}
