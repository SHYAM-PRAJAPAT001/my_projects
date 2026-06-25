// LeetCode 2246 - Longest Path With Different Adjacent Characters

class Solution {

    int answer = 1;

    List<Integer>[] graph;

    String s;

    public int longestPath(
            int[] parent,
            String s) {

        int n =
                parent.length;

        this.s = s;

        graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int i=1;i<n;i++){

            graph[parent[i]]
                    .add(i);
        }

        dfs(0);

        return answer;
    }

    private int dfs(int node){

        int best1 = 0;

        int best2 = 0;

        for(int child :
                graph[node]){

            int len =
                    dfs(child);

            if(
                    s.charAt(node)
                    ==
                    s.charAt(child)
            )
                continue;

            if(len > best1){

                best2 = best1;

                best1 = len;
            }
            else if(len > best2){

                best2 = len;
            }
        }

        answer =
                Math.max(
                        answer,
                        best1
                        +
                        best2
                        +
                        1
                );

        return best1 + 1;
    }
}
