// 1. You are given a number n, representing the number of friends.
// 2. Each friend can stay single or pair up with any of it's friends.
// 3. You are required to print the number of ways in which these friends can stay single or pair up.
// E.g.
// 1 person can stay single or pair up in 1 way.
// 2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
// 3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n = scn.nextInt();
        int [] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(friends(n,dp));
    }
    
    public static int friends(int n, int [] dp){
        if(n==0) return 1;
        if(n==1)return 1;
        if(dp[n]!= -1) return dp[n];
        
        
        int ans=friends(n-1,dp)+(n-1)*friends(n-2,dp);
        dp[n]=ans;
        return ans;
    }

}
