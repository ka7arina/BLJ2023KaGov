#include <stdio.h>
#include <stdlib.h>

int main()
{
printf("Welcome to the Bubble Sorter");
    int nums[3]; 
    float swap;

    for (int i = 0; i < 3; i++)
    {
        printf("\n--------------------------------------");
    printf("\nPlease Input the numbers you want to sort!\n");
    scanf("%d" , &nums[i]);
    }

do { // swapping system. specihert es temporär in swap ein und überprüft die grössen der zahen
    for(int i = 1; i < 3; i++){
      if (nums[i - 1] > nums[i]){
                swap = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = swap;   
      }
    } // wenn alles richtig ist hört es auf
    if (nums[0] < nums[1] && nums[1] < nums[2] ){
        break;
    }
 } while(1);

 for (int i = 0; i < 3; i++){
            printf("%d, ", nums[i]);
        }
        printf("\n");

    return (EXIT_SUCCESS);
}
