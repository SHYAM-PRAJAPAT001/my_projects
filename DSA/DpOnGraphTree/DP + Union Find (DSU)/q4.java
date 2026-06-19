// LeetCode 1319 - Number of Operations to Make Network Connected

class Solution {

    int[] parent;

    public int makeConnected(
            int n,
            int[][] connections) {

        if(connections.length < n-1)
            return -1;

        parent = new int[n];

        for(int i=0;i<n;i++)
            parent[i]=i;

        int components = n;

        for(int[] e : connections){

            if(union(e[0],e[1]))
                components--;
        }

        return components-1;
    }

    int find(int x){

        if(parent[x]==x)
            return x;

        return parent[x]=find(parent[x]);
    }

    boolean union(int a,int b){

        int pa=find(a);
        int pb=find(b);

        if(pa==pb)
            return false;

        parent[pb]=pa;

        return true;
    }
}
