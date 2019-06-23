class Solution {
    public void moveZeroes(int[] nums) {
        
        int temp;
        int zeropos=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                temp = nums[i];
                nums[i] = nums[zeropos];
                nums[zeropos] = temp;
                zeropos++;
            }
            
        }
        
    }
}