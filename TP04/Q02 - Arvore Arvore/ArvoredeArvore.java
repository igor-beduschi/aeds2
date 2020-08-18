import java.io.*;
import java.util.Scanner;
import java.nio.charset.*;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";

   public static void setCharset(String charset_){
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print(){
   }

   public static void print(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(){
   }

   public static void println(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void printf(String formato, double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";

      try{
         str = readString();
      }catch(Exception e){}

      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
            }

      return resp;
   }

   public static boolean readBoolean(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }catch(Exception e){}
   }

   public static void pause(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      pause();
   }
}

class Comparacoes{
    private int comparacoes;
    private int movimentacoes;
    
    Comparacoes(){
      comparacoes = 0;
      movimentacoes = 0;
    }

    public int getComparacoes() {
      return comparacoes;
    }
    public void incrementarComparacoes(){
      comparacoes += 1;
    }
    public void incrementarComparacoes(int a){
      comparacoes += a;
    }

    public int getMovimentacoes() {
      return movimentacoes;
    }
    public void incrementarMovimentacoes(){
      movimentacoes += 1;
    }
    public void incrementarMovimentacoes(int a){
      movimentacoes += a;
    }
}

class Personagens{
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    Personagens(){
        this.nome = "";
        this.altura = 0;
        this.peso = 0.0;
        this.corDaPele = "";
        this.corDoCabelo = "";
        this.corDosOlhos = "";
        this.anoNascimento = "";
        this.genero = "";
        this.homeworld = "";
    }
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
    public void lerArquivo(String nomeArquivo){
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            linha = linha.replaceAll("\'","");

            int namePos = linha.indexOf("name");
            this.setNome(linha.substring(namePos+6,linha.indexOf(",")));

            int heightPos = linha.indexOf("height");
            String alturaLine = linha.substring(heightPos+8,linha.indexOf(",",heightPos));
            if(!alturaLine.equals("unknown")) this.altura = Integer.parseInt(alturaLine);

            int massPos = linha.indexOf("mass");
            String massLine = linha.substring(massPos+6,linha.indexOf(", hair_color",massPos)).replace(",","");
            if(!massLine.equals("unknown")) this.peso = Double.parseDouble(massLine);

            int cabeloPos = linha.indexOf("hair_color");
            this.corDoCabelo = linha.substring(cabeloPos+12,linha.indexOf(", skin_color",cabeloPos));

            int pelePos = linha.indexOf("skin_color");
            this.corDaPele = linha.substring(pelePos+12,linha.indexOf("eye_color",pelePos)-2);

            int olhoPos = linha.indexOf("eye_color");
            this.corDosOlhos = linha.substring(olhoPos+11,linha.indexOf(", birth_year",olhoPos));

            int nasciPos = linha.indexOf("birth_year");
            this.anoNascimento = linha.substring(nasciPos+12,linha.indexOf(",",nasciPos));

            int genderPos = linha.indexOf("gender");
            this.genero = linha.substring(genderPos+8,linha.indexOf(",",genderPos));

            int planetaPos = linha.indexOf("homeworld");
            this.homeworld = linha.substring(planetaPos+11,linha.indexOf(",",planetaPos));

            arq.close();
            lerArq.close();
        } catch (IOException e) {}
    }

    public void Printar(){
        System.out.printf(" ## %s ## %d ## ",this.nome,this.altura);
        if(this.peso == (long) this.peso) System.out.printf("%d ## ",(long) this.peso);
        else System.out.printf("%s ## ",this.peso);
        System.out.printf("%s ## %s ## %s ## %s ## %s ## %s ## \n",
        this.corDoCabelo,this.corDaPele,this.corDosOlhos,this.anoNascimento,this.genero,this.homeworld);
       
    }

    protected Personagens clone(){
        Personagens novo = new Personagens();
        novo.nome = this.nome;
        novo.altura = this.altura;
        novo.corDoCabelo = this.corDoCabelo;
        novo.corDaPele = this.corDaPele;
        novo.corDosOlhos = this.corDosOlhos;
        novo.anoNascimento = this.anoNascimento;
        novo.genero = this.genero;
        novo.homeworld = this.homeworld;
        return novo;
    }
}

class No2 {
  public Personagens elemento; 
  public No2 esq; 
  public No2 dir; 
  
  No2(Personagens elemento) {
    this.elemento = elemento;
    this.esq = this.dir = null;
  }

  No2(Personagens elemento, No2 esq, No2 dir) {
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

class ArvoreBinariaPersona {
  public No2 raiz2; // Raiz da arvore.
  public Comparacoes statsA2;

  public ArvoreBinariaPersona() {
    this.raiz2 = null;
    this.statsA2 = new Comparacoes();
  }

  public boolean pesquisarA2(String x) {
    return pesquisarA2(x, this.raiz2);
  }

  private boolean pesquisarA2(String x, No2 i) {
    boolean resp = false;
    if (i != null) {
      statsA2.incrementarComparacoes();
      if (x.equals(i.elemento.getNome())) {
      resp = true;
      //System.out.println(x + " # ");
      statsA2.incrementarComparacoes(2);
      }
      else{
        System.out.printf("ESQ ");
        if(pesquisarA2(x, i.esq)) resp = true;
        else{
          System.out.printf("DIR ");
          resp = pesquisarA2(x, i.dir);
        }
      statsA2.incrementarComparacoes(3);
      }
    }
    return resp;
  }

  public void inserirA2(Personagens x) throws Exception {
    raiz2 = inserirA2(x, raiz2);
  }

  public No2 inserirA2(Personagens x, No2 i) throws Exception {
    if (i == null) {
      i = new No2(x);
      //System.out.println(x.getNome() + " " + x.getAltura()%15 + " @ ");
      statsA2.incrementarComparacoes();
    } 
    else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
      i.esq = inserirA2(x, i.esq);
      statsA2.incrementarComparacoes(2);
    } 
    else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
      i.dir = inserirA2(x, i.dir);
      statsA2.incrementarComparacoes(3);
    } 
    else {
      throw new Exception("Erro ao inserir!");
    }
    return i;
  }
}


