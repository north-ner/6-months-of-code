// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
// i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
// Sample Input
// 12
// 10
// 15
// 17
// 20
// 16
// 18
// 22
// 20
// 22
// 20
// 23
// 25
// Sample Output
// 19


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
          // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int []cost = new int [n];
    for (int i = 0; i < n; i++) {
      cost[i] = scn.nextInt();
    }
    int [][]dp = new int[n][2];
    //0th col-> extra but ,1t col-> complete sell
    dp[0][0] = -cost[0];
    dp[0][1] = 0;

    for (int i = 1; i < n; i++) {
      //extra buy
      dp[i][0] = Math.max(dp[i - 1][0],(i-2)>=0? ( dp[i - 2][1] - cost[i]):-cost[i]);

      //complete sell
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + cost[i]);


    }
    System.out.println(dp[n - 1][1]);
    }

}
