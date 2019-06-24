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
        // Inspired by the solution of myfavcat123
        // Refer - https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
        // We dont care about the nodes in the 2 lists that are before the intersection point. 
        // Therefore we can neglect them.
        // What we do here is make the lengths of the 2 lists the same by trimming the nodes from the head in the 2 lists.
        // Keep removing till the length of the bigger list is equal to the length of the smaller. 
        // Once we have the lengths equal, we iterate both the lists together and find whether the 
        // current nodes in that iteration are equal or not.
        // Time complexitiy - O(n), Space complexity - constant
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        int lengthA = 0, lengthB = 0, difference = 0;
        
        // Iterate the 2 lists to get their lengths
        while(tempHeadA != null) {  
            lengthA++;
            tempHeadA = tempHeadA.next;
        }
        while(tempHeadB != null) {  
            lengthB++;
            tempHeadB = tempHeadB.next;
        }
        
        // As tempHeadA and tempHeadB have iterated over themselves, therefore reinitialize them
        tempHeadA = headA;
        tempHeadB = headB;
        // Make the bigger list's length equal to the smaller lists length
        if(lengthA>=lengthB) {
            difference = lengthA-lengthB;
            System.out.println("X" + difference);
            for(int i=0; i<difference; i++) {
                tempHeadA = tempHeadA.next;
            }
        } else {
            difference = lengthB-lengthA;
            for(int j=0; j<difference; j++) {
                tempHeadB = tempHeadB.next;
            }
        }

        // Now as both lists have the same lengths, check for equal node
        while(tempHeadA != null || tempHeadB != null) {           
            if(tempHeadA == tempHeadB) {
                return tempHeadA;
            } else {
                if(tempHeadA != null) tempHeadA = tempHeadA.next;
                if(tempHeadB != null) tempHeadB = tempHeadB.next;
            }
        }
        
        return null;
    }
}