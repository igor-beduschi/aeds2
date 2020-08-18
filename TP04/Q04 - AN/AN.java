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

class No{
  public boolean cor;
  public Personagens elemento;
  public No esq, dir;

  public No (Personagens elemento){
    this(elemento, false, null, null);
  }
  public No (Personagens elemento, boolean cor){
    this(elemento, cor, null, null);
  }
  public No (Personagens elemento, boolean cor, No esq, No dir){
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

class Alvinegra {
  private No raiz; 
  public Comparacoes stats;

  public Alvinegra() {
    raiz = null;
    stats = new Comparacoes();
  }

  public boolean pesquisar(String elemento) {
    System.out.printf("raiz ");
    return pesquisar(elemento, raiz);
  }

  private boolean pesquisar(String elemento, No i) {
    boolean resp;
    if (i == null) {
      resp = false;
      stats.incrementarComparacoes();
    } else if (elemento.equals(i.elemento.getNome())) {
      resp = true;
      stats.incrementarComparacoes(2);
    } else if (elemento.compareTo(i.elemento.getNome()) < 0)  {
      System.out.printf("esq ");
      stats.incrementarComparacoes(3);
      resp = pesquisar(elemento, i.esq);
    } else {
      System.out.printf("dir ");
      stats.incrementarComparacoes(4);
      resp = pesquisar(elemento, i.dir);
    }
    return resp;
  }

  public void mostrarPre() {
      System.out.print("[ ");
      mostrarPre(raiz);
      System.out.println("]");
  }

  private void mostrarPre(No i) {
    if (i != null) {
      System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
      mostrarPre(i.esq); // Elementos da esquerda.
      mostrarPre(i.dir); // Elementos da direita.
    }
  }

  public void inserir(Personagens elemento) throws Exception {
    //Se a arvore estiver vazia
    if(raiz == null){
      raiz = new No(elemento, false);
    //System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");
    //Senao, se a arvore tiver um elemento 
    } 
    else if (raiz.esq == null && raiz.dir == null){
      if (raiz.elemento.getNome().compareTo(elemento.getNome()) > 0){
        raiz.esq = new No(elemento, true);
        //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
      } else {
        raiz.dir = new No(elemento, true);
        //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
      }
    //Senao, se a arvore tiver dois elementos (raiz e dir)
    } else if (raiz.esq == null){
      if(raiz.elemento.getNome().compareTo(elemento.getNome()) > 0){
        raiz.esq = new No(elemento);
        //System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
      }
      else if (raiz.dir.elemento.getNome().compareTo(elemento.getNome()) > 0){
        raiz.esq = new No(raiz.elemento);
        raiz.elemento = elemento;
        //System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
      } 
      else {
        raiz.esq = new No(raiz.elemento);
        raiz.elemento = raiz.dir.elemento;
        raiz.dir.elemento = elemento;
        //System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
      }
      raiz.esq.cor = raiz.dir.cor = false;
    //Senao, se a arvore tiver dois elementos (raiz e esq)
    } else if (raiz.dir == null){
      if(raiz.elemento.getNome().compareTo(elemento.getNome()) < 0){
        raiz.dir = new No(elemento);
        //System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
      } else if (raiz.esq.elemento.getNome().compareTo(elemento.getNome()) < 0){
        raiz.dir = new No(raiz.elemento);
        raiz.elemento = elemento;
        //System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
      } else {
        raiz.dir = new No(raiz.elemento);
        raiz.elemento = raiz.esq.elemento;
        raiz.esq.elemento = elemento;
        //System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
      }
      raiz.esq.cor = raiz.dir.cor = false;
  //Senao, a arvore tem tres ou mais elementos
    } else {
      //System.out.println("Arvore com tres ou mais elementos...");
      inserir(elemento, null, null, null, raiz);
    }
    raiz.cor = false;
  }

  private void balancear(No bisavo, No avo, No pai, No i){
    //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
    if(pai.cor == true){
      //4 tipos de reequilibrios e acoplamento
      if(pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0){ // rotacao a esquerda ou direita-esquerda
        if(i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0){
          avo = rotacaoEsq(avo);
        } else {
          avo = rotacaoDirEsq(avo);
        }
      } 
      else { // rotacao a direita ou esquerda-direita
        if(i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0){
          avo = rotacaoDir(avo);
        } else {
          avo = rotacaoEsqDir(avo);
        }
      }
      if (bisavo == null){
        raiz = avo;
      } 
      else {
        if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0){
          bisavo.esq = avo;
         } 
        else {
          bisavo.dir = avo;
        }
      }
      //reestabelecer as cores apos a rotacao
      avo.cor = false;
      avo.esq.cor = avo.dir.cor = true;
      //System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
    } //if(pai.cor == true)
  }

  private void inserir(Personagens elemento, No bisavo, No avo, No pai, No i) throws Exception {
    if (i == null) {
      if(elemento.getNome().compareTo(pai.elemento.getNome()) < 0){
        i = pai.esq = new No(elemento, true);
      } else {
        i = pai.dir = new No(elemento, true);
      }
      if(pai.cor == true){
        balancear(bisavo, avo, pai, i);
      }
    } else {
      //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
      if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
        i.cor = true;
        i.esq.cor = i.dir.cor = false;
        if(i == raiz){
          i.cor = false;
        }else if(pai.cor == true){
          balancear(bisavo, avo, pai, i);
        }
      }
      if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
        inserir(elemento, avo, pai, i, i.esq);
      } 
      else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
        inserir(elemento, avo, pai, i, i.dir);
      } 
      else {
        throw new Exception("Erro inserir (elemento repetido)!");
      }
    }
  }

  private No rotacaoDir(No no) {
    //System.out.println("Rotacao DIR(" + no.elemento + ")");
    No noEsq = no.esq;
    No noEsqDir = noEsq.dir;
    noEsq.dir = no;
    no.esq = noEsqDir;
    return noEsq;
  }

  private No rotacaoEsq(No no) {
    //System.out.println("Rotacao ESQ(" + no.elemento + ")");
    No noDir = no.dir;
    No noDirEsq = noDir.esq;

    noDir.esq = no;
    no.dir = noDirEsq;
    return noDir;
  }

  private No rotacaoDirEsq(No no) {
    no.dir = rotacaoDir(no.dir);
    return rotacaoEsq(no);
  }

  private No rotacaoEsqDir(No no) {
    no.esq = rotacaoEsq(no.esq);
    return rotacaoDir(no);
  }
}

public class AN {
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
    Alvinegra arvore = new Alvinegra();
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
      arvore.inserir(personagem[i]);
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
    FileWriter arq = new FileWriter("659318_avinegra.txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.printf("659318\t%d\t%d",fim-inicio,arvore.stats.getComparacoes());
    arq.close();
  }
}
