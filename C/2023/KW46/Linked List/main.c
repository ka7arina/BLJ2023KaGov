#include <stdio.h>

typedef struct node
{
    int number;
    struct node *next;
}
node;

/* Initialize nodes */
struct node *head;
struct node *one = NULL;
struct node *two = NULL;
struct node *three = NULL;
