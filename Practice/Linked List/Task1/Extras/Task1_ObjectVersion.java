class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class Task1_ObjectVersion {

    static Object middleElementOfLinkedList(Node head) {

        if (head == null) {
            throw new IllegalArgumentException("The linked list is empty.");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        Object middle = middleElementOfLinkedList(head);

        System.out.println("Middle element: " + middle);
    }
}
