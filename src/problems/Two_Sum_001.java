package problems;

import java.util.HashMap;
/*
Given an array of integers, find two numbers such that they add up
to a specific target number.
Assume that each input would have exactly one solution.

Input: an array of integers
Output: indices of the two numbers, where index1 is less than index2.

Notice: cannot use sort because indices are needed
 */

public class Two_Sum_001 {
  public int[] twoSum_hashmap(int[] nums, int target) {
    int len = nums.length;
    // Check the base case 
    if(len <= 1)
      return null;
    
    // Store remain as key, indice as value
    HashMap<Integer, Integer> remains = new HashMap<Integer, Integer>();
    int[] result = new int[2];
    
    // Iterate every num
    for(int i = 0; i < len; i++) {
      int value = nums[i];
      if(remains.containsKey(value)) {
        result[0] = remains.get(value) + 1;
        result[1] = i + 1;
        return result;
      }
        
      int remain = target - value;
      //Notice: need to put the indice as value
      remains.put(remain, i);
    }
    
    // Cannot find these two nums
    return null;
    
  }
}
