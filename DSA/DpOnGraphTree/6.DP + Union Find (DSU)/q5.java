// LeetCode 1579 - Remove Max Number of Edges to Keep Graph Fully Traversable

class Solution {

    class DSU{

        int[] parent;

        DSU(int n){

            parent =
                    new int[n+1];

            for(int i=1;i<=n;i++)
                parent[i]=i;
        }

        int find(int x){

            if(parent[x]==x)
                return x;

            return parent[x]
                    =
                    find(parent[x]);
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

    public int maxNumEdgesToRemove(
            int n,
            int[][] edges) {

        DSU alice =
                new DSU(n);

        DSU bob =
                new DSU(n);

        int used = 0;

        for(int[] e : edges){

            if(e[0]==3){

                boolean a =
                        alice.union(
                                e[1],
                                e[2]
                        );

                boolean b =
                        bob.union(
                                e[1],
                                e[2]
                        );

                if(a|b)
                    used++;
            }
        }

        for(int[] e : edges){

            if(e[0]==1){

                if(alice.union(
                        e[1],
                        e[2]))
                    used++;
            }
            else if(e[0]==2){

                if(bob.union(
                        e[1],
                        e[2]))
                    used++;
            }
        }

        int rootA =
                alice.find(1);

        int rootB =
                bob.find(1);

        for(int i=2;i<=n;i++){

            if(alice.find(i)!=rootA)
                return -1;

            if(bob.find(i)!=rootB)
                return -1;
        }

        return edges.length-used;
    }
}
