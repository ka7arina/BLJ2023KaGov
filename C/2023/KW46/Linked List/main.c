#include <stdio.h>

typedef struct node
{
    int number;
    struct node *next;
}
node;

// allocating the space of the node //
struct node *a, *b;
    a = malloc(sizeof(struct node));
    b = malloc(sizeof(struct node));