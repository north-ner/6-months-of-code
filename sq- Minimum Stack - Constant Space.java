// 1. You are required to complete the code of our MinStack class. 
// 2. As data members you've one stack and a min element available in the class. (This is cryptic - take hint from video)
// 3. Here is the list of functions that you are supposed to complete
//       3.1. push -> Should accept new data in LIFO manner.
//       3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
//        "Stack underflow" and return -1.
//       3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
//       underflow" and return -1.
//      3.4. size -> Should return the number of elements available in the stack.
//      3.5. min -> Should return the smallest element available in the stack. If not 
//      available, print "Stack underflow" and return -1.
// 4. Input and Output is managed for you.

// Note -> The judge maynot be able to check if all your functions are O(1) in time, but that is what the expectation is. Also, you can only use constant space.r

// Sample Input
// push 10
// push 20
// push 5
// push 8
// push 2
// push 4
// push 11
// top
// min
// pop
// top
// min
// pop
// top
// min
// pop
// top
// min
// pop
// top
// min
// pop
// top
// min
// pop
// top
// min
// pop
// quit
// Sample Output
// 11
// 2
// 11
// 4
// 2
// 4
// 2
// 2
// 2
// 8
// 5
// 8
// 5
// 5
// 5
// 20
// 10
// 20
// 10
// 10
// 10




import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> stk;
    int min;

    public MinStack() {
      stk = new Stack<>();
      min = Integer.MAX_VALUE;
    }


    int size() {
        return stk.size();
    }

    void push(int val) {
        
        if(val > min){
            stk.push(val);
        } else {
            int currMin = val;
            int encodedVal = 2 * currMin - min;
            min = currMin;
            stk.push(encodedVal);
        }
        
    }

    int pop() {
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        if(stk.peek() >= min){
            // it is actual value
            int val = stk.pop();
            return val;
        }
        
        // encoded value
        int encodedVal = stk.pop();
        int actualVal = min;
        int prevMin = 2 * actualVal - encodedVal;
        min = prevMin;
        return actualVal;
    }

    int top() {
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        if(stk.peek() >= min)
        {
            // actual val
            return stk.peek();
        }
        
        int actualVal = min;
        return actualVal;
    }

    int min(){
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
