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

class CelulaDupla {
  public Personagens elemento;
  public CelulaDupla ant;
  public CelulaDupla prox;

  public CelulaDupla() { this(null); }

  public CelulaDupla(Personagens elemento) {
    this.elemento = elemento;
    this.ant = this.prox = null;
  }
}

class ListaDupla {
  private CelulaDupla primeiro;
  private CelulaDupla ultimo;

  public ListaDupla() {
    primeiro = new CelulaDupla();
    ultimo = primeiro;
  }

  public void inserirInicio(Personagens x) {
    CelulaDupla tmp = new CelulaDupla(x);

    tmp.ant = primeiro;
    tmp.prox = primeiro.prox;
    primeiro.prox = tmp;
    if(primeiro == ultimo){
      ultimo = tmp;
    }else{
      tmp.prox.ant = tmp;
    }
    tmp = null;
  }

  public void inserirFim(Personagens x) {
    ultimo.prox = new CelulaDupla(x);
    ultimo.prox.ant = ultimo;
    ultimo = ultimo.prox;
  }

  public void removerInicio() throws Exception {
    if (primeiro == ultimo) {
      throw new Exception("Erro ao remover (vazia)!");
    }

    CelulaDupla tmp = primeiro;
    primeiro = primeiro.prox;
    tmp.prox = primeiro.ant = null;
    tmp = null;
  }

  public void removerFim() throws Exception {
    if (primeiro == ultimo) {
      throw new Exception("Erro ao remover (vazia)!");
    } 
    ultimo = ultimo.ant;
    ultimo.prox.ant = null;
    ultimo.prox = null;
  }

  public void inserir(Personagens x, int pos) throws Exception {

    int tamanho = tamanho();

    if(pos < 0 || pos > tamanho){
      throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
    } else if (pos == 0){
      inserirInicio(x);
    } else if (pos == tamanho){
      inserirFim(x);
    } else {
      CelulaDupla i = primeiro;
      for(int j = 0; j < pos; j++, i = i.prox);

      CelulaDupla tmp = new CelulaDupla(x);
      tmp.ant = i;
      tmp.prox = i.prox;
      tmp.ant.prox = tmp.prox.ant = tmp;
      tmp = i = null;
    }
  }

  public void remover(int pos) throws Exception {
    int tamanho = tamanho();

    if (primeiro == ultimo){
      throw new Exception("Erro ao remover (vazia)!");

    } else if(pos < 0 || pos >= tamanho){
      throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
    } else if (pos == 0){
      removerInicio();
    } else if (pos == tamanho - 1){
      removerFim();
    } else {
      CelulaDupla i = primeiro.prox;
      for(int j = 0; j < pos; j++, i = i.prox);

      i.ant.prox = i.prox;
      i.prox.ant = i.ant;
      i.prox = i.ant = null;
      i = null;
    }
  }

  public int diferenca(String um, String dois){
    int tamanho1 = um.length();
    int tamanho2 = dois.length();
    int resp = 0;
    if(tamanho1 <= tamanho2){
      for(int a = 0; tamanho1 > a; a++){
        if(um.charAt(a) > dois.charAt(a)){
          resp = 1;
          a = tamanho1;
        } 
        else if(um.charAt(a) < dois.charAt(a)){
          resp = -1;
          a = tamanho1;
        }
      }
    }
    else{
      for(int a = 0; tamanho2 > a; a++){
        if(um.charAt(a) > dois.charAt(a)){
          resp = 1;
          a = tamanho2;
        } 
        else if(um.charAt(a) < dois.charAt(a)){
          resp = -1;
          a = tamanho2;
        }
      }
    }
    return resp;
  }

  public boolean Maior(Personagens a,Personagens b){
    boolean resp = false;
    if(a.getCorDoCabelo().compareTo(b.getCorDoCabelo()) == 0 && a.getNome().compareTo(b.getNome()) > 0) resp = true;
    if(a.getCorDoCabelo().compareTo(b.getCorDoCabelo()) > 0) resp = true;
    return resp;
  }

  public void mostrar() {
    for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
      i.elemento.Printar();
    }
  }

  public int tamanho() {
    int tamanho = 0; 
    for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
    return tamanho;
  }

  CelulaDupla celulaPos(int x)
  {
    CelulaDupla aux;
    int i = 0;
    for(aux = primeiro; i <= x; aux = aux.prox)i++;
    return aux;
  }

  void swap(int a, int b)
  {
    Personagens tmp = celulaPos(a).elemento;
    celulaPos(a).elemento = celulaPos(b).elemento;
    celulaPos(b).elemento = tmp;
  }

  void quicksortRec (int esq, int dir) 
  {
    int i = esq, j = dir;
    Personagens pivo = celulaPos((dir+esq)/2).elemento;

    while (i <= j) 
    {
      CelulaDupla aux = celulaPos(i);
      while(Maior(pivo,aux.elemento))
      {
        aux = aux.prox;
        i++;
      }
      aux = celulaPos(j);
      while(Maior(aux.elemento, pivo))
      {
        aux = aux.ant;
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
    quicksortRec(0, tamanho()-1);
  }
}

class quicksort {
       
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
    String[] entrada = new String[1000];
    ListaDupla lista = new ListaDupla();
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
      lista.inserirFim(personagem[i]);
    }
    --i;
    lista.quicksort();
    lista.mostrar();
  }
}
