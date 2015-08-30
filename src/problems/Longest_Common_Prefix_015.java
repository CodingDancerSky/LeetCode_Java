package problems;

/*
Find the longest common prefix string amongst an array of strings.
 */
public class Longest_Common_Prefix_015 {
  public String longestCommonPrefix(String[] strs) {
    int nums = strs.length;
    // check the base case
    if(nums == 0)
      return "";
    
    String prefix = strs[0];
    for(int i = 1; i < nums; i++) {
      String s = strs[i];
      int end = 0;
      while(end < Math.min(prefix.length(), s.length()) 
              && (prefix.charAt(end) == s.charAt(end)))
        end++;
      
      // if prefix = "", no need to continue
      if(end == 0)
        return "";
      
      prefix = prefix.substring(0, end);
    }
    
    return prefix;
  }
}
