#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

// setzt auf den node auf und gibt einen pointer auf ihn zurück
TNode* initNode(int data) {
    TNode* newNode = malloc(sizeof(TNode));
    newNode->data = data;

    // Setze den Zeiger auf den nächsten Node auf NULL (da es der einzige Node ist)
    newNode->next = NULL;

    // Gib den Zeiger auf den erstellten Node zurück
    return newNode;
}

void print_data(TNode *head) {
    if(head == NULL) {
        printf("\nLinked List is empty\n");
    }

    // ptr contains NULL - contains nothing
    TNode *ptr = NULL;
    // assign head to it, means assigning the node address
    ptr = head;
    // check if ptr still contains NULL, if not ->
    while(ptr != NULL) {
        // we'll access the data and print it
        printf("%d\n", ptr->data);
        ptr = ptr->next;
    }
}

void addNode(TNode* head, int newData) {
    TNode *ptr = head;
    // weil der ptr nicht hinter ihm sieht gucken wir ob der nächste link NULL ist
    while(ptr->next != NULL) {
        // we'll access the data and print it
        printf("%d\n", ptr->data);
        ptr = ptr->next;
    }
 
    TNode *newNode = malloc(sizeof(TNode));

    if (newNode == NULL) {
        printf("\nMemory allocation failed\n");
        return;
    }

    newNode->data = newData;
    newNode->next = NULL;
    ptr->next = newNode;
}
