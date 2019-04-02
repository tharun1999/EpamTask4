import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void addNodeAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    Node middleNode() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void printLinkedList() {
        if (head == null) {
            System.out.println("Empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

public class MiddleElementInLinkedList {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int temp;
        LinkedList list = new LinkedList();
        // Add nodes at end till "-1" is encountered
        while ((temp = s.nextInt()) != -1) {
            list.addNodeAtEnd(new Node(temp));
        }
        s.close();
        System.out.println(list.middleNode().data);
    }
}
