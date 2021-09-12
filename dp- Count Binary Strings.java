// . You are given a number n.
// 2. You are required to print the number of binary strings of length n with no consecutive 0's.



import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n + 1];
    int [] arr2 = new int[n + 1];
    arr[1] = arr2[1] = 1;
    for (int i = 2; i <= n; i++) {
      arr[i] = arr2[i - 1];
      arr2[i] = arr[i - 1] + arr2[i - 1];

    }
    System.out.println(arr[n] + arr2[n]);


  }

}
