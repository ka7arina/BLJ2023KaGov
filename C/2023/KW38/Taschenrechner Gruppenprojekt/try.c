#include <stdio.h>

int factorial(int number) {
    int fact = 1;

    if (number < 0)
        printf("Fehler! Fakultät von negativen Zahlen existiert nicht.");
    else {
        for (int i = 1; i <= number; ++i) {
            fact *= i;
        }
    }

    return fact;
}

int main() {
    int number;

    printf("Geben Sie eine positive Zahl ein: ");
    scanf("%d", &number);


    printf("Die Fakultät von %d ist %d.", number, factorial(number));

    return 0;
}