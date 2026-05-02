package trees;

public class SameTree {
    public static void main(String[] args) {
        TreeNode first = new TreeNode(1);
        first.left = new TreeNode(2);
        first.right = new TreeNode(3);

        TreeNode second = new TreeNode(1);
        second.left = new TreeNode(2);
        second.right = new TreeNode(3);

        System.out.println(isSameTree(first, second));
    }

    private static boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        return first.value == second.value
                && isSameTree(first.left, second.left)
                && isSameTree(first.right, second.right);
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}