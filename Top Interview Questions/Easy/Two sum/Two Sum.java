class Solution {
    public int[] twoSum(int[] nums, int target) {
               
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        sumMap.put(nums[0],0); // store first element of nums in map
        
        for(int i=1; i<nums.length; i++) {
            if(sumMap.containsKey(target - nums[i])) { 
            // Target - current element = (one of the element already in map)
            // This is our basic condition that we check for each new element
                return new int[] {sumMap.get(target - nums[i]),i};
            }
            // If sum not made by using the current element then put current element in map
            sumMap.put(nums[i],i);
        }
        
        
        throw new IllegalArgumentException("2 element sum solution not found"); 
        // We can throw this exception if no sum found. 
        // When this exception statement is used, no need to include a return statement like the one below. Else, return is required
        // return new int[] {0,0};
    }
}