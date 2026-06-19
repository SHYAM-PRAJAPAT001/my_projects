// LeetCode 2115 - Find All Possible Recipes from Given Supplies

class Solution {

    public List<String> findAllRecipes(
            String[] recipes,
            List<List<String>> ingredients,
            String[] supplies) {

        Map<String,List<String>> graph =
                new HashMap<>();

        Map<String,Integer> indegree =
                new HashMap<>();

        for(int i=0;i<recipes.length;i++){

            indegree.put(
                    recipes[i],
                    ingredients.get(i).size()
            );

            for(String ing :
                    ingredients.get(i)){

                graph
                        .computeIfAbsent(
                                ing,
                                k->new ArrayList<>()
                        )
                        .add(recipes[i]);
            }
        }

        Queue<String> q =
                new LinkedList<>();

        for(String s : supplies)
            q.offer(s);

        List<String> ans =
                new ArrayList<>();

        while(!q.isEmpty()){

            String cur =
                    q.poll();

            for(String nxt :
                    graph.getOrDefault(
                            cur,
                            new ArrayList<>()
                    )){

                indegree.put(
                        nxt,
                        indegree.get(nxt)-1
                );

                if(indegree.get(nxt)==0){

                    ans.add(nxt);

                    q.offer(nxt);
                }
            }
        }

        return ans;
    }
}
