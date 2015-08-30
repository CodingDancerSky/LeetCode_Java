package problems;

import java.util.ArrayList;
import java.util.List;

/*
Given a digit string, return all possible letter combinations that the 
number could represent.
 */

public class Letter_Combinations_Phone_Number_017 {
  // the indexes correspond to the digit
  String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", 
                  "pqrs", "tuv", "wxyz"};
  
  public List<String> letterCombinations(String digits) {
    // check base case
    int len = digits.length();
    List<String> ret = new ArrayList<String>();
    if(len == 0)
      return ret;
    
    StringBuffer sb = new StringBuffer();
    return helper(digits, sb, ret);
  }

  public List<String> helper(String digits, StringBuffer sb, 
          List<String> ret) {
    int len = sb.length();
    // reach to one possible string
    if(len == digits.length()) {
      ret.add(sb.toString());
      
    } else {
      // get the next possible chars
      String candidates = map[Integer.parseInt(digits.charAt(len) + "")];
      
      // iterate candidates
      for(int i = 0; i < candidates.length(); i++) {
        sb.append(candidates.charAt(i));
        helper(digits, sb, ret);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    
    return ret;
  }
}
