// 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
// 2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
// 3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.



import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
     Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    long prev0=1l,prev1=1l;
    for (int i = 2; i <= n; i++) {
     long cur0=prev1;
     long cur1=prev0+prev1;
     prev0=cur0;
     prev1=cur1;

    }
    System.out.println((prev0+prev1)*(prev0+prev1));

 }

}
