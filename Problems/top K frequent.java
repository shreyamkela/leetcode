class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> topK = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> sortedByFreq = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int currentFreq = 0;
        sortedByFreq.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++) {
            currentFreq = freqMap.getOrDefault(nums[i], 0);
            freqMap.put(nums[i], currentFreq+1);
            sortedByFreq.add(new ArrayList<>());
        }
        
        for(int key : freqMap.keySet()) {
            currentFreq = freqMap.get(key);
            currentList = sortedByFreq.get(currentFreq);
            currentList.add(key);
        }
        
        for(int j = sortedByFreq.size()-1; j >= 0; j--) {
            if(sortedByFreq.get(j).size() == 0) continue;
            
            if(k-sortedByFreq.get(j).size() <= 0) {
                currentList = sortedByFreq.get(j);
                for(int l=0; l<k; l++) {
                    topK.add(currentList.get(l));
                }
                return topK;
            } else {
                topK.addAll(sortedByFreq.get(j));
                k -= sortedByFreq.get(j).size();
            }
            
        }
        
        // System.out.println(topK);
        return topK;
    }
}