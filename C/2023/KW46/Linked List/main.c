#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"


int main() {

TNode *head = NULL;

TNode *head = (TNode*)malloc(sizeof(TNode));
TNode *second = (TNode*)malloc(sizeof(TNode));
TNode *third = (TNode*)malloc(sizeof(TNode));

head->next = second;
second->next = third;


printf("Linked List:\n");
printLinkedList(head);

addNode(&head, 5);

printf("Updated Linked List:\n");
printLinkedList(head);
return 0;

}