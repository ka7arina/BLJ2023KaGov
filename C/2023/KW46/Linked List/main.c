#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node *next;
}
node;

int main() {

// allocating the space of the node 
struct node *a, *b, *c, *d, *e, *f;
    a = malloc(sizeof(struct node));
    b = malloc(sizeof(struct node));
	c = malloc(sizeof(struct node));
	d = malloc(sizeof(struct node));
	e = malloc(sizeof(struct node));
	f = malloc(sizeof(struct node));

// set the values with a pointer
	a->data = 10;
    b->data = 20;
	c->data = 30;
	d->data = 40;
	e->data = 50;
	f->data = 60;

// store the adress of b in the next variable of a
	a->next = b;
	b->next = c;
	c->next = d;
	d->next = e;
	e->next = f;
    f->next = NULL;

	printf("%d\n", f->data);
}