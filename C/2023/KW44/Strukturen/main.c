#include <stdio.h>
#include <stdlib.h>
#include "options.h"

typedef struct Person {
char firstname[30+1];
char lastname[30+1];
int birthyear;
int weight;
int height;

} TPerson;

TPerson family[4];

typedef struct fancyClub {
    char clubname[30+1];
    char clubtheme[20+1];
} TfancyClub;


void initFamily() {
    TPerson john = {.firstname = "John", .lastname = "Doe", .birthyear = 1981, .weight = 91, .height = 196};
    TPerson jane = {.firstname = "Jane", .lastname = "Doe", .birthyear = 1980, .weight = 64, .height = 178};
    TPerson jack = {.firstname = "Jack", .lastname = "Doe", .birthyear = 2008, .weight = 40, .height = 163};
    TPerson judy = {.firstname = "Judy", .lastname = "Doe", .birthyear = 2015, .weight = 30, .height = 124};
    family[0] = john;
    family[1] = jane;
    family[2] = jack;
    family[3] = judy;
}

void printFamily() {
   // i dont know if this is correct //
    for (int i = 0; i < 4; i++) {
        printf("Vorname: %s \n Nachname: %s \n Geburtsdatum: %d \n Gewicht: %d \n Höhe: %d\n",
               family[i].firstname,
               family[i].lastname,
               family[i].birthyear,
               family[i].weight,
               family[i].height);
    }
}

void printPerson(TPerson person) {
   printf("First Name: %s\nLast Name: %s\nBirth Year: %d\nWeight: %d\nHeight: %d\n",
        person.firstname,
        person.lastname,
        person.birthyear,
        person.weight,
        person.height); 
}

findOldestFamilyMember()
fancyClub()




int main() {

initFamily();




return 0;
}