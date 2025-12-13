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