// LeetCode 1339 - Maximum Product of Splitted Binary Tree

class Solution {

    long totalSum = 0;

    long answer = 0;

    public int maxProduct(TreeNode root) {

        totalSum = findSum(root);

        dfs(root);

        return (int)(
                answer
                        %
                        1000000007
        );
    }

    private long findSum(TreeNode node) {

        if(node == null)
            return 0;

        return node.val
                +
                findSum(node.left)
                +
                findSum(node.right);
    }

    private long dfs(TreeNode node) {

        if(node == null)
            return 0;

        long sum =
                node.val
                        +
                        dfs(node.left)
                        +
                        dfs(node.right);

        answer =
                Math.max(
                        answer,
                        sum * (totalSum - sum)
                );

        return sum;
    }
}
