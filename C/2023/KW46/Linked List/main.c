#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"


int main() {

TNode *head = (TNode*)malloc(sizeof(TNode));
TNode *second = (TNode*)malloc(sizeof(TNode));
TNode *third = (TNode*)malloc(sizeof(TNode));

head->next = second;
second->next = third;

head->data = 1;
second->data = 2;
third->data = 3;
third->next = NULL;


printf("Linked List:\n");
print_data(head);

addNode(head, 5);

printf("Updated Linked List:\n");
print_data(head);

return 0;

}