// 1. You are required to complete the code of our QueueToStackAdapter class. 
// 2. As data members you've two queues available - mainQ and helperQ. mainQ is to contain data and helperQ is to assist in operations. (This is cryptic - take hint from video)
// 3. Here is the list of functions that you are supposed to complete
//      3.1. push -> Should accept new data in LIFO manner.
//      3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
//       Stack underflow" and return -1.
//      3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
//      underflow" and return -1.
//      3.4. size -> Should return the number of elements available in the stack.
// 4. Input and Output is managed for you.

// Note -> push and size should work in constant time. pop and top should work in linear time.




import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      mainQ.add(val);
      // write your code here
    }

    int pop() {
      // write your code here
      Queue<Integer>helperQ = new ArrayDeque<>();
      int counter = mainQ.size() - 1;
      for (int i = 1; i <= counter; i++) {
        helperQ.add(mainQ.remove());
      }
      int val = mainQ.remove();
      mainQ = helperQ;
      return val;
    }

    int top() {
      // write your code here
      Queue<Integer>helperQ = new ArrayDeque<>();
      int counter = mainQ.size() - 1;
      for (int i = 1; i <= counter; i++) {
        helperQ.add(mainQ.remove());
      }
      int val = mainQ.remove();
      helperQ.add(val);
      mainQ = helperQ;
      return val;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

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
      }
      str = br.readLine();
    }
  }
}
