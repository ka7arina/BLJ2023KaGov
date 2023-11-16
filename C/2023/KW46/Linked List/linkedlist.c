#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

typedef struct node{
    struct node *next;
    int data;
} TNode ;

void printLinkedList(TNode *head) {
    TNode *current = head;
    while (current != NULL) {
        printf("%d\n", current->data);
        current = current->next;
    }
}

void addNode(TNode** head, int newData) {
    TNode* newNode = (TNode*)malloc(sizeof(TNode));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        return;
    }

    newNode->data = newData;
    newNode->next = *head;
    *head = newNode;
}