import java.util.Random;
import java.io.*;
import java.nio.charset.*;


class Celula {
  int elemento;
  Celula prox, ant, inf, sup;

  public Celula() {
    this(0);
  }

  public Celula(int elemento) {
    this.elemento = elemento;
    prox = ant = inf = sup = null;
  }
}

class Matriz {
  int linha, coluna;
  Celula inicio;
  Random gerador = new Random();

  public Matriz() {
    this(3, 3);
  }

  public Matriz(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
    int x = 0;

    Celula i, j;
    int lin, col;

    inicio = new Celula(x++);

    for (j = inicio, col = 1; col < coluna; j = j.prox, col++) {
      j.prox = new Celula(x++);
      j.prox.ant = j;
    }

    for (i = inicio, lin = 1; lin < linha; i = i.inf, lin++) {
      i.inf = new Celula(x++);
      i.inf.sup = i;
      for (j = i.inf, col = 1; col < coluna; j = j.prox, col++) {
        j.prox = new Celula();
        j.prox.ant = j;
        j.prox.sup = j.sup.prox;
        j.sup.prox.inf = j.prox;
      }
    }
  }

  public void gerar(int[] valor) {
    int a = 0;
    for (Celula i = inicio; i != null; i = i.inf) {
      for (Celula j = i; j != null; j = j.prox,a++) {
        j.elemento = valor[a];
      }
    }
  }

  public void mostrar() {
    for (Celula i = inicio; i != null; i = i.inf) {
      for (Celula j = i; j != null; j = j.prox) {
        System.out.printf("%d ", j.elemento);
      }
      System.out.printf("\n");
    }
  }

  public Matriz somar(Matriz m2) {
    Matriz soma = null;

    if (linha == m2.linha && coluna == m2.coluna) {
      soma = new Matriz(linha, coluna);
      Celula i2 = m2.inicio;
      Celula si = soma.inicio;

      for (Celula i = inicio; i != null; i = i.inf, i2 = i2.inf, si = si.inf) {
        Celula j2 = i2;
        Celula sj = si;

        for (Celula j = i; j != null; j = j.prox, j2 = j2.prox, sj = sj.prox) {
          sj.elemento = j.elemento + j2.elemento;
        }
      }

    }

    return soma;
  }

  public int getElemento(int linha,int coluna){
    Celula i = inicio;
    for(int x = 0; x < linha && i != null;x++,i = i.inf);
    for(int y=0; y < coluna && i != null;y++,i = i.prox);

    return i.elemento;
  }

  public Matriz multiplicar(Matriz m2) {
    Matriz multiplicacao = null;

    if (coluna == m2.linha) {
      multiplicacao = new Matriz(linha, m2.coluna);
      Celula i2 = m2.inicio;
      Celula mi = multiplicacao.inicio;

      for (Celula i = inicio; i != null; i = i.inf, i2 = i2.prox, mi = mi.inf) {
        Celula j2 = i2;
        Celula mj = mi;

        for (Celula j = i; j != null; j = j.prox, j2 = j2.inf, mj = mj.prox) {
          mj.elemento += j.elemento * j2.elemento;
        }
      }

    }

    return multiplicacao;
  }

  public Matriz multiplicacao(Matriz m) 
    {
      Matriz multiplicacao = null;
      if(this.coluna == m.linha)
      {
        multiplicacao = new Matriz(this.linha, m.coluna);
        Celula i = multiplicacao.inicio;
        for(int l = 0; i != null; i = i.inf, l++)
        {
            Celula i2 = i;
            for(int c = 0; i2 != null; i2 = i2.prox, c++)
            {
                i2.elemento = 0;
                for(int x = 0; x < linha; x++)
                {
                    i2.elemento += getElemento(l,x) * m.getElemento(x,c);
                }
            }
        }
      }
      return multiplicacao;
    }

  public boolean isQuadrada() {
    return (this.linha == this.coluna);
  }

  public void diagonalPrincipal() {
    if (isQuadrada()) {
      for (Celula a = inicio; a != null; a = a.inf) {
        System.out.printf("%d ",a.elemento);
        if (a.prox != null)
          a = a.prox;
        
      }
      System.out.println("");

    }
  }

  public void diagonalSecundaria() {
    if (isQuadrada()) {
      Celula a = inicio;
      for (; a.prox != null; a = a.prox);
      System.out.printf("%d ",a.elemento);

      for (a = a.ant; a != null; a = a.ant) {
        if (a.inf != null)
          a = a.inf;
        System.out.printf("%d ",a.elemento);
      }
      System.out.println("");

    }
  }
}

class matrixflex {
  public static void main(String[] args) {
    int casos = MyIO.readInt()*2;
    Matriz matrizes[] = new Matriz[casos];

    for(int a = 0; casos > a; ++a){
      int linha = MyIO.readInt();
      int col = MyIO.readInt();
      matrizes[a] = new Matriz(linha,col);

      int[] valores = new int[col*linha];

      for(int x = 0; x < linha*col; x++){
        valores[x] = MyIO.readInt();
      }

      matrizes[a].gerar(valores);


    }
    for(int c = 0; c < casos; c+=2){
      matrizes[c].diagonalPrincipal();
      matrizes[c].diagonalSecundaria();
      Matriz soma = matrizes[c].somar(matrizes[c+1]);
      soma.mostrar();
      Matriz multiplicacao = matrizes[c].multiplicacao(matrizes[c+1]);
      multiplicacao.mostrar();
    }
  }
}