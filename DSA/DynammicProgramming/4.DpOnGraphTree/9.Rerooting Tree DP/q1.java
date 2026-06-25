// LeetCode 834 - Sum of Distances in Tree

class Solution {

    List<Integer>[] graph;

    int[] count;

    int[] answer;

    int n;

    public int[] sumOfDistancesInTree(
            int n,
            int[][] edges) {

        this.n = n;

        graph = new ArrayList[n];

        count = new int[n];

        answer = new int[n];

        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int[] e : edges){

            graph[e[0]].add(e[1]);

            graph[e[1]].add(e[0]);
        }

        postOrder(0,-1);

        preOrder(0,-1);

        return answer;
    }

    private void postOrder(
            int node,
            int parent){

        count[node] = 1;

        for(int child :
                graph[node]){

            if(child==parent)
                continue;

            postOrder(
                    child,
                    node
            );

            count[node]
                    +=
                    count[child];

            answer[node]
                    +=
                    answer[child]
                    +
                    count[child];
        }
    }

    private void preOrder(
            int node,
            int parent){

        for(int child :
                graph[node]){

            if(child==parent)
                continue;

            answer[child]
                    =
                    answer[node]
                    -
                    count[child]
                    +
                    (n-count[child]);

            preOrder(
                    child,
                    node
            );
        }
    }
}
