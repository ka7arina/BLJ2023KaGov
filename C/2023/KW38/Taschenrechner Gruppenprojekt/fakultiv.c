#include <stdio.h>

int fakultaet(int x) {
  if (x > 1) {
    return x * fakultaet(x - 1);
  } else {
    return 1;
  }
}

int main() {
  int zahl = 5;
  printf("Die Fakultät von %d ist %d\n", zahl, fakultaet(zahl));
  return 0;
}