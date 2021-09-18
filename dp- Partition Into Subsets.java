// 1. You are given a number n, representing the number of elements.
// 2. You are given a number k, representing the number of subsets.
// 3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
// E.g.
// For n = 4 and k = 3 total ways is 6
// 12-3-4
// 1-23-4
// 13-2-4
// 14-2-3
// 1-24-3
// 1-2-34

// Sample Input
// 4
// 3
// Sample Output
// 6



import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k,long[][]dp) {
        // write your code here
        if(n==0||k==0||n<k){
            return 0;
        }
        if(k==1||n==k){
            return 1;
        }
        if(dp[n][k] != -1){
            return dp[n][k];
        }
        
        long x=partitionKSubset(n-1,k,dp);
        long y=partitionKSubset(n-1,k-1,dp);
        
        long ans=x*k+y;
        dp[n][k]=ans;
        return ans;
        
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long [][]dp=new long [n+1][k+1  ];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j]=-1;
                
            }
        }
        
        
        long res = partitionKSubset(n, k, dp);
        System.out.println(res);
    }
}
