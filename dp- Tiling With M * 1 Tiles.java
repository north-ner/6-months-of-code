// 1. You are given a number n and a number m separated by line-break representing the length and breadth of a m * n floor.
// 2. You've an infinite supply of m * 1 tiles.
// 3. You are required to calculate and print the number of ways floor can be tiled using tiles.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int [] dp=new int [n+1];
        Arrays.fill(dp,-1);
        System.out.println(rec(n,m,dp));
    }
    
    public static int rec(int n, int m, int [] dp){
        if(n<0)return 0;
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans=0;
         ans=rec(n-1,m,dp)+rec(n-m,m,dp);
        dp[n]=ans;
        return ans;
        
    }
}
