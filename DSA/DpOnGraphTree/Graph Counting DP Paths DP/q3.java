// LeetCode 1575 - Count All Possible Routes

class Solution {

    int MOD =
            1000000007;

    Integer[][] memo;

    int[] locations;

    int finish;

    public int countRoutes(
            int[] locations,
            int start,
            int finish,
            int fuel) {

        this.locations =
                locations;

        this.finish =
                finish;

        memo =
                new Integer[
                        locations.length
                        ][fuel+1];

        return dfs(start,fuel);
    }

    int dfs(
            int city,
            int fuel){

        if(fuel<0)
            return 0;

        if(memo[city][fuel]
           !=
           null)
            return memo[city][fuel];

        long ans =
                city==finish
                        ? 1
                        : 0;

        for(int next=0;
            next<locations.length;
            next++){

            if(next==city)
                continue;

            int cost =
                    Math.abs(
                            locations[next]
                            -
                            locations[city]
                    );

            if(cost<=fuel){

                ans +=
                        dfs(
                                next,
                                fuel-cost
                        );

                ans%=MOD;
            }
        }

        return memo[city][fuel]
                =
                (int)ans;
    }
}
