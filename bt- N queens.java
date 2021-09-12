// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
// Note - Queens kill at distance in all 8 directions
// 3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

// IP 4
// OP
// 0-1, 1-3, 2-0, 3-2, .
// 0-2, 1-0, 2-3, 3-1, .








import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] chess = new int[n][n];
    
    // boolean[][]visited = new boolean[n][n];
    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < n; j++) {
    //     chess[i][j] = scn.nextInt();
    //   }
    // }

    printNQueens(chess, "",0);
        
    }
    public static boolean isQueenSafe(int[][]chess,int row,int col){
        //checking column
        for(int i=row-1;i>=0;i--){
            if(chess[i][col]==1) 
            return false;
        }
        //first diagonal
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        if(chess[i][j]==1)return false;
        //second diagonal
        for(int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++)
        if(chess[i][j]==1)return false; 
        
        return true;
    }

    public static void printNQueens(int[][] chess, String output, int row) {
        //+ve base case 
        if(row==chess.length){
            System.out.println(output+".");
            return;
            
        }
        //this look will go to column to column putting queens in different spots
        // put queen in different spots and check if the condition is being met where queens arent 
        // cancelling out each other. if they are then roll back and re arrange the previous queen.
        
        //for loop will go from one column to another
        for(int j=0;j<chess[0].length;j++){
            
            //  
            if(isQueenSafe(chess,row,j)==true){
                chess[row][j]=1;
                //faith: row
                printNQueens(chess,output+row+"-"+j+", ",row+1);
                
                //backtracking step
                chess[row][j]=0;
                
            }
            
        }
        
        
    }
}
