#include <stdio.h>
#include <stdlib.h>


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

void printPerson(TPerson person) {

    printf("Name: %s %s\n", person.firstname, person.lastname);
    printf("Geburtsjahr: %d\n", person.birthyear);
    printf("Gewicht: %d\n", person.weight);
    printf("Größe: %d\n", person.height);
}

void printFamily() {
    int i;
    for (i=0; i<4; i++) {
        printPerson(family[i]);
    }
}

TPerson findOldestFamilyMember() {
    TPerson oldest = family[0];
    int i;
    for (i=1; i<4; i++) {
        if (family[i].birthyear < oldest.birthyear) {
            oldest = family[i];
        }
    }
    return oldest;
}

fancyClub()



int main() {

initFamily();
printFamily();
printPerson();
findOldestFamilyMember();

}

