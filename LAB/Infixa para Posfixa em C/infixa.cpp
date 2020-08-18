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
  char pilha[1000];
  int i, o = 0, b = -1;
  char c;
  for (i = 0; i < strlen(exp); i++) {
    c = exp[i];
    if (c == '(') pilha[++b] = c;
    else if (c == ')') {
      while (b > -1 && pilha[b] != '(') {
        Saida[o++] = pilha[b--];
      }
      b--;
    } 
    else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))Saida[o++] = c;
    else {
      while (b > -1 && pilha[b] != '(' && sinal(pilha[b]) >= sinal(c)) {
        Saida[o++] = pilha[b--];
      }
      pilha[++b] = c;
    }
  }
  while (b > -1) Saida[o++] = pilha[b--];
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