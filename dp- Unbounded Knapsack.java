// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//     overflowing it's capacity.
// Note -> Each item can be taken any number of times. You are allowed to put the same item again 
//                   and again.




import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] val = new int[n];
    for (int i = 0; i < n; i++ ) {
      val[i] = scn.nextInt();
    }
    int [] weight = new int [n];
    for (int i = 0; i < n; i++ ) {
      weight[i] = scn.nextInt();
    }
    int cap = scn.nextInt();
    int [] dp = new int [cap + 1];
    for (int i = 1; i <= cap; i++) {
      for (int j = 0; j < n; j++) {
        int remCap = i - weight[j];
        if (remCap >= 0) {
          int remProfit = dp[remCap];
          int totalProfit = val[j] + remProfit;
          dp[i] = Math.max(dp[i], totalProfit);

        }

      }

    }


    System.out.println(dp[cap]);
  }

}
