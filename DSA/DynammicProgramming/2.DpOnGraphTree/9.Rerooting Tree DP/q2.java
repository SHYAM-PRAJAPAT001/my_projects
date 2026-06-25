// LeetCode 310 - Minimum Height Trees

class Solution {

    public List<Integer> findMinHeightTrees(
            int n,
            int[][] edges) {

        if(n==1)
            return Arrays.asList(0);

        List<Integer>[] graph =
                new ArrayList[n];

        int[] degree =
                new int[n];

        for(int i=0;i<n;i++)
            graph[i] =
                    new ArrayList<>();

        for(int[] e : edges){

            graph[e[0]].add(e[1]);

            graph[e[1]].add(e[0]);

            degree[e[0]]++;

            degree[e[1]]++;
        }

        Queue<Integer> q =
                new LinkedList<>();

        for(int i=0;i<n;i++){

            if(degree[i]==1)
                q.offer(i);
        }

        int remain=n;

        while(remain>2){

            int size=q.size();

            remain-=size;

            while(size-->0){

                int leaf=q.poll();

                for(int nxt:
                        graph[leaf]){

                    degree[nxt]--;

                    if(degree[nxt]==1)
                        q.offer(nxt);
                }
            }
        }

        return new ArrayList<>(q);
    }
}
