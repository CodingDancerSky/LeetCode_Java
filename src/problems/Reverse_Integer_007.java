package problems;
/*
Reverse digits of an integer.

Notice:
If the integer's last digit is 0, what should the output be?
Did you notice that the reversed integer might overflow?
 */

public class Reverse_Integer_007 {
  public int reverse(int x) {
    int result = 0;
    while(x != 0) {
      int next = result * 10 + x % 10;
      x = x / 10;
      
      // if the reversed integer is larger than Integer.Maximum
      if(next / 10 != result)
        return 0;
      result = next;
    }
    
    return result;
  }
}
