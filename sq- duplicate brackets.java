// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.'
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true




import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    Stack <Character>stk = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != ')')
        stk.push(str.charAt(i));

      if (str.charAt(i) == ')') {
        int count = 0;
        while (stk.peek() != '(') {
          count++;
          stk.pop();
        }
        stk.pop();//opening pop

        if (count == 0) {
          System.out.println("true");
          return;
        }

      }
    }
    System.out.println("false");

  }
}

