#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>


bool isFim(char* s)
{
   return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char * Alteracao(char* s, char VelhaLetra, char NovaLetra, int i)
{
    if(i < strlen(s))
    {
        if(s[i] == VelhaLetra)s[i] = NovaLetra;
        strcpy(s,Alteracao(s, VelhaLetra, NovaLetra, i + 1));
    }
    return s;
}


int main()
{
    char palavra[1000][1000];
    int i = 0;

    do                                             
    {
        fgets(palavra[i], 1000, stdin);
    } while (isFim(palavra[i++]) == false);       
    i--;

    srand(4);

    for(int c = 0; c < i; c++)
    {
        char VelhaLetra = (char)('a' + abs(rand() % 26));
        char NovaLetra = (char)('a' + abs(rand() % 26));
        printf("%s",Alteracao(palavra[c],VelhaLetra,NovaLetra,0));
    }
}
