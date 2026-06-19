// LeetCode 124 - Binary Tree Maximum Path Sum

class Solution {

    int answer = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return answer;
    }

    private int dfs(TreeNode node) {

        if(node == null)
            return 0;

        int left =
                Math.max(
                        0,
                        dfs(node.left)
                );

        int right =
                Math.max(
                        0,
                        dfs(node.right)
                );

        answer =
                Math.max(
                        answer,
                        node.val
                                + left
                                + right
                );

        return node.val
                +
                Math.max(left, right);
    }
}
