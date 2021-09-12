// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
// 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
//      any row in the left wall.
// 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).






import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int [][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int [][]dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=0;
        for(int i=0;i<n;i++){
        int locAns=memGold(i,0,arr,dp);
        ans=Math.max(ans,locAns);
            
        }
        System.out.println(ans);
          System.out.println(tabGold(arr));
    }
    //using memoization ..........................................................
    
    public static int memGold(int r, int c , int [][]arr,int[][]dp){
        //negative base case
        if(r<0||r>=arr.length){
            return 0;
        }
        
        //positive base case when we reah the right wall
        if(c==arr[0].length-1){
            return arr[r][c];
        }
        
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        //faith
        int up=memGold(r-1,c+1,arr,dp);
        int right=memGold(r,c+1,arr,dp);
        int down=memGold(r+1,c+1,arr,dp);
        
        int ans= arr[r][c]+Math.max(up,Math.max(right,down));
        dp[r][c]=ans;
        return ans; 
    }
//using tabulation ...........................................................................  
      public static int tabGold(int [][]arr){
        int n=arr.length;
        int m=arr[0].length;
       int [][]dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        } 
        int ans=0;
            for(int j=m-1;j>=0;j--){
                for(int i=0;i<n;i++){
                    if(j==m-1){
                        dp[i][j]=arr[i][j];
                    }else {
                        int up=(i-1>=0)?dp[i-1][j]:0;
                        int right=dp[i][j+1];
                        int down=(i+1<n)?dp[i+1][j+1]:0;
                    dp[i][j]=arr[i][j]+Math.max(up,Math.max(right,down));        
                    }  
                
                
            }
            
        }
        int ans=0;
        for(int i=0;i<n;i++){
        ans=Math.max(ans,dp[i][0]);
        }
                    return ans;
        
    }

}

}
