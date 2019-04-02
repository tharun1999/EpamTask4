import java.io.*;
import java.util.*;

class EmptyQueueException extends Exception {
    EmptyQueueException(String s) {
        super(s);
    }
}

class QueueUsingStacks {
    Stack<Integer> stack1, stack2;

    QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void enqueue(int ele) {
        stack1.push(ele);
    }

    void dequeue() throws EmptyQueueException {
        if (stack1.empty() && stack2.empty()) {
            throw new EmptyQueueException("No elements in Queue");
        }
        if (stack2.empty()) {
            transfer();
        }
        stack2.pop();
    }

    int peek() throws EmptyQueueException {
        if (stack1.empty() && stack2.empty()) {
            throw new EmptyQueueException("No elements in Queue");
        }
        if (stack2.empty()) {
            transfer();
        }
        return stack2.peek();
    }

    void transfer() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

}

public class QueueUsingTwoStacks {
    public static void main(String[] args) throws EmptyQueueException {
        Scanner s = new Scanner(System.in);
        int queries = s.nextInt();
        QueueUsingStacks queue = new QueueUsingStacks();
        while (queries-- > 0) {
            int operation = s.nextInt();
            switch (operation) {
            case 1:
                int ele = s.nextInt();
                queue.enqueue(ele);
                break;

            case 2:
                queue.dequeue();
                break;

            case 3:
                System.out.println(queue.peek());
                break;

            default:
                System.out.println(-1);
                break;
            }
        }
        s.close();
    }
}
