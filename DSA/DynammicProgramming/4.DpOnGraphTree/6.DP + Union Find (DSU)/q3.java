// LeetCode 947 - Most Stones Removed with Same Row or Column

class Solution {

    int[] parent;

    public int removeStones(int[][] stones) {

        int n = stones.length;

        parent = new int[n];

        for(int i=0;i<n;i++)
            parent[i]=i;

        int components = n;

        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){

                if(stones[i][0]
                   ==
                   stones[j][0]
                   ||
                   stones[i][1]
                   ==
                   stones[j][1]){

                    if(union(i,j))
                        components--;
                }
            }
        }

        return n-components;
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
