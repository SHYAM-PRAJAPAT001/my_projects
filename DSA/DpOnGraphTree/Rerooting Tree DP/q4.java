// LeetCode 2581 - Count Number of Possible Root Nodes

class Solution {

    List<Integer>[] graph;

    Set<Long> guessSet =
            new HashSet<>();

    int k;

    int answer = 0;

    public int rootCount(
            int[][] edges,
            int[][] guesses,
            int k) {

        int n =
                edges.length + 1;

        this.k = k;

        graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] e : edges){

            graph[e[0]]
                    .add(e[1]);

            graph[e[1]]
                    .add(e[0]);
        }

        for(int[] g : guesses){

            long key =
                    ((long)g[0]<<32)
                    | g[1];

            guessSet.add(key);
        }

        int correct =
                dfsCount(
                        0,
                        -1
                );

        reroot(
                0,
                -1,
                correct
        );

        return answer;
    }

    private int dfsCount(
            int node,
            int parent){

        int count = 0;

        for(int nxt :
                graph[node]){

            if(nxt==parent)
                continue;

            if(
                    guessSet.contains(
                            ((long)node<<32)
                            | nxt
                    )
            )
                count++;

            count +=
                    dfsCount(
                            nxt,
                            node
                    );
        }

        return count;
    }

    private void reroot(
            int node,
            int parent,
            int correct){

        if(correct>=k)
            answer++;

        for(int nxt :
                graph[node]){

            if(nxt==parent)
                continue;

            int nextCorrect =
                    correct;

            if(
                    guessSet.contains(
                            ((long)node<<32)
                            | nxt
                    )
            )
                nextCorrect--;

            if(
                    guessSet.contains(
                            ((long)nxt<<32)
                            | node
                    )
            )
                nextCorrect++;

            reroot(
                    nxt,
                    node,
                    nextCorrect
            );
        }
    }
}
