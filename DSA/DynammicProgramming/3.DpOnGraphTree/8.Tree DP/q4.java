// LeetCode 1373 - Maximum Sum BST in Binary Tree

class Solution {

    int ans = 0;

    public int maxSumBST(TreeNode root) {

        dfs(root);

        return ans;
    }

    private int[] dfs(TreeNode node) {

        if(node == null){

            return new int[]{
                    1,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE,
                    0
            };
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if(
                left[0] == 1
                        &&
                        right[0] == 1
                        &&
                        node.val > left[2]
                        &&
                        node.val < right[1]
        ){

            int sum =
                    left[3]
                            +
                            right[3]
                            +
                            node.val;

            ans =
                    Math.max(ans, sum);

            return new int[]{
                    1,
                    Math.min(
                            left[1],
                            node.val
                    ),
                    Math.max(
                            right[2],
                            node.val
                    ),
                    sum
            };
        }

        return new int[]{
                0,
                0,
                0,
                0
        };
    }
}
