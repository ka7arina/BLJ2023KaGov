#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node *next;
}
node;

int main() {

// allocating the space of the node //
struct node *a, *b;
    a = malloc(sizeof(struct node));
    b = malloc(sizeof(struct node));

// set the values with a pointer //
	a->data = 10;
    b->data = 20;


	a->next = b;
    b->next = NULL;
}