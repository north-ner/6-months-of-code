// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add 
//      up to "tar" or not.



import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int tar = scn.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();

    }
    System.out.println(re(arr, 0, 0, tar));

  }
  
  //usig recursion .........................................................................

  public static boolean re(int [] arr, int idx, int sum, int tar) {

    if (idx == arr.length) {
      if (tar == sum)return true;
      return false;
    }
    //prunng step
    if (sum > tar) return false;


    //yes
    boolean yes = re(arr, idx + 1, sum + arr[idx], tar);

    //no
    boolean no = re(arr, idx + 1, sum, tar);

    if (yes == true || no == true)return true;
    return false;

  }
}

// using dp.................................................................................

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();

    }
    int tar = scn.nextInt();
    int [][] dp = new int [n + 1][tar + 1];
    for (int i = 0; i < n+1; i++) {
      Arrays.fill(dp[i], -1);

    }
    System.out.println(re(arr, 0, 0, tar, dp));


  }

  public static boolean re(int [] arr, int idx, int sum, int tar, int [][] dp) {

    if (idx == arr.length) {
        if (tar == sum)return true;
        return false;
    }
      
      
    if (sum > tar) return false;
    if (dp[idx][sum] != -1) 
    if(dp[idx][sum]==0){
        return false;
    }else{
        return true;
    }
    //yes
     boolean yes = false;
    if (sum + arr[idx] <= tar) {
      yes = re(arr, idx + 1, sum + arr[idx], tar, dp);
    }
    //no
    boolean no = re(arr, idx + 1, sum, tar, dp);

    if (yes == true || no == true) {
      dp[idx][sum] = 1;
      return true;
    } else {
      dp[idx][sum] = 0;
      return false;
    }

  }

}
