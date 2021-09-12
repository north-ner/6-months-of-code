// Problem Description

// Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

// Also given an integer C which represents knapsack capacity.

// Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

// NOTE:

// You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


public class Solution {
    public int solve(int[] profit, int[] weight, int capacity) {
        int n=profit.length;

        int [][]dp=new int [n+1][capacity+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=capacity;j++){

                int  no=dp[i-1][j];
                int yes=(j-weight[i-1]<0)?0:dp[i-1][j-weight[i-1]]+profit[i-1]; 
                dp[i][j]=Math.max(yes,no);
            }
        }
        return dp[n][capacity];

    }
}
