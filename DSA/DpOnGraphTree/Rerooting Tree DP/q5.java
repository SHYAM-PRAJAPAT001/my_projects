// LeetCode 1617 - Count Subtrees With Max Distance Between Cities

class Solution {

    int[] answer;

    List<Integer>[] graph;

    public int[] countSubgraphsForEachDiameter(
            int n,
            int[][] edges) {

        answer =
                new int[n-1];

        graph =
                new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] e : edges){

            int u=e[0]-1;
            int v=e[1]-1;

            graph[u].add(v);

            graph[v].add(u);
        }

        int total =
                1<<n;

        for(int mask=1;
            mask<total;
            mask++){

            int diameter =
                    getDiameter(
                            mask,
                            n
                    );

            if(diameter>0)
                answer[
                        diameter-1
                        ]++;
        }

        return answer;
    }

    private int getDiameter(
            int mask,
            int n){

        List<Integer> nodes =
                new ArrayList<>();

        for(int i=0;i<n;i++){

            if(
                    (mask&(1<<i))
                            !=0
            )
                nodes.add(i);
        }

        if(nodes.size()<2)
            return 0;

        return 1;
    }
}
