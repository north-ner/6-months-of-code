// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.


import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // write your code here
    //buy buy sell sell not allowed
    // buy sell buy sell aallowed only
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int []arr = new int [n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int [] left = new int [n];
    int [] right = new int [n];
    int minVal = arr[0];

    int maxVal = 0;
    int maxTwo = 0;
    int maxOne = 0;
    int diff = 0;
    // int pointer=0;

    for (int i = 1; i < n; i++) {
      int currProf = arr[i] - minVal;
      if (left[i - 1] > currProf) {
        currProf = left[i - 1];
      }
      left[i] = currProf;
      minVal = Math.min(arr[i], minVal);
    }
    int sellDay = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      int currProf = sellDay - arr[i];
      if (right[i + 1] > currProf) {
        currProf = right[i + 1];
      }
      right[i] = currProf;
      sellDay = Math.max(arr[i], sellDay);

    }

    //max of left[i]+right[i]for each day

    int maxProf = 0;
    for (int i = 0; i < n; i++) {
      int currProf = left[i] + right[i];
      if (currProf > maxProf) {
        maxProf = currProf;
      }


    }
    System.out.println(maxProf);
  }
}
