#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct node {
    int data;
    struct node* next;
} TNode;

void printLinkedList(TNode *head);
void addNode(TNode** head, int newData);


#endif
