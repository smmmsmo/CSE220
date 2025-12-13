class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class Task2 {

    static Node reverseLinkedList(Node head) {

        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current; // Move pointers one position ahead
            current = next;
        }
        return prev; // New head of the reversed list
    }

    static Node reverseLinkedLNodeRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLinkedLNodeRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseLinkedLNodeRecursive(head);
        printLinkedList(head);
    }

}