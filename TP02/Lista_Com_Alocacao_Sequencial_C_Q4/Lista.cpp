#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAM 1000

typedef struct
{
    char nomeArquivo[100], nome[30], corDoCabelo[30], corDaPele[30], corDosOlhos[30], anoNascimento[30], genero[15], homeworld[70];
    int altura;
    double peso;
}Personagens;

char * substring(char* padrao, char * entrada)
{
    return strdup(strstr(entrada,padrao));
}

long int indexOf(char *padrao, char * entrada)
{
   return strstr(entrada,padrao) - entrada;
}

Personagens personagem[100];

char * lerNome(char* line)
{
    return strndup(&line[10],indexOf("'height':",line) - 13);
}

int lerAltura(char * line){
    char* aux = (char *) malloc(1000 *sizeof(char));
    int alt = 0;
    strcpy(aux,strndup(&line[indexOf("'height':",line) + 11],indexOf("'mass':",&line[indexOf("'height':",line) + 11]) - 3));
    if(aux[0] != 'u') sscanf(aux, "%d", &alt);
    return alt; 
}

double lerPeso(char* line)
{
    char* aux = (char *) malloc(1000 *sizeof(char));
    char* aux2 = (char *) malloc(TAM *sizeof(char));
    char* aux3 = (char *) malloc(TAM *sizeof(char));
    double peso = 0;

   strcpy(aux,strndup(&line[indexOf("'mass':",line) + 9],indexOf("'hair_color':",&line[indexOf("'mass':",line) + 9]) - 3));

    int tam = strlen(aux);

    for(int i = 0; i < tam; i++)
    {
        if(aux[i] == ',')
        {
            aux2 = strndup(aux, i);
            strcpy(aux3,&aux[i + 1]);
            strcat(aux2,aux3);
            strcpy(aux,aux2);
        }
    }

    if(aux[0] == 'u')peso = 0;
    else sscanf(aux, "%lf", &peso);
    aux = NULL;
    free(aux);
    aux2 = NULL;
    free(aux2);
    aux3 = NULL;
    free(aux3);

    return peso;
}

char * lerCorDoCabelo(char* line)
{
    return strndup(&line[indexOf("'hair_color':",line) + 15],indexOf("'skin_color':",&line[indexOf("'hair_color':",line) + 15]) - 3);
}

char * lerCorDaPele(char* line)
{
    return strndup(&line[indexOf("'skin_color':",line) + 15],indexOf("'eye_color':",&line[indexOf("'skin_color':",line) + 15]) - 3);
}

char * lerCorDosOlhos(char* line)
{
    return strndup(&line[indexOf("'eye_color':",line) + 14],indexOf("'birth_year':",&line[indexOf("'eye_color':",line) + 14]) - 3);
}

char * lerAnoNascimento(char* line)
{
    return strndup(&line[indexOf("'birth_year':",line) + 15],indexOf("'gender':",&line[indexOf("'birth_year':",line) + 15]) - 3);
}

char * lerGenero(char* line)
{
    return strndup(&line[indexOf("'gender':",line) + 11],indexOf("'homeworld':",&line[indexOf("'gender':",line) + 11]) - 3);
}

char * lerHomeworld(char* line)
{
    return strndup(&line[indexOf("'homeworld':",line) + 14],indexOf("'films':",&line[indexOf("'homeworld':",line) + 14]) - 3);
}

void lerPersonagem(int w)
{
    FILE *arq;
    arq = fopen(personagem[w].nomeArquivo,"rb");

    char* line = NULL;

    size_t bufsize = 1000;
    getline(&line,&bufsize,arq);

    line = strndup(line,indexOf("films",line) + 10);

    strcpy(personagem[w].nome,lerNome(line));

    personagem[w].altura = lerAltura(line);

    personagem[w].peso = lerPeso(line);
    strcpy(personagem[w].corDoCabelo,lerCorDoCabelo(line));

    strcpy(personagem[w].corDaPele,lerCorDaPele(line));

    strcpy(personagem[w].corDosOlhos,lerCorDosOlhos(line));

    strcpy(personagem[w].anoNascimento,lerAnoNascimento(line));

    strcpy(personagem[w].genero,lerGenero(line));

    strcpy(personagem[w].homeworld,lerHomeworld(line));
}

void Printar(int w){
    printf(" ## %s ## ",personagem[w].nome);
    printf("%d ## ",personagem[w].altura);
    printf("%g ## ",personagem[w].peso);
    printf("%s ## ",personagem[w].corDoCabelo);
    printf("%s ## ",personagem[w].corDaPele);
    printf("%s ## ",personagem[w].corDosOlhos);
    printf("%s ## ",personagem[w].anoNascimento);
    printf("%s ## ",personagem[w].genero);
    printf("%s ## \n",personagem[w].homeworld);
}

