// Sort Items by Groups Respecting Dependencies (1203)

class Solution {

    public List<Integer> sortItems(
            int n,
            int m,
            int[] group,
            List<List<Integer>> beforeItems) {

        for (int i = 0; i < n; i++) {

            if (group[i] == -1) {

                group[i] = m++;
            }
        }

        List<Integer>[] itemGraph =
                new ArrayList[n];

        List<Integer>[] groupGraph =
                new ArrayList[m];

        for(int i=0;i<n;i++)
            itemGraph[i] = new ArrayList<>();

        for(int i=0;i<m;i++)
            groupGraph[i] = new ArrayList<>();

        int[] itemIndegree =
                new int[n];

        int[] groupIndegree =
                new int[m];

        for(int curr=0;curr<n;curr++){

            for(int prev :
                    beforeItems.get(curr)){

                itemGraph[prev]
                        .add(curr);

                itemIndegree[curr]++;

                if(group[prev]
                        != group[curr]){

                    groupGraph[group[prev]]
                            .add(group[curr]);

                    groupIndegree[
                            group[curr]
                    ]++;
                }
            }
        }

        List<Integer> itemOrder =
                topo(itemGraph,
                        itemIndegree,
                        n);

        if(itemOrder.size()!=n)
            return new ArrayList<>();

        List<Integer> groupOrder =
                topo(groupGraph,
                        groupIndegree,
                        m);

        if(groupOrder.size()!=m)
            return new ArrayList<>();

        Map<Integer,List<Integer>>
                groupItems =
                new HashMap<>();

        for(int item : itemOrder){

            groupItems
                    .computeIfAbsent(
                            group[item],
                            k -> new ArrayList<>()
                    )
                    .add(item);
        }

        List<Integer> ans =
                new ArrayList<>();

        for(int g : groupOrder){

            ans.addAll(
                    groupItems.getOrDefault(
                            g,
                            new ArrayList<>()
                    )
            );
        }

        return ans;
    }

    private List<Integer> topo(
            List<Integer>[] graph,
            int[] indegree,
            int n){

        Queue<Integer> q =
                new LinkedList<>();

        for(int i=0;i<n;i++){

            if(indegree[i]==0)
                q.offer(i);
        }

        List<Integer> order =
                new ArrayList<>();

        while(!q.isEmpty()){

            int u=q.poll();

            order.add(u);

            for(int v : graph[u]){

                indegree[v]--;

                if(indegree[v]==0)
                    q.offer(v);
            }
        }

        return order;
    }
}