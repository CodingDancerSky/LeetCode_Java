package problems;

import java.util.Arrays;
import java.util.HashMap;

/*
Given a string, find the length of the longest substring without repeating 
characters. 

"abcabcbb" is "abc", which the length is 3. 
"bbbbb" is "b", with the length of 1.
 */

public class Longest_Substring_No_Repeating_Characters_003 {
  
  // Notice: this algorithm causes Time Limited Exceeded.
  // because the complexity of containsKey of HashMap is not sure, 
  // so the algorithm is O(n^2) complexity.
  // containsValue is O(n) because all the keys are needed to be visited.
  
  // If replacing with HashSet, it is working because its containsKey is O(1).
  // We only need to change the way that get the start indice when find 
  // repeated character.
  public int lengthOfLongestSubstring_HashMap(String s) {
    int len = s.length();
    // Check base case
    if(len <= 1)
      return len;
    
    int max = 1;
    int head = 0; // the start of s
    // Store the character as key, its indice as value
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    
    for(int i = 0; i < len; i++) {
      char c = s.charAt(i);
     
      // If c is repeated AND make sure it belongs to current string
      if(map.containsKey(c) && map.get(c) >= head ) {
        head = map.get(c) + 1;
      } else {
        max = Math.max(max, i - head + 1);
      }
      
      map.put(c, i);
    }
    
    return max;
  }
  
  
  public int lengthOfLongestSubstring_ints(String s) {
    // Map from character's ASCII to its last occurred index
    int[] map = new int[256];
    Arrays.fill(map, -1);
    
    int max = 0;
    int head = 0;
    int len = s.length();
    
    for(int i = 0; i < len; i++) {
      // Notice: it is supposed to int, not char
      int c = s.charAt(i);
      if(map[c] >= head) {
        max = Math.max(max, i - head);
        head = map[c] + 1;
      }
      map[c] = i;
    }
    
    return Math.max(max, len - head);
  }
  
}
