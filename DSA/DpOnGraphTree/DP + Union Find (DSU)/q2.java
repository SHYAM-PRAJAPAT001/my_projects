// LeetCode 928 - Minimize Malware Spread II

class Solution {

    public int minMalwareSpread(
            int[][] graph,
            int[] initial) {

        Arrays.sort(initial);

        int n = graph.length;

        int answer = initial[0];
        int best = -1;

        Set<Integer> infected =
                new HashSet<>();

        for(int x : initial)
            infected.add(x);

        for(int removed : initial){

            int[] parent =
                    new int[n];

            int[] size =
                    new int[n];

            for(int i=0;i<n;i++){

                parent[i]=i;
                size[i]=1;
            }

            for(int i=0;i<n;i++){

                if(i==removed)
                    continue;

                for(int j=i+1;j<n;j++){

                    if(j==removed)
                        continue;

                    if(graph[i][j]==1){

                        int pi=find(i,parent);
                        int pj=find(j,parent);

                        if(pi!=pj){

                            parent[pj]=pi;

                            size[pi]+=size[pj];
                        }
                    }
                }
            }

            boolean[] bad =
                    new boolean[n];

            for(int node : initial){

                if(node==removed)
                    continue;

                bad[
                        find(node,parent)
                ]=true;
            }

            int safe = 0;

            for(int i=0;i<n;i++){

                if(parent[i]==i
                   &&
                   !bad[i]){

                    safe+=size[i];
                }
            }

            if(safe>best){

                best=safe;
                answer=removed;
            }
        }

        return answer;
    }

    int find(int x,int[] p){

        if(p[x]==x)
            return x;

        return p[x]=find(p[x],p);
    }
}
