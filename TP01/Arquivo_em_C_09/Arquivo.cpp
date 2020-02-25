#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *arquivo;
    arquivo = fopen("Arquivo.txt","w");
    int tamanho, counter = 0;
    scanf("%i",&tamanho);
    
    //Coloca no "Arquivo.txt" os numeros do fluxom, ate o limite tamanho
    for(int x = 0; x < tamanho; x++)
    {
        double numero;
        scanf("%lf",&numero);

        fwrite(&numero, sizeof(double), 1, arquivo);
        counter++;
    }

    //Fecha o inserir em arquivo e reabre o arquivo para leitura
    fclose(arquivo);
    arquivo = fopen("Arquivo.txt","r");

    counter *= 8;
    double numf;
    int inter;
  

    //imprime na tela os numeros que estao no arquivo.txt
    for(int x = 0; x < tamanho; x++)
    {   
        counter -= sizeof(double);
        fseek(arquivo,counter,SEEK_SET);

        fread(&numf, sizeof(double), 1, arquivo);
        if(numf == (int)numf)
        {
            inter = (int)numf;
            printf("%i\n",inter);
        }
        else printf("%g\n",numf);
    }
    fclose(arquivo);
}
