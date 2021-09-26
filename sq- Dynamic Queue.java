// 1. You are required to complete the code of our CustomQueue class. The class should mimic the behaviour of a Queue and implement FIFO semantic.
// 2. Here is the list of functions that are written in the class
//     2.1. add -> Accepts new data if there is space available in the underlying array or 
//     print "Queue overflow" otherwise.
//     2.2. remove -> Removes and returns value according to FIFO, if available or print 
//     "Queue underflow" otherwise and return -1.
//     2.3. peek -> Returns value according to FIFO, if available or print "Queue 
//      underflow" otherwise and return -1.
//     2.4. size -> Returns the number of elements available in the queue.
//     2.5. display -> Prints the elements of queue in FIFO manner (space-separated) 
//     ending with a line-break.
// 3. Input and Output is managed for you.





import java.io.*;
import java.util.*;

public class Main {
  public static class CustomQueue {

    int[] data;
    int front;
    int rear;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      rear = 0;
      int size = 0;
    }

    int size() {
      // write ur code
      return size;
    }

    void display() {
      // write ur code here
      int count = 0;
      int idx = front;
      while (count < size) {
        System.out.print(data[idx] + " ");
        count++;
        idx = (idx + 1) % data.length;
      }
      System.out.println();
    }

    void add(int val) {
      if (size == data.length) {
        int [] temp = new int[data.length * 2];
        int count = 0, idx = front;
        while (count < size) {
          temp[count] = data[idx];
          count++;
          idx = (idx + 1) % data.length;


        }
        front = 0;
        rear = data.length;
        data = temp;
      }
      // write ur code here
      data[rear] = val;
      //for circular queue to overcome problem
      rear = (rear + 1) % data.length;
      size++;

    }

    int remove() {
      // write ur code here
      if (size == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        int val = data[front];

        front = (front + 1) % data.length;
        size--;

        return val;
      }
    }

    int peek() {
      // write ur code here
      if (size == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        int val = data[front];
        return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      } else if (str.startsWith("display")) {
        qu.display();
      }
      str = br.readLine();
    }
  }
}
