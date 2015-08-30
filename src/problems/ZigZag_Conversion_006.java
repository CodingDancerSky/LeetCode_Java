package problems;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on 
a given number of rows like this: 
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

The example above is quite confusion, here's a good example:
0       8         16       
1     7 9       1517       
2   6   10    14  18       
3 5     11  13    19       
4       12        20
 */

public class ZigZag_Conversion_006 {
  public String convert(String s, int numRows) {
    int len = s.length();
    // check base case: one line or cannot be made up one col
    if(numRows <= 1 || len <= numRows)
      return s;
    
    char[] chars = new char[len];
    int index = 0;
    int step = 2 * (numRows - 1);
    
    for(int i = 0; i < numRows; i++) {
      int interval = step - 2 * i;
      for(int j = i; j < len; j += step) {
        chars[index++] = s.charAt(j);        
        // there is a second char needed to be included 
        // except the first and last row.
        int second = j + interval;
        // pay attention to the boundary
        if(i > 0 && i < numRows - 1 && second < len && index < len) {
          chars[index++] = s.charAt(second);
        }
      }
    }
    
    return new String(chars);
  }
}
