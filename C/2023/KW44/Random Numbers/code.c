#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// defines a constant as 4 , definiert eine konstante als 4
#define AMOUNT_OF_NUMBERS 4

int Array[AMOUNT_OF_NUMBERS];

/* function randomNumbers takes 4 arguments: int *ptr is a pointer to an integer array. 
int size is the size of the array. int min and int max are two integers, defining the min and max number used for the 
random number generator. */

/* the function generates size random integers between min and max (inclusive) using the rand() function and stores them in the array pointed to by ptr */

void randomNumbers(int *ptr, int size, int min, int max) {
    srand(time(NULL));
        int i;
        for (i = 0; i < size; i++) {
            ptr[i] = rand() % (max - min + 1) + min;
        }
}


int main() {

randomNumbers(Array, AMOUNT_OF_NUMBERS, 0, 100);

    int size = AMOUNT_OF_NUMBERS;

for (int i = 0; i < size; i++) { 
    printf("%d ", Array[i]);


}

return 0;
}