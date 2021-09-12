
// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. You are required to calculate and print the count of encodings for the string str.

//      For 123 -> there are 3 encodings. abc, aw, lc
//      For 993 -> there is 1 encoding. iic 
//      For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//      For 103 -> there is 1 encoding. jc
//      For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
//      print 0.




import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int[]dp = new int[str.length()];
    Arrays.fill(dp, -1);

    System.out.println(countEncoding(str, 0, dp));

  }
  public static int countEncoding(String str, int idx, int[]dp) {
    if (idx == str.length()) {
      return 1;
    }
    if (dp[idx] != -1)return dp[idx];
    int ans = 0;
    int ch1 = str.charAt(idx) - '0';
    if (ch1 >= 1 && ch1 <= 9) {
      ans += countEncoding(str, idx + 1, dp);
    }
    if (idx + 1 < str.length()) {
      int ch12 = (str.charAt(idx) - '0') * 10 + (str.charAt (idx + 1) - '0');
      if (ch12 >= 10 && ch12 <= 26 )
        ans += countEncoding(str, idx + 2, dp);
    }
    dp[idx] = ans;
    return ans;

  }

}
