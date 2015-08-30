package problems;
/*
Determine whether an integer is a palindrome. 
Do this without extra space.
 */
public class Palindrome_Number_009 {
  public boolean isPalindrome(int x) {
    if(x < 0)
      return false;
    
    // calculate the length of number
    int len = 1;
    while(x / len >= 10) {
      len *= 10;
    }
    
    // check the head and the tail
    while(len > 1) {
      int head = x / len;
      int tail = x % 10;
      if(head != tail)
        return false;
      
      x = (x % len) / 10;
      // notice: need to reduce 2
      len /= 100;
    }
    
    return true;
  }
}
