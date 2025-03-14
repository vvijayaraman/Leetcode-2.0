class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: Node not found
        if (root == null) {
            return null;
        }

        // Recursive traversal based on BST property
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Key lies in the left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Key lies in the right subtree
        } else {
            // Node to be deleted found

            // Case 1: No left child
            if (root.left == null) {
                return root.right; // Replace with right child
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left; // Replace with left child
            }

            // Case 3: Two children
            TreeNode minNode = InoSucc(root.right); // Find the inorder successor
            root.val = minNode.val; // Replace value with successor
            root.right = deleteNode(root.right, minNode.val); // Delete successor
        }

        return root; // Return the updated tree
    }

    // Helper function to find the inorder successor
    public TreeNode InoSucc(TreeNode node) {
        while (node.left != null) { // Move to the leftmost node
            node = node.left;
        }
        return node;
    }
}