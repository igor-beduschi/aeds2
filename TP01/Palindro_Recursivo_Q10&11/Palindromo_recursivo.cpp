#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h> 

   bool Fim(char* palavra){
      return (strlen(palavra) >= 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M');
   }

   bool IsPalindromo (char* s, int i){
      bool resp;
      if(i >= strlen(s)/2){
         resp = true;
      }
      else if(s[i] != s[strlen(s) - 2 - i]){
        resp = false;
      }
      else{
         resp = IsPalindromo(s,i+1);
      }
        return resp;
   }

   bool chamarPalindromo(char*s){
      return IsPalindromo(s,0);
   }

int main(int argc, char** argv){

    char palavra[1000][1000];
    int numEntrada = 0;
    
   //Ler da entrada padrao as palavras e chamar mestodo para testar se eh a palavra FIM
    do {
       fgets(palavra[numEntrada], 1000, stdin);
    } while (Fim(palavra[numEntrada++]) == false);
    numEntrada--;   
  
   //Chamar metodo de contar letras maisculas e depois exibir na tela a quantidade de letras maisculas.
    for(int i = 0; i < numEntrada; i++){
      chamarPalindromo(palavra[i]) ? printf("SIM\n") : printf("NAO\n");
    }
}