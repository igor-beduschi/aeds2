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

class No {
  public char elemento;
  public int tamanho = 255;
  public No[] prox;
  public boolean folha;
  
  public No (){
    this(' ');
  }

  public No (char elemento){
    this.elemento = elemento;
    prox = new No [tamanho];
    for (int i = 0; i < tamanho; i++) prox[i] = null;
    folha = false;
  }

  public static int hash (char x){
    return (int)x;
  }
}

class ArvoreTrie {
  private No raiz;
  public Comparacoes stats;

  public ArvoreTrie(){
    raiz = new No();
    stats = new Comparacoes();
  }

  public void inserir(String s) throws Exception {
    inserir(s, raiz, 0);
  }

  private void inserir(String s, No no, int i) throws Exception {
    //System.out.print("\nEM NO(" + no.elemento + ") (" + i + ")");
    if(no.prox[s.charAt(i)] == null){
     // System.out.print("--> criando filho(" + s.charAt(i) + ")");
     stats.incrementarComparacoes();
      no.prox[s.charAt(i)] = new No(s.charAt(i));
      if(i == s.length() - 1){
        // System.out.print("(folha)");
        no.prox[s.charAt(i)].folha = true;
        stats.incrementarComparacoes();
      }
      else{
        stats.incrementarComparacoes();
        inserir(s, no.prox[s.charAt(i)], i + 1);
      }
    } 
    else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1){
      inserir(s, no.prox[s.charAt(i)], i + 1);
      stats.incrementarComparacoes(3);
    } 
    else {
      stats.incrementarComparacoes(2);
      throw new Exception("Erro ao inserir!");
    }
    
  }


  public boolean pesquisar(String s) throws Exception {
    return pesquisar(s, raiz, 0);
  }

  public boolean pesquisar(String s, No no, int i) throws Exception {
    boolean resp;
    if(no.prox[s.charAt(i)] == null){
      stats.incrementarComparacoes();
      resp = false;
    } else if(i == s.length() - 1){
      stats.incrementarComparacoes(2);
      resp = (no.prox[s.charAt(i)].folha == true);
    } else if(i < s.length() - 1 ){
      stats.incrementarComparacoes(3);
      resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
    } else {
      stats.incrementarComparacoes(3);
      throw new Exception("Erro ao pesquisar!");
    }
    return resp;
  }


  public void merge(ArvoreTrie a2)throws Exception{
    merge("", a2.raiz);
  }

  public void merge(String s, No no)throws Exception{
    if(no.folha == true){
      stats.incrementarComparacoes();
      s += no.elemento;
      s = s.substring(1, s.length());
      inserir(s);
    }
    else {
      stats.incrementarComparacoes();
    for(int i = 0; i < no.prox.length; i++){
      stats.incrementarComparacoes();
      if(no.prox[i] != null){
        // System.out.println("ESTOU EM (" + no.elemento + ") E VOU PARA (" + no.prox[i].elemento + ")");
        merge(s + no.elemento, no.prox[i]);
      }
      stats.incrementarComparacoes();
    }
  }
}

  public int contarAs(){
    int resp = 0;
    if(raiz != null){
      resp = contarAs(raiz);
    }
    return resp;
  }

  public int contarAs(No no) {
    int resp = (no.elemento == 'A') ? 1 : 0;

    if(no.folha == false){
      for(int i = 0; i < no.prox.length; i++){
        if(no.prox[i] != null){
          resp += contarAs(no.prox[i]);
        }
      }
    }
    return resp;
  }
}


public class trie {
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
    ArvoreTrie arvore1 = new ArvoreTrie();
    ArvoreTrie arvore2 = new ArvoreTrie();
    Personagens personagem[] = new Personagens[1000];
    int numEntrada = 0;

  // ======== Arvore 1
    do {
      entrada[numEntrada] = MyIO.readLine();
      entrada[numEntrada] = ISO88591toUTF8(entrada[numEntrada]);
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;

    int i = 0;
    for(; i < numEntrada; i++){
      personagem[i] = new Personagens();
      personagem[i].lerArquivo(entrada[i]);
      arvore1.inserir(personagem[i].getNome());
    }

  // ======== Arvore 2
  do {
      entrada[numEntrada] = MyIO.readLine();
      entrada[numEntrada] = ISO88591toUTF8(entrada[numEntrada]);
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;

    for(; i < numEntrada; i++){
      personagem[i] = new Personagens();
      personagem[i].lerArquivo(entrada[i]);
      arvore2.inserir(personagem[i].getNome());
    }
    --i;

  // ========= merge
  arvore1.merge(arvore2);
  

  // ========= Pesquisa
  int entrada2 = 0;
  String[] Busca = new String[1000];
  do {
    Busca[entrada2] = MyIO.readLine();
    Busca[entrada2] = ISO88591toUTF8(Busca[entrada2]);
  } while (isFim(Busca[entrada2++]) == false);

  for(int x = 0; x < entrada2-1; x++){
    System.out.printf("%s ",Busca[x]);
    boolean Pesquisa = arvore1.pesquisar(Busca[x]);
    if(Pesquisa) System.out.println("SIM");
    else { 
      MyIO.setCharset("UTF-8");
      MyIO.println("N" + (char) 195 + "O");
    }
  }


  int stats = arvore1.stats.getComparacoes() + arvore2.stats.getComparacoes();
  long fim  = System.currentTimeMillis();
  FileWriter arq = new FileWriter("659318_arvoreTrie.txt");
  PrintWriter gravarArq = new PrintWriter(arq);
  gravarArq.printf("659318\t%d\t%d",fim-inicio,stats);
  arq.close();
  }
}
