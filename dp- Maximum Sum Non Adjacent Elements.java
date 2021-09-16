// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers, representing n elements.
// 3. You are required to find the maximum sum of a subsequence with no adjacent elements.




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int [] arr=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int isPre=0;
        int [][] dp=new int [n+1][2];
        for(int i=0;i<=n;i++){
            
        
        Arrays.fill(dp[i],-1);
        }
        System.out.println(maxSum(arr,0,isPre,dp));
    }
    
    public static int maxSum(int [] arr, int idx, int isPre, int [][] dp){
        
    if(idx>=arr.length) return 0;
    
    if(dp[idx][isPre]!=-1) return dp[idx][isPre];   
     if(isPre==1){
     int ans=maxSum(arr,idx+1,0,dp);
     dp[idx][isPre]=ans;
     return ans;
     }
     int ansYes=arr[idx]+maxSum(arr,idx+1,1,dp);
     int ansNo=maxSum(arr,idx+1,0,dp);
     int ans=Math.max(ansYes,ansNo);
     return ans;
    }
    
}
