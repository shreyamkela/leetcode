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
    // Recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {  
        // Recursive solution
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        if(root==null) {
            return inorder;  
        } 
        
        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
        return inorder;
    }
    
    public List<Integer> traverse(TreeNode root, List<Integer> inorder) {  
     
        if(root==null) {
            return inorder;
        } 
        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
        return inorder;
    }
}