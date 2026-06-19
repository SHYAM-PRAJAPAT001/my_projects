// LeetCode 924 - Minimize Malware Spread

class Solution {

    int[] parent;
    int[] size;

    public int minMalwareSpread(int[][] graph, int[] initial) {

        int n = graph.length;

        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                if(graph[i][j]==1)
                    union(i,j);
            }
        }

        int[] infected =
                new int[n];

        for(int node : initial){

            infected[
                    find(node)
            ]++;
        }

        Arrays.sort(initial);

        int ans = initial[0];
        int saved = -1;

        for(int node : initial){

            int root = find(node);

            if(infected[root]==1){

                if(size[root] > saved){

                    saved = size[root];
                    ans = node;
                }
            }
        }

        return ans;
    }

    int find(int x){

        if(parent[x]==x)
            return x;

        return parent[x]=find(parent[x]);
    }

    void union(int a,int b){

        int pa=find(a);
        int pb=find(b);

        if(pa==pb)
            return;

        if(size[pa] < size[pb]){

            int t=pa;
            pa=pb;
            pb=t;
        }

        parent[pb]=pa;

        size[pa]+=size[pb];
    }
}