class No {
  public int elemento; // Conteudo do no.
  public No esq; // No da esquerda.
  public No dir; // No da direita.
  public ArvoreBinariaPersona arvoreD;
  

  No(int elemento) {
    this.elemento = elemento;
    this.esq = this.dir = null;
    this.arvoreD = new ArvoreBinariaPersona();
  }

  No(int elemento, No esq, No dir) {
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
    this.arvoreD = new ArvoreBinariaPersona();
  }
}

class ArvoreArvore {
  private No raiz; // Raiz da arvore.
  public Comparacoes statsA1;

  public ArvoreArvore() throws Exception{
    raiz = null;
    statsA1 = new Comparacoes();
    inserirA1(7);
    inserirA1(3);
    inserirA1(11);
    inserirA1(1);
    inserirA1(5);
    inserirA1(9);
    inserirA1(12);
    inserirA1(0);
    inserirA1(2);
    inserirA1(4);
    inserirA1(6);
    inserirA1(8);
    inserirA1(10);
    inserirA1(13);
    inserirA1(14);
  }

  public boolean pesquisar(String elemento) {
    System.out.printf("raiz ");
    return pesquisar(raiz, elemento);
  }

  private boolean pesquisar(No no, String x) {
    boolean resp;
    boolean resp2 = false;
    if (no == null) { 
      resp = false;
      statsA1.incrementarComparacoes();
    } 
    else{
      resp = no.arvoreD.pesquisarA2(x); 

      if(!resp){
        System.out.printf("esq ");
        resp = pesquisar(no.esq, x);
        if(!resp){
          System.out.printf("dir ");
          resp2 = pesquisar(no.dir, x);
        }
      }
      statsA1.incrementarComparacoes(no.arvoreD.statsA2.getComparacoes());
      statsA1.incrementarComparacoes();
    }
    if(resp2) resp = true;
    return resp;
  }

//====== inserir na Arvore 1 os numeros de idade 
  public void inserirA1(int x) throws Exception {
    raiz = inserirA1(x, raiz);
  }

  private No inserirA1(int x, No i) throws Exception {
    if (i == null) {
        i = new No(x);
        statsA1.incrementarComparacoes();
      } else if (x < i.elemento) {
        i.esq = inserirA1(x, i.esq);
        statsA1.incrementarComparacoes(2);
      } else if (x > i.elemento) {
        i.dir = inserirA1(x, i.dir);
        statsA1.incrementarComparacoes(3);
      } else {
        throw new Exception("Erro ao inserir!");
    }
    return i;
  }

//====== inserir na Arvore 2 os personagens
  public void inserirPersona(Personagens x) throws Exception {
    inserirPersona(x, raiz);
  }

  private No inserirPersona(Personagens x, No i) throws Exception {
    if (i.elemento == x.getAltura() % 15) {
      statsA1.incrementarComparacoes();
      //System.out.println(x.getNome() + " " + x.getAltura()%15 + " ! ");
      i.arvoreD.inserirA2(x);
    }
    else if ((x.getAltura() % 15) < i.elemento) {
      statsA1.incrementarComparacoes(2);
      i.esq = inserirPersona(x, i.esq);
    }
    else if(x.getAltura() % 15 > i.elemento) {
      statsA1.incrementarComparacoes(3);
      i.dir = inserirPersona(x, i.dir);
    } 
    else {
      throw new Exception("Erro ao inserir!");
    }
    return i;
  }

}



public class ArvoredeArvore {
  public static boolean isFim(String s){
    return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static String ISO88591toUTF8(String strISO){
    try{
      byte[] isoBytes = strISO.getBytes("ISO-8859-1");
      return new String(isoBytes, "UTF-8");
    } catch (IOException e) {}
    return strISO;
  }

  public static void main (String[] args)throws Exception{
    long inicio = System.currentTimeMillis();
    String[] entrada = new String[1000];
    ArvoreArvore arvore = new ArvoreArvore();
    Personagens personagem[] = new Personagens[1000];
    int numEntrada = 0;


    do {
      entrada[numEntrada] = MyIO.readLine();
      entrada[numEntrada] = ISO88591toUTF8(entrada[numEntrada]);
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;

    int i = 0;
    for(; i < numEntrada; i++){
      personagem[i] = new Personagens();
      personagem[i].lerArquivo(entrada[i]);
      arvore.inserirPersona(personagem[i]);
    }
    --i;

    int entrada2 = 0;
    String[] Busca = new String[1000];
    do {
      Busca[entrada2] = MyIO.readLine();
      Busca[entrada2] = ISO88591toUTF8(Busca[entrada2]);
    } while (isFim(Busca[entrada2++]) == false);

    for(int x = 0; x < entrada2-1; x++){
      System.out.printf("%s ",Busca[x]);
      boolean Pesquisa = arvore.pesquisar(Busca[x]);
      if(Pesquisa) System.out.println("SIM");
      else { 
        MyIO.setCharset("UTF-8");
        MyIO.println("N" + (char) 195 + "O");
      }
    }

    long fim  = System.currentTimeMillis();
    FileWriter arq = new FileWriter("659318_arvoreArvore.txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.printf("659318\t%d\t%d",fim-inicio,arvore.statsA1.getComparacoes());
    arq.close();
  }
}
