// 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
// https://youtu.be/ju8vrEAsa3Q?list=TLGGBVZP0QjfybUxODA5MjAyMQ
//   Sample Input
// 8
// 3
// Sample Output
// 3672


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        int [][]dp=new int [2][n];
        dp[0][1]=k;
        dp[1][1]=k*(k-1);
        
        for(int i=2;i<n;i++){
            //c1=c2
            dp[0][i]=dp[1][i-1];
        
            //c1!= c2
            dp[1][i]=(k-1)*(dp[0][i-1]+(dp[1][i-1]));
        }
        //adding both numbers for both II and IJ occurance
        System.out.println(dp[0][n-1]+dp[1][n-1]);
    }
}
