
# Finding the Middle Element of a Linked List  
## Object Version vs Generic Version (Visual Comparison)

This document compares two implementations of finding the middle element of a singly linked list in Java:

1. **Object-based version**
2. **Generic-based version**

Both use the same algorithm (slow and fast pointers) and the same test cases.  
The difference lies in **type safety and risk**.

---

## Algorithm Used (Common to Both)

- Two pointers: `slow` and `fast`
- `slow` moves one step
- `fast` moves two steps
- When `fast` reaches the end, `slow` is at the middle
- For even-length lists, the **second middle** is returned

---

## VERSION 1 — Object-Based Implementation

### Code

```java
class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class ObjectVersion {

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
        Node t1 = new Node(10);
        System.out.println("List size 1: " + middleElementOfLinkedList(t1));

        Node t2 = new Node(10);
        t2.next = new Node(20);
        System.out.println("List size 2: " + middleElementOfLinkedList(t2));

        Node t3 = new Node(10);
        t3.next = new Node(20);
        t3.next.next = new Node(30);
        System.out.println("List size 3: " + middleElementOfLinkedList(t3));

        Node t5 = new Node(10);
        t5.next = new Node(20);
        t5.next.next = new Node(30);
        t5.next.next.next = new Node(40);
        t5.next.next.next.next = new Node(50);
        System.out.println("List size 5: " + middleElementOfLinkedList(t5));
    }
}
```

### Outputs

| List Size | Output |
|----------|--------|
| 1 | 10 |
| 2 | 20 |
| 3 | 20 |
| 5 | 30 |

---

### Risks of Object Version

```java
Object result = middleElementOfLinkedList(t5);
String s = (String) result; // Runtime ClassCastException risk
```

- No compile-time type checking  
- Requires explicit casting  
- Errors appear at runtime  

---

## VERSION 2 — Generic-Based Implementation

### Code

```java
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class GenericVersion {

    static <T> T middleElementOfLinkedList(Node<T> head) {

        if (head == null) {
            throw new IllegalArgumentException("The linked list is empty.");
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        Node<Integer> t1 = new Node<>(10);
        System.out.println("List size 1: " + middleElementOfLinkedList(t1));

        Node<Integer> t2 = new Node<>(10);
        t2.next = new Node<>(20);
        System.out.println("List size 2: " + middleElementOfLinkedList(t2));

        Node<Integer> t3 = new Node<>(10);
        t3.next = new Node<>(20);
        t3.next.next = new Node<>(30);
        System.out.println("List size 3: " + middleElementOfLinkedList(t3));

        Node<Integer> t5 = new Node<>(10);
        t5.next = new Node<>(20);
        t5.next.next = new Node<>(30);
        t5.next.next.next = new Node<>(40);
        t5.next.next.next.next = new Node<>(50);
        System.out.println("List size 5: " + middleElementOfLinkedList(t5));
    }
}
```

### Outputs

| List Size | Output |
|----------|--------|
| 1 | 10 |
| 2 | 20 |
| 3 | 20 |
| 5 | 30 |

---

## Visual Comparison Summary

| Aspect | Object Version | Generic Version |
|------|---------------|----------------|
Type safety | Runtime only | Compile-time |
Casting | Required | Not needed |
Compiler protection | None | Strong |
Algorithm behavior | Same | Same |
Performance | Same | Same |
Risk level | High | Low |

---

## Key Takeaways

- Both versions behave identically at runtime  
- Generics do not change the algorithm  
- Generics move error detection from runtime to compile time  
- Object-based code works but is fragile  
- Generic code is safer and preferred in modern Java
