package problems;
/*
Implement atoi to convert a string to an integer.

Requirements: 
1. First discards as many whitespace characters as necessary until the first 
non-whitespace character is found. 
2. Then, starting from this character, takes an optional initial plus or minus 
sign followed by as many numerical digits as possible, and interprets them as 
a numerical value. 
3. The string can contain additional characters after those that form the integral 
number, which are ignored and have no effect on the behavior of this function. 
4. If the first sequence of non-whitespace characters in str is not a valid 
integral number, or if no such sequence exists because either str is empty or it 
contains only whitespace characters, no conversion is performed. 
5. If no valid conversion could be performed, a zero value is returned. 
6. If the correct value is out of the range of representable values, 
INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class String2Integer_008 {
  public int myAtoi(String str) {
    // check str is empty or contains only whitespace.
    if(str == null)
      return 0;
    str = str.trim();
    int len = str.length();
    if(len <= 0)
      return 0;
    
    int index = 0;
    // in case of overflow
    long result = 0;
    
    // first char to check sign
    int sign = 1;
    if(str.charAt(index) == '+')
      index++;
    else 
      if(str.charAt(index) == '-') {
        index++;
        sign = -1;
      }
    
    // iterate to get the integer
    while(index < len) {
      char c = str.charAt(index);
      // non-numeric char 
      if(c < '0' || c > '9')
        break;
      
      // add integer
      int v = (int) c - '0';
      result = result * 10 + v;
      // if overflow, no need to continue
      if(result > Integer.MAX_VALUE)
        break;
      
      index++;
    }
    
    // check overflow
    result = result * sign;
    if(result >= Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    if(result <= Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    
    return (int) result;
  }
}
