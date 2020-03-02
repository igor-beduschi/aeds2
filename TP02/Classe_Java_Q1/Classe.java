import java.io.*;
import java.util.Scanner;

class Classe {

    public class Personagens{
        private String nome;
        private int altura;
        private double peso;
        private String corDoCabelo;
        private String corDaPele;
        private String corDosOlhos;
        private String anoNascimento;
        private String genero;
        private String homeworld;

        public String getNome() {
            return this.nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getAltura() {
            return this.altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public double getPeso() {
            return this.peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public String getCorDoCabelo() {
            return this.corDoCabelo;
        }

        public void setCorDoCabelo(String corDoCabelo) {
            this.corDoCabelo = corDoCabelo;
        }

        public String getCorDaPele() {
            return this.corDaPele;
        }

        public void setCorDaPele(String corDaPele) {
            this.corDaPele = corDaPele;
        }

        public String getCorDosOlhos() {
            return this.corDosOlhos;
        }

        public void setCorDosOlhos(String corDosOlhos) {
            this.corDosOlhos = corDosOlhos;
        }

        public String getAnoNascimento() {
            return this.anoNascimento;
        }

        public void setAnoNascimento(String anoNascimento) {
            this.anoNascimento = anoNascimento;
        }

        public String getGenero() {
            return this.genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getHomeworld() {
            return this.homeworld;
        }

        public void setHomeworld(String homeworld) {
            this.homeworld = homeworld;
        }

    }
}

public void lerTime()throws Exception
{
    FileReader arq = new FileReader(this.nomeArquivo);
    BufferedReader br = new BufferedReader(arq);
    String line = "";
    line = br.readLine();
    String html = "";
    while(!line.contains("vcard"))
    {
        line = br.readLine();
    }
    br.close();
    html += line;
    html = html.substring(html.indexOf("Full name"));

    setPaginaTam( tamanho() );
    System.out.println(fullname(html)+" ## "+nickname(html)+" ## "+founded(html)+" ## "+ground(html)+" ## "+capacity(html)+" ## "+coach(html)+" ## "+league(html)+" ## "+this.nomeArquivo+" ## "+this.paginaTam+" ## ");
}

public static boolean isFim(String s){
    return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
}

public static void main (String[] args){
   String[] entrada = new String[1000];
   int numEntrada = 0;
   //Leitura da entrada padrao
   do {
     entrada[numEntrada] = MyIO.readLine();
   } while (isFim(entrada[numEntrada++]) == false);
   numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
   //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
   for(int i = 0; i < numEntrada; i++){
     MyIO.println(entrada[i]);
   }
}

