/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> view = new ArrayList<>();
    private int maxDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root != null) dfs(root, 1);
        return view;
    }
    
    private void dfs(TreeNode root, int depth) {  
        
        if(depth > maxDepth) {
            maxDepth++; 
            view.add(root.val);
        } 
        
        if(root.right != null) {
            dfs(root.right, depth+1);
        } 
        if(root.left != null) {
            dfs(root.left, depth+1);
        }
    }
}