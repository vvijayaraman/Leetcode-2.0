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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode pop = queue.remove();
                innerList.add(pop.val);

                if (pop.left != null) {
                    queue.add(pop.left);
                }

                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }

            list.add(innerList);

            
        }

        return list;


        
    }
}