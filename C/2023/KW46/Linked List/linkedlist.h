#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct Node {
    int data;
    struct Node* next;
} TNode;

void print_data(TNode *head);
void addNode(TNode* head, int newData);


#endif
