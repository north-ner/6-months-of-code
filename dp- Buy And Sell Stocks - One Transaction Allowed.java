// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed a single transaction.

// Sample Input
// 9
// 11
// 6
// 7
// 19
// 4
// 1
// 6
// 18
// 4
// Sample Output
// 17


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int [n];
        for (int i=0;i<n; i++){
            arr[i]=scn.nextInt();
        }
        int minVal=arr[0];
        int maxVal=0;
        int diff=0;
        for(int i=0;i<n;i++){
            if(arr[i]<minVal){
                minVal=arr[i];
            }
            diff=arr[i]-minVal;
            if(diff>maxVal){
                maxVal=diff;
            }
        }
        System.out.println(maxVal);
    }

}
