import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;
 
   public Celula(){
      this(0, null, null, null, null);
   }
 
   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }
 
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;
  
    public Matriz (){
       this(3, 3);
    }
  
    public Matriz (int linha, int coluna){
       this.linha = linha;
       this.coluna = coluna;
        
       Celula inicio = new Celula();
       inicio.dir = new Celula();
       inicio.dir.esq = inicio;
       Celula i = inicio.dir;

       for(int col = 2; col < this.coluna; col += 1){
           i.dir = new Celula();
           i.dir.esq = i;
           i = i.dir;
       }

       Celula tmp = inicio;
       i = tmp;


       for(int line = 1; line < this.linha; line += 1){
           Celula j = new Celula();
           i.inf = j;
           j.sup = i;

           for(int col = 1; col < this.coluna; col += 1){
               i = i.dir;
               j.dir = new Celula();
               j.dir.esq = j;
               j = j.dir;
               j.sup = i;
               i.inf = j;
           }
           tmp = tmp.inf;
           i = tmp;
       }
    }

    public void inserir(int[] array){
        int z =0;
        if(inicio == null){
            inicio.elemento = array[z];
        }
        for(Celula i = inicio ; i != null; i = i.dir, z++){
            i.elemento = array[z];
         }
    }

    public void mostrarDiagonalPrincipal (){
        if(isQuadrada() == true){
            Celula i = inicio;
           for(; i != null; i = i.inf.dir){
              System.out.println(i.elemento);
           }
        }
     }

     public void mostrarDiagonalSecundaria (){
        if(isQuadrada() == true){
            Celula i = inicio;
            for(; i != null; i = i.dir){
            }
            for(; i != null; i = i.inf.esq){
                System.out.println(i.elemento);
            }

        }
     }

  
    public Matriz soma (Matriz m) {
       Matriz resp = null;
  
       if(this.linha == m.linha && this.coluna == m.coluna){
          //...
       }
  
       return resp;
    }
  
    public Matriz multiplicacao (Matriz m) {
       Matriz resp = null;
  
      // if(){
         
       //}
  
       return resp;
    }
  
    public boolean isQuadrada(){
       return (this.linha == this.coluna);
    }
  


  
  /*  public void mostrar(){
       for(Celula i = inicio; i != null; i = i.prox){
          
        }  */
 }

public class MatrizFlex
{

    public static void main(String []agrs)throws Exception{
        int total = MyIO.readInt();
        for(int w = 0; w < total; w++){
            int m1colunas = 0, m2colunas = 0, m1linhas = 0, m2linhas = 0;
            m1linhas = MyIO.readInt();
            m1colunas = MyIO.readInt();
            System.out.println(m1linhas);
            System.out.println(m1colunas);

            Matriz m1 = new Matriz(m1linhas, m1colunas);

            for(int j = 0;j<m1linhas;j++){
				String valoresDaLinha = MyIO.readLine();
                String [] valorCortado = valoresDaLinha.split(" ");
                int array[] = new int[m1colunas];
                for(int l = 0; l < m1colunas; l++){
                    array[l] = Integer.parseInt(valorCortado[l]);
               System.out.println(array[l]);
                }
				m1.inserir(array);
				
			}

            m2linhas = MyIO.readInt();
            m2colunas = MyIO.readInt();
           System.out.println(m2linhas);
         System.out.println(m2colunas);

             Matriz m2 = new Matriz(m2linhas, m2colunas);
             for(int j = 0;j<m2colunas;j++){
				String valoresDaLinha = MyIO.readLine();
				String [] valorCortado = valoresDaLinha.split(" ");
				int array[] = new int[m1colunas];
                for(int l = 0; l < m2colunas; l++){
                    array[l] = Integer.parseInt(valorCortado[l]);
                }
                
				m2.inserir(array);
			}

            if(w == 0){
                m1.mostrarDiagonalPrincipal();
                m1.mostrarDiagonalSecundaria();
            }
        
        }

    }
}