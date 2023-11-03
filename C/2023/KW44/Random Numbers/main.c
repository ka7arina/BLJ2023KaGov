#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define AMOUNT_OF_NUMBERS 4;

int Array[AMOUNT_OF_NUMBERS];

void randomNumbers() {
    srand(time(NULL));
        int i;
        for (i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            Array[i] = rand();
        }
}


int main() {



}