class Solution {
    List<String> ans = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, new StringBuilder());
        return ans;
    }

    public void traverse(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }

        int len = builder.length(); // Store the original length before modification
        builder.append(root.val).append("->");

        // Found a leaf node
        if (root.left == null && root.right == null) {
            builder.setLength(builder.length() - 2); // Remove the last "->"
            ans.add(builder.toString());
        } else {
            traverse(root.left, builder);
            traverse(root.right, builder);
        }

        builder.setLength(len); // Backtrack to restore the original state
    }
}