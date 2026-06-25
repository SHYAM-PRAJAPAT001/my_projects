// LeetCode 691 - Stickers to Spell Word

class Solution {

    Map<Integer,Integer> memo =
            new HashMap<>();

    public int minStickers(
            String[] stickers,
            String target) {

        int n =
                target.length();

        return dfs(
                0,
                stickers,
                target,
                n
        );
    }

    private int dfs(
            int mask,
            String[] stickers,
            String target,
            int n){

        if(mask==
           (1<<n)-1)
            return 0;

        if(memo.containsKey(mask))
            return memo.get(mask);

        int ans=
                Integer.MAX_VALUE;

        for(String sticker:
                stickers){

            int nextMask=
                    mask;

            int[] freq=
                    new int[26];

            for(char c:
                    sticker.toCharArray())
                freq[c-'a']++;

            for(int i=0;i<n;i++){

                if(
                        (nextMask&
                         (1<<i))
                                !=0
                )
                    continue;

                char ch=
                        target.charAt(i);

                if(freq[ch-'a']>0){

                    freq[ch-'a']--;

                    nextMask|=
                            (1<<i);
                }
            }

            if(nextMask!=mask){

                int sub=
                        dfs(
                                nextMask,
                                stickers,
                                target,
                                n
                        );

                if(sub!=
                   Integer.MAX_VALUE){

                    ans=
                            Math.min(
                                    ans,
                                    1+sub
                            );
                }
            }
        }

        memo.put(mask,ans);

        return ans;
    }
}
