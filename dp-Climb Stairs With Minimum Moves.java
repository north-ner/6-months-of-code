import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        //memoriation array
          int[]dp=new int[n];
            Arrays.fill(dp,-1);
                System.out.println(rec(0,n-1,arr,dp));
    }
    
    public static int rec(int src,int dest,int[]arr, int[]dp ){
        //max intger is just to know that there is no path to go from bigger source to lower destination ex as goinfg from src=5 and dest=3. 
        //its a negative base case 
        if(src>dest)return Integer.MAX_VALUE;
        if(src==dest){
            return 0;
            
        }
        
        //memorization step
        if(dp[src]!=-1){
            return dp[src];
        }
        //we taking max value because we have to find the minimum one and every number is smaller than max value hence it will be easy to find the minimum value
        int minMoves=Integer.MAX_VALUE;
        for(int jump=1;jump<=arr[src];jump++){
            
            int ans=rec(src+jump,dest,arr,dp);
            
            //this if is to counter the problem where if adding 1 to max integer value it returns the -infinity
            if(ans!=Integer.MAX_VALUE){
             minMoves=Math.min(minMoves,ans+1);
            }
        }
        dp[src]=minMoves;
        return dp[src];
        
        
    }

}
