#include <stdio.h> 
#include <time.h>

int main()
{

int random_num = 0;
int max = 0;
int your_guess = 0;
int tries = 10;


srand(time(NULL));

printf("Until what number do you want to guess?");
scanf("%d", &max);

random_num = (rand()% max) +1;



printf("Guess the Number! ");

do {

    if(tries == 0)
    printf("You lost!");

scanf("%d", &your_guess);

if(your_guess == random_num){
    tries--;
// true
printf("Congrats, you won!");
} 
else if(your_guess < random_num) {
    tries--;
    printf("Higher!");

}
else if(your_guess > random_num) {
    tries--;
    printf("Lower!");
    } 
} while (your_guess != random_num);
 return 0;

}