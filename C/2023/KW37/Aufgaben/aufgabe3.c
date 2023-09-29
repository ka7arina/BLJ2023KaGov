#include <stdio.h>
#include <conio.h>

#define PI 3.141

int main(){
    int radius = 7;
    float area;

    /* Area of Circle = PI x Radius X Radius */
    area = PI*radius*radius;
    printf("Area of circle : %0.4f\n", area);
    
    getch();
    return 0;
}