void PrintarObjeto(Personagens personagem){
    printf(" ## %s ## ",personagem.nome);
    printf("%d ## ",personagem.altura);
    printf("%g ## ",personagem.peso);
    printf("%s ## ",personagem.corDoCabelo);
    printf("%s ## ",personagem.corDaPele);
    printf("%s ## ",personagem.corDosOlhos);
    printf("%s ## ",personagem.anoNascimento);
    printf("%s ## ",personagem.genero);
    printf("%s ## \n",personagem.homeworld);
}

/**
 * ! <---------------------------------------------------------------------------
 * !                                  Fim da classe
 * ! -------------------------------------------------------------------------->
*/

typedef struct
{
    Personagens array[100];
    int n , MAXTAM;
}Lista;
Lista lista;


void inserirInicio(Personagens personagem) {
   int i;
    if(lista.n >= lista.MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   } 
 
   for(i = lista.n; i > 0; i--){
      lista.array[i] = lista.array[i-1];
   }
 
   lista.array[0] = personagem;
   lista.n += 1;
}

void inserirFim(Personagens personagem) {
    if(lista.n >= lista.MAXTAM){
      printf("Erro ao inserir!\n");
      exit(1);
   }
 
   lista.array[lista.n] = personagem;
   lista.n += 1;
}

void inserir(Personagens personagem, int pos) {
   int i;
 
   if(lista.n >= lista.MAXTAM || pos < 0 || pos > lista.n){
      printf("Erro ao inserir!\n");
      exit(1);
   }
 
   for(i = lista.n; i > pos; i--){
      lista.array[i] = lista.array[i-1];
   }
 
   lista.array[pos] = personagem;
   lista.n += 1;
}

void removerInicio() {
   int i;
   Personagens resp;
 
   if (lista.n == 0) {
      printf("Erro ao remover!\n");
      exit(1);
   }
 
   resp = lista.array[0];
   lista.n -= 1;
 
   for(i = 0; i < lista.n; i++){
      lista.array[i] = lista.array[i+1];
   }
 
   printf("(R) %s\n", resp.nome);
}

void removerFim() {
    if (lista.n == 0) {
      printf("Erro ao remover!\n");
      exit(1);
   }
 
   printf("(R) %s\n", lista.array[--lista.n].nome);
}

void removerlista(int pos) {
   int i;
   if (lista.n == 0 || pos < 0 || pos >= lista.n) {
      printf("Erro ao remover!");
      exit(1);
   }

   printf("(R) %s\n",lista.array[pos].nome);
   lista.n -= 1;
 
   for(i = pos; i < lista.n; i++){
      lista.array[i] = lista.array[i+1];
   }
}

void mostrar (){
   int i;

   for(i = 0; i < lista.n; i++){
      printf("[%d] ", i);
      PrintarObjeto(lista.array[i]);
   }
 
}


bool isFim(char* s)
{
    return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');    //retornar true ou false para se eh o FIM
}


int main()
{
    lista.n = 0; lista.MAXTAM = 100;
    char palavra[TAM][TAM];

    int i = 0;

    do                                              //preencher a matriz
    {
        fgets(palavra[i], TAM, stdin);
    } while (isFim(palavra[i++]) == false);         //testar se eh FIM
    i--;

    int contador = 0;
    for ( ; contador < i; contador++)
    {
        strcpy(personagem[contador].nomeArquivo,strndup(palavra[contador],strlen(palavra[contador]) - 1));
        lerPersonagem(contador);
        inserirFim(personagem[contador]);    
    }

    char comandos[TAM][TAM];
    fgets(comandos[0], TAM, stdin);
    int tamanho = atoi(comandos[0]);

    for(int x = tamanho; x > 0; x-- , contador++){
        fgets(comandos[x], TAM, stdin);
        if(comandos[x][0] == 'I'){
            if(comandos[x][1] == 'I'){
                strcpy(personagem[contador].nomeArquivo,strndup(&comandos[x][3],strlen(&comandos[x][3]) - 1));
                lerPersonagem(contador);   
                inserirInicio(personagem[contador]);
             }
            else if(comandos[x][1] == 'F'){
                strcpy(personagem[contador].nomeArquivo,strndup(&comandos[x][3],strlen(&comandos[x][3]) - 1));
                lerPersonagem(contador);   
                inserirFim(personagem[contador]);
            }
            else if(comandos[x][1] == '*'){
                strcpy(personagem[contador].nomeArquivo,strndup(&comandos[x][6],strlen(&comandos[x][6]) - 1));
                lerPersonagem(contador);
                inserir(personagem[contador], atoi(strndup(&comandos[x][3],2)));
            }
        }
        else if(comandos[x][0] == 'R'){
            if(comandos[x][1] == 'I'){
               removerInicio();
            }
            else if(comandos[x][1] == 'F'){
                removerFim();
            }
            else if(comandos[x][1] == '*'){
                removerlista(atoi(strndup(&comandos[x][3],2)));
            }
        }
    }
    mostrar();
}



