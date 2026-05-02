package trees;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int ignoredValue) {
        }
    }
}