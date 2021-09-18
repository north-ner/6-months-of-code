// 1. You are given a number n, representing the number of houses.
// 2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

// Sample Input
// 4
// 1 5 7
// 5 8 4
// 3 2 9
// 1 2 4
// Sample Output
// 8


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int [][]cost=new int [n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                cost[i][j]=scn.nextInt();
            }
        }
        
         int [][]dp=new int [n][3];
        dp[0][0]=cost[0][0];
        dp[0][1]=cost[0][1];
        dp[0][2]=cost[0][2];
       
        for(int house =1;house<n;house++){
            //red
            dp[house][0]=Math.min(dp[house-1][1],dp[house-1][2])+cost[house][0];
            
            //green
            dp[house][1]=Math.min(dp[house-1][0],dp[house-1][2])+cost[house][1];
            
            //blue
            dp[house][2]=Math.min(dp[house-1][0],dp[house-1][1])+cost[house][2];
        }
        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));

    }
}
