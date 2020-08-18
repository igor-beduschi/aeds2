#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <err.h>

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

typedef struct No {
  Personagens elemento;
  int nivel;
  struct No *esq;
  struct No *dir;
} No;

No* raiz;

No* novoNo(Personagens elemento) {
  No* novo = (No*) malloc(sizeof(No));
  novo->elemento = elemento;
  novo->esq = novo->dir = NULL;
  return novo;
}

int getNivel(No *no)
{
  return (no == NULL) ? 0 : no->nivel;
}

No *setNivel(No *no)
{
  int maior;

  if (getNivel(no->esq) >= getNivel(no->dir))
    maior = getNivel(no->esq);
  else
    maior = getNivel(no->dir);

  no->nivel = 1 + maior;
  return no;
}

No *rotacionarDir(No *no)
{
  No *noEsq = no->esq;
  No *noEsqDir = noEsq->dir;
  noEsq->dir = no;
  no->esq = noEsqDir;
  no = setNivel(no);
  noEsq = setNivel(noEsq);

  return noEsq;
}

No *rotacionarEsq(No *no)
{
  No *noDir = no->dir;
  No *noDirEsq = noDir->esq;
  noDir->esq = no;
  no->dir = noDirEsq;
  no = setNivel(no);
  noDir = setNivel(noDir);

  return noDir;
}

No* balancear(No* i) {
  if(i != NULL){
    int fator = getNivel(i->dir) - getNivel(i->esq);

    //Se balanceada
    if (fator <= 1){
      i = setNivel(i);
    //Se desbalanceada para a direita
    }
    else if (fator == 2){
      int fatorFilhoDir = getNivel(i->dir->dir) - getNivel(i->dir->esq);

      //Se o filho a direita tambem estiver desbalanceado
      if (fatorFilhoDir == -1) {
        i->dir = rotacionarDir(i->dir);
      }
      i = rotacionarEsq(i);

    //Se desbalanceada para a esquerda
    }
    else if (fator == -2){
      int fatorFilhoEsq = getNivel(i->esq->dir) - getNivel(i->esq->esq);
      //Se o filho a esquerda tambem estiver desbalanceado
      if(fatorFilhoEsq == 1) {
        i->esq = rotacionarEsq(i->esq);
      }
      i = rotacionarDir(i);
    }
    else{
     errx(1, "Erro ao balancear!"); 
    }
  }

  return i;
}

No *inserir(No* i, Personagens x){
  if (i == NULL) { 
    i = novoNo(x);
  } 
  else if (diferenca(x.nome,i->elemento.nome) < 0) { 
    i->esq = inserir(i->esq, x); 
  } 
  else if (diferenca(x.nome,i->elemento.nome) > 0) { 
    i->dir = inserir(i->dir, x); 
  } else { 
    errx(1, "Erro ao inserir!");
  }
  i = balancear(i);
  return i;
}

void insercao(Personagens x) {
  raiz = inserir(raiz, x);
}

bool pesquisarRec(char* x, No* i) {
  bool resp;
  if (i == NULL) {
    resp = false;
  } else if (diferenca(x, i->elemento.nome) == 0) {
    resp = true;
  } else if (diferenca(x, i->elemento.nome) < 0) {
    printf("esq ");
    resp = pesquisarRec(x, i->esq);

  } else {
    printf("dir ");
    resp = pesquisarRec(x, i->dir);
  }
  return resp;
}

bool pesquisar(char* x) {
  printf(" raiz ");
  return pesquisarRec(x, raiz);
}


bool isFim(char* s)
{
  return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');    //retornar true ou false para se eh o FIM
}

int main()
{
  char palavra[1000][1000];

  int i = 0;
  do                                              //preencher a matriz
  {
    fgets(palavra[i], 1000, stdin);
  } while (isFim(palavra[i++]) == false);         //testar se eh FIM
  i--;

  int contador = 0;
  
  for ( ; contador < i; contador++)
  {
    strcpy(personagem[contador].nomeArquivo,strndup(palavra[contador],strlen(palavra[contador]) - 1));
    lerPersonagem(contador);
    insercao(personagem[contador]); 
  }

  char entrada2[TAM][TAM];
  int y = 0;
  do                                              //preencher a matriz
  {
    fgets(entrada2[y], TAM, stdin);
  } while (isFim(entrada2[y++]) == false); 
  
  for(int z = 0; z < y-1; z++){
    for(int b = 0; b < strlen(entrada2[z])-1; b++){
      printf("%c",entrada2[z][b]);
    }
    if(pesquisar(entrada2[z])) printf(" SIM\n");
    else printf(" NÃO\n");
  }
}



