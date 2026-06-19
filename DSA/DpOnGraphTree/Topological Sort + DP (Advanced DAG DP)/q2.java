// LeetCode 2050 - Parallel Courses III

class Solution {

    public int minimumTime(
            int n,
            int[][] relations,
            int[] time) {

        List<Integer>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        int[] indegree =
                new int[n];

        for(int[] e : relations){

            int u=e[0]-1;
            int v=e[1]-1;

            graph[u].add(v);

            indegree[v]++;
        }

        Queue<Integer> q =
                new LinkedList<>();

        int[] dp =
                new int[n];

        for(int i=0;i<n;i++){

            dp[i]=time[i];

            if(indegree[i]==0)
                q.offer(i);
        }

        while(!q.isEmpty()){

            int u=q.poll();

            for(int v : graph[u]){

                dp[v]
                        =
                        Math.max(
                                dp[v],
                                dp[u]+time[v]
                        );

                indegree[v]--;

                if(indegree[v]==0)
                    q.offer(v);
            }
        }

        int ans=0;

        for(int x : dp)
            ans=Math.max(ans,x);

        return ans;
    }
}
