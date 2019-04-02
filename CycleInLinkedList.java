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

    boolean hasCycle() {
        Node slow = head, fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
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

public class CycleInLinkedList {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int temp;
        ArrayList<Node> listOfNodes = new ArrayList<>();
        LinkedList list = new LinkedList();
        Node n = null;
        // Add nodes at end till "-1" is encountered
        while ((temp = s.nextInt()) != -1) {
            n = new Node(temp);
            list.addNodeAtEnd(n);
            listOfNodes.add(n);
        }

        System.out.println("Do you want to add a Cycle"); // Demonstration purpose
        // If "1" is entered it will create a pointer to any of the already inserted
        // nodes

        int addCycle = s.nextInt();
        if (addCycle == 1) {
            int index = (int) (Math.random() * (listOfNodes.size()));
            n.next = listOfNodes.get(index);
        }
        s.close();
        System.out.println(list.hasCycle());
    }
}
