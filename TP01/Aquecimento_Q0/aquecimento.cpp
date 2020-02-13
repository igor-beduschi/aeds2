/*
TP01Q02 - Aquecimento em C 
Igor Beduschi - 659318
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h> 


//Verificar se a letra e maiscula
bool Maiscula (char c){
    return (c >= 'A' && c <= 'Z');
}

//Verificar se a palavra eh FIM
bool Fim(char* palavra){
    return (strlen(palavra) >= 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M');
}


//Chamar o metodo para ver se eh maiscula e contar quantidade de letras maiusculas das palavras 
int ContMaiusculas (char palavra[]){
    int resp = 0;
    
    for(int i = 0; i < strlen(palavra); i++){
        if(Maiscula(palavra[i]) == true){
            resp++; 
        }
    }
    return resp;
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
       printf("%i\n",ContMaiusculas(palavra[i]));
    }
}
