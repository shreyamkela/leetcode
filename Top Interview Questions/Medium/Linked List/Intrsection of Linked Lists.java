/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        
        // Iterate through the 2 lists simultaneouly. Put each new node encountered in a set. 
        // If a node is already present in the set then it is the intersection. If while doing this,
        // any node is null then return null as intersection not found.
        // Time complexitiy - O(n), Space complexity - O(m+n)
        while(tempHeadA != null || tempHeadB != null) {           
            if(tempHeadA!=null) {
               if(listNodeSet.contains(tempHeadA)) {
                    return tempHeadA;
                } else {
                    listNodeSet.add(tempHeadA);
                } 
                tempHeadA = tempHeadA.next;
            }
            
            if(tempHeadB!=null) {
                if(listNodeSet.contains(tempHeadB)) {
                    return tempHeadB;
                } else {
                    listNodeSet.add(tempHeadB);
                } 
                tempHeadB = tempHeadB.next;
            }
        }
        
        return null;
    }
}