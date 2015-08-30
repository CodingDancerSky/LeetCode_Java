package problems;
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. 
The runtime complexity is O(log (m+n)).

Notice: the index!!! 
 */
public class Median_2Sorted_Arrays_004 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    if(len % 2 == 0) 
      return (findKthMin(nums1, 0, nums2, 0, len / 2) + 
              findKthMin(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    else 
      return findKthMin(nums1, 0, nums2, 0, len / 2 + 1);
  }
  
  public double findKthMin(int[] nums1, int start1, int[] nums2, int start2, int k) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    
    // when one of arrays ends up 
    if(start1 >= len1)
      return nums2[start2 + k - 1];
    if(start2 >= len2)
      return nums1[start1 + k - 1];
    
    // the minimum one
    if(k == 1)
      return Math.min(nums1[start1], nums2[start2]);
    
    // binary compare
    int half = k / 2;
    int index1 = start1 + half - 1;
    int index2 = start2 + half - 1;
    int key1 = index1 < len1? nums1[index1]: Integer.MAX_VALUE;
    int key2 = index2 < len2? nums2[index2]: Integer.MAX_VALUE;
    
    if(key1 <= key2)
      return findKthMin(nums1, index1 + 1, nums2, start2, k - half);
    else 
      return findKthMin(nums1, start1, nums2, index2 + 1, k - half);
  }
}
