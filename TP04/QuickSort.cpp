#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <math.h>

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




typedef struct CelulaDupla 
{
	Personagens elemento;
	struct CelulaDupla* prox;
  struct CelulaDupla* ant;
}CelulaDupla;


CelulaDupla* novaCelulaDupla(Personagens elemento) 
{
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}

int n = 0;

CelulaDupla* primeiro;
CelulaDupla* ultimo;

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

bool maior(Personagens a, Personagens b){
    bool res = false;
    if(diferenca(a.corDoCabelo,b.corDoCabelo) > 0) res = true;
    else if(diferenca(a.corDoCabelo,b.corDoCabelo) == 0 && diferenca(a.nome,b.nome) > 0) res = true;
    return res;
}

CelulaDupla* celulaPos(int x)
{
    CelulaDupla* aux;
    int i = 0;
    for(aux = primeiro; i < x; aux = aux->prox)i++;
    return aux;
}

void inserirFim(Personagens x) 
{
    if(n == 0)
    {
        primeiro = novaCelulaDupla(x);
        ultimo = primeiro;
    }

    else
    {
        ultimo->prox = novaCelulaDupla(x);
        ultimo->prox->ant = ultimo;
        ultimo = ultimo->prox;
    }
    n++;
}

void mostrar(){
   CelulaDupla* i = primeiro;
  for(; i != NULL; i = i->prox)
  {
    PrintarObjeto(i->elemento);
  }
}

void swap(int a, int b)
{
    Personagens tmp = celulaPos(a)->elemento;
    celulaPos(a)->elemento = celulaPos(b)->elemento;
    celulaPos(b)->elemento = tmp;
}

void quicksortRec (int esq, int dir) 
{
  int i = esq, j = dir;
  Personagens pivo = celulaPos((dir+esq)/2)->elemento;

  while (i <= j) 
  {
    CelulaDupla* aux = celulaPos(i);
    while(maior(pivo,aux->elemento))
    {
        aux = aux->prox;
        i++;
    }

    aux = celulaPos(j);
    while(maior(aux->elemento, pivo))
    {
        aux = aux->ant;
        j--;
    }

    if (i <= j) 
    {
        swap(i, j);
        i++;
        j--;
    }
  }

  if(esq < j)quicksortRec(esq, j);
  if(i < dir)quicksortRec(i, dir);
}

void quicksort() 
{
  quicksortRec(0, n-1);
}

bool isFim(char* s)
{
  return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');    //retornar true ou false para se eh o FIM
}


int main()
{
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
  quicksort();
  mostrar();
}



