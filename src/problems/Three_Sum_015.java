package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c in S such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Can also implement HashSet to avoid the duplication, and return new 
ArrayList<List<Integer>>(set);
 */

public class Three_Sum_015 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    int len = nums.length;
    // check the base case
    if(len < 3)
      return lists;
    
    Arrays.sort(nums);
    // i is the first index
    for(int i = 0; i < len - 2; i++) {
      // NoticeL to skip duplicate numbers; e.g [0,0,0,0]
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue; 
      }
      // the second index
      int left = i + 1;
      // the third index
      int right = len - 1;
      
      while(left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        
        if(sum == 0) {
          List<Integer> list = new ArrayList<Integer>();
          list.add(nums[i]);
          list.add(nums[left]);
          list.add(nums[right]);
          
          lists.add(list);
          
          left++;
          right--;
          
          // avoid the duplication
          while(left < right && nums[left] == nums[left - 1])
            left++;
          while(left < right && nums[right] == nums[right + 1])
            right--;
        }
        
        if(sum < 0)
          left++;
        if(sum > 0)
          right--;
      }
    }
    
    return lists;
  }
}
