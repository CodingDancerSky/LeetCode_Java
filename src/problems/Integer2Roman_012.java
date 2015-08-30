package problems;

/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.

Roman:
1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
1000~3000: {"M", "MM", "MMM"}.
 */
public class Integer2Roman_012 {
  public String intToRoman(int num) {
    // check the base case
    if(num <= 0)
      return "";
    
    // store the corresponding digit to roman
    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    StringBuffer sb = new StringBuffer();
    int index = 0;
    while(num > 0) {
      int time = num / nums[index];
      num %= nums[index];
      while(time-- > 0) {
        sb.append(romans[index]);
      } 
      index++;
    }
    
    return sb.toString();
  }
}
