
# Finding the Middle Element of a Linked List  
## Object Version vs Generic Version vs Generic + Optional (V2)

This document compares **three implementations** of finding the middle element of a singly linked list in Java:

1. **Object-based version**
2. **Generic-based version**
3. **Generic + Optional version (recommended)**

All implementations use the same algorithm (slow and fast pointers).  
The differences are in **type safety, null handling, and API design**.

---

## Algorithm Used (Common to All)

- Two pointers: `slow` and `fast`
- `slow` moves one step
- `fast` moves two steps
- When `fast` reaches the end, `slow` is at the middle
- For even-length lists, the **second middle** is returned

---

## VERSION 1 — Object-Based Implementation

### Complete Code with Tester

```java
class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

class ObjectVersion {

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

    // Test cases
    public static void main(String[] args) {
        System.out.println("=== Object Version Tests ===\n");

        // TC1: Empty list
        try {
            middleElementOfLinkedList(null);
            System.out.println("TC1 FAILED: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("TC1 PASSED: " + e.getMessage());
        }

        // TC2: Single element [10]
        Node t2 = new Node(10);
        Object result2 = middleElementOfLinkedList(t2);
        System.out.println("TC2: " + (result2.equals(10) ? "PASSED" : "FAILED") + " - Expected: 10, Got: " + result2);

        // TC3: Two elements [10, 20]
        Node t3 = new Node(10);
        t3.next = new Node(20);
        Object result3 = middleElementOfLinkedList(t3);
        System.out.println("TC3: " + (result3.equals(20) ? "PASSED" : "FAILED") + " - Expected: 20, Got: " + result3);

        // TC4: Three elements [10, 20, 30]
        Node t4 = new Node(10);
        t4.next = new Node(20);
        t4.next.next = new Node(30);
        Object result4 = middleElementOfLinkedList(t4);
        System.out.println("TC4: " + (result4.equals(20) ? "PASSED" : "FAILED") + " - Expected: 20, Got: " + result4);

        // TC5: Five elements [10, 20, 30, 40, 50]
        Node t5 = new Node(10);
        t5.next = new Node(20);
        t5.next.next = new Node(30);
        t5.next.next.next = new Node(40);
        t5.next.next.next.next = new Node(50);
        Object result5 = middleElementOfLinkedList(t5);
        System.out.println("TC5: " + (result5.equals(30) ? "PASSED" : "FAILED") + " - Expected: 30, Got: " + result5);

        // TC6: Six elements [10, 20, 30, 40, 50, 60]
        Node t6 = new Node(10);
        t6.next = new Node(20);
        t6.next.next = new Node(30);
        t6.next.next.next = new Node(40);
        t6.next.next.next.next = new Node(50);
        t6.next.next.next.next.next = new Node(60);
        Object result6 = middleElementOfLinkedList(t6);
        System.out.println("TC6: " + (result6.equals(40) ? "PASSED" : "FAILED") + " - Expected: 40, Got: " + result6);
    }
}
```

### Expected Output

```
=== Object Version Tests ===

TC1 PASSED: The linked list is empty.
TC2: PASSED - Expected: 10, Got: 10
TC3: PASSED - Expected: 20, Got: 20
TC4: PASSED - Expected: 20, Got: 20
TC5: PASSED - Expected: 30, Got: 30
TC6: PASSED - Expected: 40, Got: 40
```

### Risks

- Requires casting
- Runtime `ClassCastException` possible
- No compiler enforcement

---

## VERSION 2 — Generic-Based Implementation

### Complete Code with Tester

```java
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericVersion {

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

    // Test cases
    public static void main(String[] args) {
        System.out.println("=== Generic Version Tests ===\n");

        // TC1: Empty list
        try {
            middleElementOfLinkedList(null);
            System.out.println("TC1 FAILED: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("TC1 PASSED: " + e.getMessage());
        }

        // TC2: Single element [10]
        Node<Integer> t2 = new Node<>(10);
        Integer result2 = middleElementOfLinkedList(t2);
        System.out.println("TC2: " + (result2.equals(10) ? "PASSED" : "FAILED") + " - Expected: 10, Got: " + result2);

        // TC3: Two elements [10, 20]
        Node<Integer> t3 = new Node<>(10);
        t3.next = new Node<>(20);
        Integer result3 = middleElementOfLinkedList(t3);
        System.out.println("TC3: " + (result3.equals(20) ? "PASSED" : "FAILED") + " - Expected: 20, Got: " + result3);

        // TC4: Three elements [10, 20, 30]
        Node<Integer> t4 = new Node<>(10);
        t4.next = new Node<>(20);
        t4.next.next = new Node<>(30);
        Integer result4 = middleElementOfLinkedList(t4);
        System.out.println("TC4: " + (result4.equals(20) ? "PASSED" : "FAILED") + " - Expected: 20, Got: " + result4);

        // TC5: Five elements [10, 20, 30, 40, 50]
        Node<Integer> t5 = new Node<>(10);
        t5.next = new Node<>(20);
        t5.next.next = new Node<>(30);
        t5.next.next.next = new Node<>(40);
        t5.next.next.next.next = new Node<>(50);
        Integer result5 = middleElementOfLinkedList(t5);
        System.out.println("TC5: " + (result5.equals(30) ? "PASSED" : "FAILED") + " - Expected: 30, Got: " + result5);

        // TC6: Six elements [10, 20, 30, 40, 50, 60]
        Node<Integer> t6 = new Node<>(10);
        t6.next = new Node<>(20);
        t6.next.next = new Node<>(30);
        t6.next.next.next = new Node<>(40);
        t6.next.next.next.next = new Node<>(50);
        t6.next.next.next.next.next = new Node<>(60);
        Integer result6 = middleElementOfLinkedList(t6);
        System.out.println("TC6: " + (result6.equals(40) ? "PASSED" : "FAILED") + " - Expected: 40, Got: " + result6);
    }
}
```

