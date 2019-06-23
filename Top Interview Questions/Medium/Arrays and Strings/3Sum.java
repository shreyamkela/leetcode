import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
	    int[] nums = {-1, 0, 1, 0};
	    System.out.println(threeSum(nums));
	}
	  
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums.length < 3) { // Edge cases
            return result;
        } 
        		        
        Map<Integer, Integer> frequencies = new HashMap<>(); // each unique element in the input array and its frequency
        Set<List<Integer>> checkDuplicates = new HashSet<>(); // To check for uniqueness of triplets
        int sumOfTwo;
        		            
        for (int k=0; k<nums.length; k++) { // Find frequency of each unique element in te input array
        	if(frequencies.containsKey(nums[k])) {
                frequencies.put(nums[k], frequencies.get(nums[k]) + 1);
            } else {
                frequencies.put(nums[k], 1);
            }
        }
        
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
            	// sumOfTwo is the sum of ith and jth element. If -(ith + jth) exists in the frequencies array then the sum of these 3 would be 0 and that is our triplet
            	// If sumOfTwo == (-nums[j]) && frequencies.get(nums[j]) < 2) then it means that the element in input array which is has value -(ith + jth), 
            	// is the jth number itself as this number does not repeat as frequency is < 2. Similary for sumOfTwo == (-nums[i]) && frequencies.get(nums[i]) < 2.
            	// If ((sumOfTwo == (-nums[j]) && sumOfTwo == (-nums[i]) && frequencies.get(nums[j]) < 3) is condition to check for array [-1,0,1,0] and [0,0,0]. [-1,0,1,0] should only give [1,0,1]. And [0,0,0] must give [0,0,0] as answer.
            	// Also, to check whether this triplet has occurred previously or not we use checkDuplicates
                sumOfTwo = nums[j] + nums[i];
                if(frequencies.containsKey(-sumOfTwo)) {
                    if((sumOfTwo == (-nums[j]) && frequencies.get(nums[j]) < 2) || (sumOfTwo == (-nums[i]) && frequencies.get(nums[i]) < 2)
                    		|| (sumOfTwo == (-nums[j]) && sumOfTwo == (-nums[i]) && frequencies.get(nums[j]) < 3)) {
                    	continue;
                    } else {
        		        List<Integer> triplet = new ArrayList<>();;
                    	triplet.add(nums[i]); 
                        triplet.add(nums[j]); 
                        triplet.add(-sumOfTwo); 
                        Collections.sort(triplet);
                        if(checkDuplicates.contains(triplet) == true) {
                            continue;
                        } else {
                            checkDuplicates.add(triplet);
                            result.add(triplet);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return result;
    }
}
