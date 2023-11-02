#include <stdio.h>
#include <stdlib.h>

void swap(int *x, int *y); 

int main(int argc, char **argv) {
		int x = 3;
		int y = 4;
	
	swap(&x, &y);

	printf("value of x is: %d", x);
	printf("\nvalue of y is: %d", y);

	return (EXIT_SUCCESS);
	
	}

// function that swaps x with y and vice versa
	void swap(int *x,int *y){
        int tmp;
        tmp = *x;
        *x=*y;
        *y=tmp;
    }