### Expected Output

```
=== Generic Version Tests ===

TC1 PASSED: The linked list is empty.
TC2: PASSED - Expected: 10, Got: 10
TC3: PASSED - Expected: 20, Got: 20
TC4: PASSED - Expected: 20, Got: 20
TC5: PASSED - Expected: 30, Got: 30
TC6: PASSED - Expected: 40, Got: 40
```

### Improvements over Object Version

- Compile-time type safety
- No casting
- Same runtime behavior

---

## VERSION 3 — Generic + Optional Implementation (Recommended)

### Complete Code with Tester

```java
import java.util.Optional;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class OptionalVersion {

    static <T> Optional<T> middleElementOfLinkedList(Node<T> head) {

        if (head == null) {
            return Optional.empty();
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return Optional.of(slow.data);
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=== Optional Version Tests ===\n");

        // TC1: Empty list
        Optional<Integer> result1 = middleElementOfLinkedList(null);
        System.out.println("TC1: " + (result1.isEmpty() ? "PASSED" : "FAILED") + " - Expected: empty, Got: " + (result1.isEmpty() ? "empty" : result1.get()));

        // TC2: Single element [10]
        Node<Integer> t2 = new Node<>(10);
        Optional<Integer> result2 = middleElementOfLinkedList(t2);
        System.out.println("TC2: " + (result2.isPresent() && result2.get().equals(10) ? "PASSED" : "FAILED") + " - Expected: 10, Got: " + result2.orElse(null));

        // TC3: Two elements [10, 20]
        Node<Integer> t3 = new Node<>(10);
        t3.next = new Node<>(20);
        Optional<Integer> result3 = middleElementOfLinkedList(t3);
        System.out.println("TC3: " + (result3.isPresent() && result3.get().equals(20) ? "PASSED" : "FAILED") + " - Expected: 20, Got: " + result3.orElse(null));

        // TC4: Three elements [10, 20, 30]
        Node<Integer> t4 = new Node<>(10);
        t4.next = new Node<>(20);
        t4.next.next = new Node<>(30);
        Optional<Integer> result4 = middleElementOfLinkedList(t4);
        System.out.println("TC4: " + (result4.isPresent() && result4.get().equals(20) ? "PASSED" : "FAILED") + " - Expected: 20, Got: " + result4.orElse(null));

        // TC5: Five elements [10, 20, 30, 40, 50]
        Node<Integer> t5 = new Node<>(10);
        t5.next = new Node<>(20);
        t5.next.next = new Node<>(30);
        t5.next.next.next = new Node<>(40);
        t5.next.next.next.next = new Node<>(50);
        Optional<Integer> result5 = middleElementOfLinkedList(t5);
        System.out.println("TC5: " + (result5.isPresent() && result5.get().equals(30) ? "PASSED" : "FAILED") + " - Expected: 30, Got: " + result5.orElse(null));

        // TC6: Six elements [10, 20, 30, 40, 50, 60]
        Node<Integer> t6 = new Node<>(10);
        t6.next = new Node<>(20);
        t6.next.next = new Node<>(30);
        t6.next.next.next = new Node<>(40);
        t6.next.next.next.next = new Node<>(50);
        t6.next.next.next.next.next = new Node<>(60);
        Optional<Integer> result6 = middleElementOfLinkedList(t6);
        System.out.println("TC6: " + (result6.isPresent() && result6.get().equals(40) ? "PASSED" : "FAILED") + " - Expected: 40, Got: " + result6.orElse(null));
    }
}
```

### Expected Output

```
=== Optional Version Tests ===

TC1: PASSED - Expected: empty, Got: empty
TC2: PASSED - Expected: 10, Got: 10
TC3: PASSED - Expected: 20, Got: 20
TC4: PASSED - Expected: 20, Got: 20
TC5: PASSED - Expected: 30, Got: 30
TC6: PASSED - Expected: 40, Got: 40
```

### Why Optional Is Better

- No `null` return values
- Absence of data is explicit
- Caller is forced to handle empty lists

---

## Visual Comparison Summary

| Aspect | Object | Generic | Generic + Optional |
|------|--------|--------|--------------------|
Type safety | Runtime | Compile-time | Compile-time |
Null handling | Exception | Exception | Explicit |
Casting | Required | None | None |
Empty list clarity | Low | Medium | High |
API safety | Low | Medium | High |

---

## Final Takeaways

- Object-based code works but is fragile
- Generics eliminate type errors at compile time
- Optional eliminates null-related ambiguity
- **Generic + Optional** best represents real-world uncertainty
- Algorithm remains unchanged across all versions

---

> Rule of thumb:  
> Use **Generics** for type safety.  
> Use **Optional** when “no result” is a valid outcome.
