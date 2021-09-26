// Sample Input
// 5
// push 10
// display
// push 20
// display
// push 30
// display
// push 40
// display
// push 50
// display
// push 60
// display
// top
// pop
// display
// top
// pop
// display
// top
// pop
// display
// top
// pop
// display
// top
// pop
// display
// top
// pop
// quit
// Sample Output
// 10 
// 20 10 
// 30 20 10 
// 40 30 20 10 
// 50 40 30 20 10 
// Stack overflow
// 50 40 30 20 10 
// 50
// 50
// 40 30 20 10 
// 40
// 40
// 30 20 10 
// 30
// 30
// 20 10 
// 20
// 20
// 10 
// 10
// 10

// Stack underflow
// Stack underflow


//make your custom stack, c



import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int top;

    public CustomStack(int cap) {
      data = new int[cap];
      top = -1;
      size=0;
    }

    int size() {
      // write ur code here
      
      return top+1;
    }

    void display() {
      // write ur code here
      for(int i=top;i>=0;i--){
          System.out.print(data[i]+" ");
      }
      System.out.println();
    }

    void push(int val) {
      // write ur code here
      if(top==data.length-1){
          System.out.println("Stack overflow");
          return;
      }
      top++;
      data[top]=val;
    }

    int pop() {
      // write ur code here
      if(top==-1){
          System.out.println("Stack underflow");
          return -1;
      }
      int   topEle=data[top];
      top--;
      return topEle;
    }

    int top() {
       // write ur code here
            if(top==-1){
          System.out.println("Stack underflow");
          return -1;
      }
return data[top];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("display")){
        st.display();
      }
      str = br.readLine();
    }
  }
}
