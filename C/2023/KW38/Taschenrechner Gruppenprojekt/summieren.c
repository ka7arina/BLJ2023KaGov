#include <stdio.h>

double square_root(double x) {
    double guess = 1.0;
    double epsilon = 0.00001;

    while (1) {
        double new_guess = (guess + x / guess) / 2.0;
        if (fabs(new_guess - guess) < epsilon) {
            return new_guess;
        }
        guess = new_guess;
    }
}

int main() {
    double x;
    printf("Bitte geben Sie eine Zahl ein: ");
    scanf("%lf", &x);
    printf("Die Wurzel von %.2lf ist etwa %.5lf\n", x, square_root(x));
    return 0;
}