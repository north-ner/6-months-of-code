// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
// 4. You are standing in top-left cell and are required to move to bottom-right cell.
// 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
// 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
//      right cell).
// 7. You are required to traverse through the matrix and print the cost of path which is least costly.
  
  
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int [][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    int [][]dp = new int[n + 1][m + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    System.out.println(mem(0, 0, n - 1, m - 1, arr, dp));




  }
  //using memoization ......................................................................................

  public static int mem(int sr, int sc, int dr, int dc, int[][]arr, int [][] dp) {
    //negative case
    if (sr > dr || sc > dc) {
      return Integer.MAX_VALUE;

    }
    //base case
    if (sr == dr && sc == dc) {
      return arr[dr][dc];
    }

    //dynamic programming memoizaion step
    if (dp[sr][sc] != -1) {
      return dp[sr][sc];
    }
    //horizontal
    int x = mem(sr, sc + 1, dr, dc, arr, dp);
    //vertical
    int y = mem(sr + 1, sc, dr, dc, arr, dp);

    int cost = arr[sr][sc] + Math.min(x, y);

    dp[sr][sc] = cost;
    return cost;

  }
  //using tabulation......................................................................
    public static int tab(int [][]arr){
      int n=arr.length;
      int m =arr[0].length;
      int [][]dp=new int[n][m];
      //row
      for(int i=n-1;i>=0;i--){
          //col
          for(int j=m-1;j>=0;j--){
              if(i+1<n && j+1<m){
              dp[i][j]=arr[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
              
          }else if(i==n-1 && j==m-1){
              dp[i][j]=arr[i][j];
          }else if(j+1==m){
              dp[i][j]=arr[i][j]+dp[i+1][j];
          }else if(i+1==n){
              dp[i][j]=arr[i][j]+dp[i][j+1];
          }
          
      }
 
  }
  return dp[0][0];

}

}
