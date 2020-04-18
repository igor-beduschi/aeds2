#include <stdio.h>
#include <stdlib.h>
#include <time.h>
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
    int n ,comparacoes, MAXTAM, movimentacoes;
}Lista;
Lista lista;

void incrementarContador(int n){
    lista.comparacoes += n;
}

void incrementarMov(int n){
    lista.movimentacoes += n;
}

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

int diferenca(char* um, char* dois){
    int tamanho1 = strlen(um);
    int tamanho2 = strlen(dois);
    int resp = 0;
    if(tamanho1 <= tamanho2){
        for(int a = 0; tamanho1 > a; a++){
            if(um[a] > dois[a]){
                resp = 1;
                a = tamanho1;
            } 
            else if(um[a] < dois[a]){
                resp = -1;
                a = tamanho1;
            }
        }
    }
    else{
        for(int a = 0; tamanho2 > a; a++){
            if(um[a] > dois[a]){
                resp = 1;
                a = tamanho2;
            } 
            else if(um[a] < dois[a]){
                resp = -1;
                a = tamanho2;
            }
        }
    }
    return resp;
}

void swap(int i, int j)
{
	Personagens temp = lista.array[i];
	lista.array[i] = lista.array[j];
	lista.array[j] = temp;
    incrementarMov(3);
}

void mostrar (){
   int i;
   for(i = 0; i < lista.n; i++){
      printf("[%d] ", i);
      PrintarObjeto(lista.array[i]);
   }
}

void mostrar2(){
   int i;
   for(i = 0; i < 10; i++){
      PrintarObjeto(lista.array[i]);
   }
}

bool maior(Personagens a, Personagens b){
    bool res = false;
    if(diferenca(a.anoNascimento,b.anoNascimento) > 0) res = true;
    else if(diferenca(a.anoNascimento,b.anoNascimento) == 0 && diferenca(a.nome,b.nome) > 0) res = true;
    return res;
}

void insertionSort() 
{
    for(int i = 1; i < lista.n; i++) 
    {
        Personagens tmp = lista.array[i];
        int j = i - 1;

        while((j >= 0) && (maior(lista.array[j], tmp)))
        {
            lista.array[j + 1] = lista.array[j];
            j--;
        }
        lista.array[j + 1] = tmp;

    }
}

bool isFim(char* s)
{
    return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');    //retornar true ou false para se eh o FIM
}


int main()
{
    lista.n = 0; lista.MAXTAM = 100;lista.comparacoes = 0;lista.movimentacoes=0;
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

    insertionSort();
    mostrar2();

}



