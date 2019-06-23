class Solution {
    public int singleNumber(int[] nums) {
        int repeat=0;
        for (int i=0;i<nums.length;i++){
            repeat ^= nums[i]; 
            //this works as in the nums array each element can only occur twice as stated in the rules
            //so all the elements that occur twice will cause XOR to be 0
            //only that element which occurs once will not cause XOR as 0
            // How the whole bitwise works here I couldnt understand
            // It works like - for eg the for the above code -> input {3,10,10,5,6,6,5} is basically -> 3^10^10^5^6^6^5 -> 3^0^5^0^5 -> 3^5^5 -> 3
        }
        return repeat;
    }
}