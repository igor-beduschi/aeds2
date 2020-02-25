import java.io.*;
public class Arquivo{

    public static void main(String args[]) throws IOException{
  
        Arq.openWrite("Arquivo.txt");
        
        int total = MyIO.readInt();

        RandomAccessFile arq = new RandomAccessFile("Arquivo.txt", "rw");

        //escrever no Arquivo.txt o que foi recebido pela entrada padrao
        for(int x = 0; x < total; x++)
        {
            arq.writeDouble(MyIO.readDouble());
        }

        arq.close();

        RandomAccessFile raf = new RandomAccessFile("Arquivo.txt", "r");
        
        double valor;
        
        //printar na tela os numeros atraves do metodo seek
        for(int y=0; y < total; y++) {
            raf.seek(raf.length() - (y + 1) * 8);
            valor = raf.readDouble();
            
            if (valor == (int)valor) {
               MyIO.println((int)valor);
            }
               
            else {
               MyIO.println(valor);
            }
         }
        raf.close();
      }
  }
    

