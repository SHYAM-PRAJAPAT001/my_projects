// LeetCode 1434 - Number of Ways to Wear Different Hats to Each Other

class Solution {

    int MOD = 1000000007;

    Integer[][] dp;

    List<Integer>[] hats =
            new ArrayList[41];

    int allMask;

    public int numberWays(
            List<List<Integer>> hatsList) {

        int n =
                hatsList.size();

        allMask =
                (1<<n)-1;

        for(int i=0;i<=40;i++)
            hats[i] =
                    new ArrayList<>();

        for(int person=0;
            person<n;
            person++){

            for(int hat :
                    hatsList.get(person)){

                hats[hat]
                        .add(person);
            }
        }

        dp =
                new Integer[41]
                        [1<<n];

        return dfs(1,0);
    }

    private int dfs(
            int hat,
            int mask){

        if(mask==allMask)
            return 1;

        if(hat>40)
            return 0;

        if(dp[hat][mask]
           !=
           null)
            return dp[hat][mask];

        long ans =
                dfs(
                        hat+1,
                        mask
                );

        for(int person :
                hats[hat]){

            if(
                    (mask&(1<<person))
                            ==0
            ){

                ans +=
                        dfs(
                                hat+1,
                                mask|(1<<person)
                        );

                ans %= MOD;
            }
        }

        return dp[hat][mask]
                =
                (int)ans;
    }
}
