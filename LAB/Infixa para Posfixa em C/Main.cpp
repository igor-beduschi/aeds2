#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <stdbool.h>

int sinal(const char simbolo) {
  int resp = 0;
  if(simbolo == '^') resp = 3;
  else if(simbolo == '*' || simbolo == '/') resp = 2;
  else if(simbolo == '+' || simbolo == '-') resp = 1;
  return resp;
}

void PosFixa(const char * exp) {
  char Saida[1000];
  char p[1000];
  int i, o = 0, b = -1;
  char c;
  for (i = 0; i < strlen(exp); i++) {
    c = exp[i];
    if (c == '(') p[++b] = c;
    else if (c == ')') {
      while (b > -1 && p[b] != '(') {
        Saida[o++] = p[b--];
      }
      b--;
    } 
    else if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))Saida[o++] = c;
    else {
      while (b > -1 && p[b] != '(' && sinal(p[b]) >= sinal(c)) {
        Saida[o++] = p[b--];
      }
      p[++b] = c;
    }
  }
  while (b > -1) Saida[o++] = p[b--];
  Saida[o++] = '\0';
  printf("%s",Saida);
}

int main(void) {
  int casos = 0;
  char palavra[1000][1000];
  scanf("%d",&casos);
  for(int a = 0; casos >= a; a++){
    fgets(palavra[a], 1000, stdin);
  } 
  for(int a = 0; casos >= a; a++){
    PosFixa(palavra[a]);
  } 
}