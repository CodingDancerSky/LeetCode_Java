package problems;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum 
is closest to a given number, target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Three_Sum_Closest_016 {
  public int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    // check the base case
    if(len < 3)
      return Integer.MAX_VALUE;
    
    Arrays.sort(nums);
    // Notice: avoid overflow when (closest - target)
    int closest = Integer.MAX_VALUE / 2;
    
    // i is the first index
    for(int i = 0; i < len - 2; i++) {
      // the second index
      int left = i + 1;
      // the third index
      int right = len - 1;
      
      while(left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        
        if(sum == target) {
          return sum;
        }
        
        if(sum < target)
          left++;
        if(sum > target)
          right--;
        
        closest = Math.abs(sum - target) 
                > Math.abs(closest - target)? closest: sum;        
      }
    }
    
    return closest;  
  }
}
