#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node* next;
} TNode;

struct node *create_node(int data) {
    struct node *new_node = (struct node*) malloc(sizeof(struct node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}

void printLinkedList(struct Node* head) {
    struct node* current = head;
    while (current != NULL) {
        printf("%d\n", current->data);
        current = current->next;
    }
}

int main() {

struct node *head = create_node(1);
    struct node *second = create_node(2);
    struct node *third = create_node(3);

    head->next = second;
    second->next = third;

    printLinkedList(head);
    return 0;

}