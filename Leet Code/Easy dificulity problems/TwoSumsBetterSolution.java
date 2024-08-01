import java.util.HashMap;
import java.util.Map;

public class TwoSumsBetterSolution {

        public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the indices of the numbers we have seen
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        // Loop through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number
            int complement = target - nums[i];
            
            // Check if the complement is already in the hash map
            if (numToIndex.containsKey(complement)) {
                // If it is, return the indices of the current number and the complement
                return new int[] { numToIndex.get(complement), i };
            }
            
            // If it is not, add the current number and its index to the hash map
            numToIndex.put(nums[i], i);
        }
        
        // If no solution is found (which shouldn't happen), throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }
    
}

