class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class Task1 {
    static int middleElementOfLinkedList(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
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

        System.out.println(middleElementOfLinkedList(head));
    }
}
