package problems;
/*
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
 
 */
public class Regular_Expression_Matching_010 {
  // s is string, p is regular expression.
  public boolean isMatch(String s, String p) {
    // if p is "", it can only match s = ""
    if(p.isEmpty())
      return s.isEmpty();
    
    // when '*' did not exist
    if(p.length() == 1 || p.charAt(1) != '*') {
      if(!check1char(s, p))
        return false;
      
      return isMatch(s.substring(1), p.substring(1));
    }
    
    // when '*' exists, while until no such case appear
    while(check1char(s, p)) {
      if(isMatch(s, p.substring(2)))
        return true;
      s = s.substring(1);
    }
    
    return isMatch(s, p.substring(2));
  }
  
  boolean check1char(String s1, String s2) {
    if(!s1.isEmpty() && 
            (s1.charAt(0) == s2.charAt(0) || s2.charAt(0) == '.')) 
      return true;
    else
      return false;
  }
}
