class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(permutations, new ArrayList<>(), nums, new boolean[nums.length]);
        return permutations;
    }
    
    private void backtrack(List<List<Integer>> permutations, List<Integer> tempList, int [] nums, boolean [] visited) {
        if(tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(visited[i] || (i>0 && nums[i] == nums[i-1] && visited[i-1])) continue;
                
                visited[i] = true;
                tempList.add(nums[i]);
                backtrack(permutations, tempList, nums, visited);
                visited[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }
}