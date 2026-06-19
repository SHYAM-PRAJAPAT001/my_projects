// LeetCode 1125 - Smallest Sufficient Team

class Solution {

    public int[] smallestSufficientTeam(
            String[] req_skills,
            List<List<String>> people) {

        int m =
                req_skills.length;

        Map<String,Integer> map =
                new HashMap<>();

        for(int i=0;i<m;i++)
            map.put(
                    req_skills[i],
                    i
            );

        int n =
                people.size();

        int[] skillMask =
                new int[n];

        for(int i=0;i<n;i++){

            int mask = 0;

            for(String s :
                    people.get(i)){

                if(map.containsKey(s))
                    mask |=
                            1<<map.get(s);
            }

            skillMask[i]=mask;
        }

        int target =
                (1<<m)-1;

        List<Integer>[] dp =
                new ArrayList[1<<m];

        dp[0] =
                new ArrayList<>();

        for(int i=0;i<n;i++){

            List<Integer>[] cur =
                    dp.clone();

            for(int mask=0;
                mask<=target;
                mask++){

                if(cur[mask]==null)
                    continue;

                int next =
                        mask
                                |
                                skillMask[i];

                if(
                        dp[next]==null
                                ||
                                dp[next].size()
                                >
                                cur[mask].size()+1
                ){

                    dp[next] =
                            new ArrayList<>(
                                    cur[mask]
                            );

                    dp[next].add(i);
                }
            }
        }

        return dp[target]
                .stream()
                .mapToInt(i->i)
                .toArray();
    }
}
