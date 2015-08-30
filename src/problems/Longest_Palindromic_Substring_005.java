package problems;
/*
Given a string S, find the longest palindromic substring in S. 

Assume that 1. the maximum length of S is 1000, 
            2. there exists one unique longest palindromic substring.
 */

public class Longest_Palindromic_Substring_005 {
  //Method 1
  public static String longestPalindrome_Centre(String s) {
    int len = s.length();
    // check base case
    if(len <= 1)
      return s;
    
    // iterative every char 
    String longest = "";
    for(int i = 0; i < len; i++) {
      // centre at one char
      String odd_palindrome = getPalindrome(s, i, i);
      longest = longerString(longest, odd_palindrome);
      
      // centre at two chars
      String even_palindrome = getPalindrome(s, i, i + 1);
      longest = longerString(longest, even_palindrome);
    }
    
    return longest;
  }

  public static String longerString(String s1, String s2) {
    if(s1.length() > s2.length())
      return s1;
    else 
      return s2;
  }

  public static String getPalindrome(String s, int i1, int i2) {
    while(i1 >= 0 && i2 < s.length() 
            && (s.charAt(i1) == s.charAt(i2))){
      i1--;
      i2++;
    }
    
    // notice: i1 is supposed to add 1.
    return s.substring(i1 + 1, i2);
  }
  
  // Method 2: build up new string, eg: #a#b#b#a# 
  // This method is very sensitive to boundary and index
  public static String longestPalindrome_Sharp(String s) {
    int len = s.length();
    // check base case
    if(len <= 1)
      return s;
    
    // iterative every char in new string
    int max = 0;
    String longest = "";
    int new_len = 2 * len + 1;
    // ignore the first and the last #
    for(int i = 1; i < new_len - 1; i++) {
      int count = 1;
      while(i - count >= 0 && i + count < new_len
              && getChar(s, i - count) == getChar(s, i + count)) {
        count++;
      }
      
      // there will be one extra count for the outbound
      count--;
      
      if(count > max) {
        max = count;
        longest = s.substring((i - count) / 2, (i + count) / 2);
      }
    }
    return longest;
  }

  public static char getChar(String s, int i) {
    if(i % 2 == 0)
      return '#';
    else 
      return s.charAt(i / 2);
  }
}
