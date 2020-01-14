class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new ArrayList<>(), nums);
        return permutations;
    }
    
    private void backtrack(List<List<Integer>> permutations, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(permutations, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
        

    
    }
}