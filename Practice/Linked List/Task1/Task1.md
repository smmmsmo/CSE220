```

✍️ Author            :    Mostofa Morshed Sayeem
🌐 Profile           :    https://github.com/smmmsmo
📅 Date              :    Sat Dec 13 2025

🌐 Credits/Links     :    https://www.geeksforgeeks.org/dsa/write-a-c-function-to-print-the-middle-of-the-linked-list/

```

# 📃 Solution
---


## 🎀 C Code 🎀


```c

z

```


---

## 🎀 C++ Code 🎀



```C++

#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int value){
        this->data = value;
        this->next = nullptr;
    }
};

int middleElementOfLinkedList(Node* head){
    if (head == nullptr) {
        throw invalid_argument("The linked list is empty.");
    }

    Node* slow = head;
    Node* fast = head;

    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
    }

    return slow->data;
}

int main() {

    Node* head = new Node(10);
    head->next = new Node(20);
    head->next->next = new Node(30);
    head->next->next->next = new Node(40);
    head->next->next->next->next = new Node(50);
    head->next->next->next->next->next = new Node(60);

    cout << middleElementOfLinkedList(head) << endl;

    return 0;
}

```


---

## 🎀 Java Code 🎀



```java

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

        System.out.println(getMiddle(head));
    }
}


```


---

## 🎀 Python Code 🎀



```Python

z

```


---