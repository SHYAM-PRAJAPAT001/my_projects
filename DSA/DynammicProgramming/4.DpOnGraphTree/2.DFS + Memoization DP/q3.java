// LeetCode 140 - Word Break II

class Solution {

    Set<String> dict;
    Map<String, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {

        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return dfs(s);
    }

    private List<String> dfs(String s) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> ans = new ArrayList<>();

        if (s.length() == 0) {
            ans.add("");
            return ans;
        }

        for (String word : dict) {

            if (!s.startsWith(word))
                continue;

            List<String> suffixes =
                    dfs(s.substring(word.length()));

            for (String suffix : suffixes) {

                ans.add(
                    word +
                    (suffix.isEmpty() ? "" : " " + suffix)
                );
            }
        }

        memo.put(s, ans);

        return ans;
    }
}
