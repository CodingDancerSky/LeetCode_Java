package problems;

import java.util.HashMap;

/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman2Integer_014 {
  public int romanToInt(String s) {
    int len = s.length();
    //check the base case
    if(len == 0)
      return 0;
    
    // store the map that corresponds Roman to Integer
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    
    // Notice: pay attention to:
    // 1. start from the last one,
    // 2. get the last number and then it is easy to work on the rest.
    int result = map.get(s.charAt(len - 1));
    for(int i = len - 2; i >= 0; i--){
      int current = map.get(s.charAt(i));
      if(current < map.get(s.charAt(i + 1))) 
        result -= current;
      else
        result += current;
    }
    
    return result;
  }
}
