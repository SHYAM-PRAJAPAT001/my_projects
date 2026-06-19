// LeetCode 851 - Loud and Rich

class Solution {

    List<Integer>[] graph;

    int[] answer;

    int[] quiet;

    public int[] loudAndRich(
            int[][] richer,
            int[] quiet) {

        int n = quiet.length;

        this.quiet = quiet;

        graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] r : richer){

            graph[r[1]]
                    .add(r[0]);
        }

        answer =
                new int[n];

        Arrays.fill(answer,-1);

        for(int i=0;i<n;i++)
            dfs(i);

        return answer;
    }

    private int dfs(int node){

        if(answer[node]!=-1)
            return answer[node];

        answer[node]=node;

        for(int nxt : graph[node]){

            int candidate =
                    dfs(nxt);

            if(
                    quiet[candidate]
                            <
                            quiet[
                                    answer[node]
                                    ]
            ){
                answer[node]
                        =
                        candidate;
            }
        }

        return answer[node];
    }
}
