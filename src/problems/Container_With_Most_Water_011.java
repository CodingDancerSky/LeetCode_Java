package problems;
/*
Given n non-negative integers a1, a2, ..., an, where each represents 
a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such 
that the container contains the most water.

Notice: just two combines a tank, no need to consider these between
these two.
 */
public class Container_With_Most_Water_011 {
  public int maxArea(int[] height) {
    // check base case
    if(height.length <= 1)
      return 0;
    
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while(left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      max = Math.max(max, area);
      if(height[left] < height[right])
        left++;
      else 
        right--;
    }
    
    return max;
  }
}
