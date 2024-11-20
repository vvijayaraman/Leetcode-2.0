/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);

            if (pop.right != null) {
                stack.add(pop.right);
            }

            if (pop.left != null) {
                stack.add(pop.left);
            }

        }

        return list;

    }
}

/* Recursion
 public List<Integer> preorderTraversal(TreeNode root) {
        // Root, left, right
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
        
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }

*/