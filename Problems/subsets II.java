class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultSubsets = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(resultSubsets, new ArrayList<>(), nums, 0);
        System.out.println(resultSubsets);
        return resultSubsets;
    }
    
    private void backtracking(List<List<Integer>> resultSubsets, List<Integer> tempList, int[] nums, int starting) {
        resultSubsets.add(new ArrayList<>(tempList));
        for(int i=starting; i<nums.length; i++) {
            if(i>starting && nums[i]==nums[i-1]) continue;
            tempList.add(nums[i]);
            backtracking(resultSubsets, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}