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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> order = new ArrayList<List<Integer>>();
        List<Integer> thisLevel = new ArrayList<Integer>();
        int level = 1;
        
        if(root == null) {
            return order;
        }
        
        thisLevel.add(root.val);
        order.add(thisLevel);
        traversal(root, order, ++level);
        return order;
        
    }
    
    public List<List<Integer>> traversal(TreeNode root, List<List<Integer>> order, int level) {
System.out.println("XXX" + order + " " + root.val);
        
         
        if(root.right == null && root.left == null) {
                return order;
        }  
        
        List<Integer> thisLevel = new ArrayList<Integer>();
        
        int temp; 
        final int tempLevel;
        tempLevel= level-1;
        boolean newListAdded = false;
        if(order.size()<level) {
            order.add(thisLevel);
            newListAdded = true;
        }        
        
        if(level%2==0) {
            if(root.right != null) {
                
                thisLevel.add(root.right.val);
               
                temp = level;
                System.out.println("A" + order); // thisLevel changes inside order
                traversal(root.right, order, ++level);
                System.out.println("B" + order);
                level = temp;
            }
            if(root.left != null) {
                thisLevel.add(root.left.val);
                temp = level;
                System.out.println("C" + order);
                traversal(root.left, order, ++level);
                System.out.println("D" + order);
                level = temp;
            }   
        } else {
            if(root.left != null) {
                System.out.println("" + order);
                thisLevel.add(root.left.val);
                temp = level;
                System.out.println("E" + order);
                traversal(root.left, order, ++level);
                System.out.println("F" + order);
                level = temp;
            }
            if(root.right != null) {
                thisLevel.add(root.right.val);
                 temp = level;
                
                System.out.println("G" + order);
                traversal(root.right, order, ++level);
                System.out.println("H" + order);
                level = temp;
            }
        }
        System.out.println("y" + thisLevel + tempLevel);
        System.out.println("YYYYYYYYYYYYYYYYYYY" + order);
        if(newListAdded == false) {
            order.get(tempLevel).add(0, thisLevel.get(0));
        }     
        System.out.println("XXXXXXXXXXx" + order);

        //order.add(level, thisLevel); // thisLevel already appended
        
        return order;
    }
}