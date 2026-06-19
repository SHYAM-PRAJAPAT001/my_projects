// LeetCode 1857 - Largest Color Value in a Directed Graph

class Solution {

    public int largestPathValue(
            String colors,
            int[][] edges) {

        int n = colors.length();

        List<Integer>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        int[] indegree =
                new int[n];

        for(int[] e : edges){

            graph[e[0]].add(e[1]);

            indegree[e[1]]++;
        }

        int[][] dp =
                new int[n][26];

        Queue<Integer> q =
                new LinkedList<>();

        for(int i=0;i<n;i++){

            if(indegree[i]==0)
                q.offer(i);
        }

        int visited = 0;
        int ans = 0;

        while(!q.isEmpty()){

            int u = q.poll();

            visited++;

            int color =
                    colors.charAt(u)-'a';

            dp[u][color]++;

            ans =
                    Math.max(
                            ans,
                            dp[u][color]
                    );

            for(int v : graph[u]){

                for(int c=0;c<26;c++){

                    dp[v][c]
                            =
                            Math.max(
                                    dp[v][c],
                                    dp[u][c]
                            );
                }

                indegree[v]--;

                if(indegree[v]==0)
                    q.offer(v);
            }
        }

        return visited==n
                ? ans
                : -1;
    }
}
