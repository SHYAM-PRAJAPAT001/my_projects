// All Paths From Source to Target (797)

class Solution {

    List<List<Integer>> ans =
            new ArrayList<>();

    public List<List<Integer>>
    allPathsSourceTarget(
            int[][] graph) {

        List<Integer> path =
                new ArrayList<>();

        path.add(0);

        dfs(0,
            graph,
            path);

        return ans;
    }

    private void dfs(
            int node,
            int[][] graph,
            List<Integer> path){

        int target =
                graph.length-1;

        if(node==target){

            ans.add(
                new ArrayList<>(path)
            );

            return;
        }

        for(int next
                : graph[node]){

            path.add(next);

            dfs(next,
                graph,
                path);

            path.remove(
                path.size()-1
            );
        }
    }
}