class Solution {
    public int singleNumber(int[] nums) {
        
        int single = 0;
        
        HashMap<Integer, Integer> duplicate = new HashMap<>();
        duplicate.put(nums[0], 0);
        
        for(int i=1; i<nums.length; i++) {
            if(duplicate.containsKey(nums[i])) { 
            // we enter first element in nums as first key in map, then check all other elements with the key, 
           	// and store only that element as key, which occurs only once, and keep removing others
                duplicate.remove(nums[i]);
            }
            else {
                duplicate.put(nums[i], 0);
            }   
        }
        
        for (Map.Entry<Integer, Integer> entry : duplicate.entrySet()) 
        // Map.entry class used to manipulate entries in the duplicate map
        // So our for-each iterates all entries in the map
        // Note that here there is only one entry so loop only runs once
        {
            single = entry.getKey(); // only one entry so it is assigned to single
        }
        // Can there be a way by which we can find a particuar 'value' in the map without iterating over it all, as we can do for keys?
        // duplicate.containsValue(0) will only give boolean result as to whether the value exists or not. It wont give its key. But how can we use this?
        // a solution is:
        /*
        * Map.Entry<Integer, Integer> entry = duplicate.entrySet().iterator().next();
        * return entry.getKey();
        * It gives result without using for each but in leetcode the time taken for this is similar to the the uncommented for each code above. 
        * Not sure why. Maybe the iterator and the next function as causing similar delay as the for each loop
        */

        return single;
    }
}
