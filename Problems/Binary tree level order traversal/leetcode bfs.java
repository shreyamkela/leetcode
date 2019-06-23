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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        List<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()){
            List<TreeNode> next = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            for(TreeNode node: curr){
                temp.add(node.val);
                if(node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
            }
            list.add(temp);
            curr = next;
        }
        return list;
    }
}