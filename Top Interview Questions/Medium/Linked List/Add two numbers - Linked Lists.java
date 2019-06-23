/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
        // Inspired by the solution of potpie
        // Refer - https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/discuss/1010/Is-this-Algorithm-optimal-or-what
        
        // Initializing the head of the result with 0. The actual result will be stored from resultHead.next
        ListNode resultHead = new ListNode(0);
        // We dont want to iterate on the resultHead itself i.e doing resultHead = resultHead.next as not practical as 
        // we have to return the head of resultHead itself, i.e we dont want to change what the resultHead is poinitng to.
        // Therefore we use a dummy variable resultTemp which will iterate on itself. 
        // Thus the head of resultHead is not changed. 
        // ########## IMPORTANT ##########
        ListNode resultTemp = resultHead;
        // ###############################
        // l1Temp and l2Temp are temp variables that to go to the next node of l1 and l2 respectively, on each iteration
        ListNode l1Temp = l1, l2Temp = l2;
        int carry = 0, sum = 0;

        while(true) {
            if(l1Temp == null && l2Temp == null) {
                break;
            }

            sum = carry; // Re-initializing the sum at each iteration
            
            // Lengths of l1 and l2 can be different therefore we need seperate conditions to check for null
            if(l1Temp != null) {
                sum = sum + l1Temp.val;
                l1Temp = l1Temp.next; // This will be checked for null on next iteration
            } 
            if(l2Temp != null) {
                sum = sum + l2Temp.val;
                l2Temp = l2Temp.next; // This will be checked for null on next iteration
            } 
            
            if (sum > 9) { // If carry then add it to next
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            // ########## IMPORTANT ##########
            resultTemp.next = new ListNode(sum); // Adding the current sum to the next node of resultTemp, i.e on the first iteration, head of resultTemp points to the starting node of our result
            resultTemp = resultTemp.next; // The next node of resultTemp is now resultTemp itself
            // ###############################
        }

        if(carry == 1) { 
            // If both if the last sum was > 9 then there is a carry '1' left, for example (1->9) + (2->8) = (3->7->1)  
            resultTemp.next = new ListNode(1);
        }

        return resultHead.next; // resultHead points to our actual result
        
    }
}