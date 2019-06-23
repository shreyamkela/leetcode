class Solution {
    public int removeDuplicates(int[] nums) {
        
        int count = 0; 
        
        for(int i=1; i<nums.length; i++) { // start from 1 as we dont need to check 0 position. Check from 1 pos if it is diff than 0
            if(nums[i]!=nums[count]) // if current element in nums is new, make a copy in nums right after the previous new element
            {
                nums[(count++)+1] = nums[i]; // instead of writing count++ in next line we increment it here only so that it saves some millisecs according to leetcode code check
            }
        }
        
        return count+1; // count+1 as we had started count from 0
        
    }
}