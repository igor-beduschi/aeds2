import java.io.*;
import java.util.Scanner;

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

class Lista {
    private Personagens array[];
    private int n;
  
    public Lista () {
       this(6);
    }
  
    public Lista (int tamanho){
       array = new Personagens[tamanho];
       n = 0;
    }
  
    public void inserirInicio(Personagens personagem){
       if(n >= array.length){
         System.out.println("Erro ao inserir!");
       } 
  
       for(int i = n; i > 0; i--){
          array[i] = array[i-1];
       }
  
       array[0] = personagem;
       n++;
    }
  
    public void inserirFim(Personagens personagem){
       if(n >= array.length){
          System.out.println("Erro ao inserir!");
       }
       array[n] = personagem;
       n++;
    }
  
  
    public void inserir(Personagens personagem, int pos){
       if(n >= array.length || pos < 0 || pos > n){
         System.out.println("Erro ao inserir!");
       }
       for(int i = n; i > pos; i--){
          array[i] = array[i-1];
       }
       array[pos] = personagem;
       n++;
    }
  
    public String removerInicio(){
       if (n == 0) {
          System.out.println("Erro ao remover!");
       }
       String resp = array[0].getNome();
       n--;
       for(int i = 0; i < n; i++){
          array[i] = array[i+1];
       }
       return resp;
    }
  
    public String removerFim(){
       if (n == 0) {
          System.out.println("Erro ao remover!");
       }  
       return array[--n].getNome();
    }
  
    public String remover(int pos){
       if (n == 0 || pos < 0 || pos >= n) {
         System.out.println("Erro ao remover!");
       }
       String resp = array[pos].getNome();
       n--;
  
       for(int i = pos; i < n; i++){
          array[i] = array[i+1];
       }
       return resp;
    }
  
    public void mostrar (){
       for(int i = 0; i < n; i++){
          System.out.print("["+i+"] ");
          array[i].Printar();
       }
    }  
}

class ListaJava {
       
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

    public static void main (String[] args){
        String[] entrada = new String[1000];
        Lista lista = new Lista(1000);
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

        for(int z = Integer.parseInt(MyIO.readLine()) ;  z > 0 ; z--){
            String Comando = MyIO.readLine();
            if(Comando.charAt(0) == 'I'){
                personagem[++i] = new Personagens();
                if(Comando.charAt(1) == 'I'){
                    personagem[i].lerArquivo(Comando.substring(3,Comando.length()));
                    lista.inserirInicio(personagem[i]);
                }
                else if(Comando.charAt(1) == 'F'){
                    personagem[i].lerArquivo(Comando.substring(3,Comando.length()));
                    lista.inserirFim(personagem[i]);
                }
                else if(Comando.charAt(1) == '*'){
                    personagem[i].lerArquivo(Comando.substring(6,Comando.length()));
                    lista.inserir(personagem[i], Integer.parseInt(Comando.substring(3,5)));
                }
            }
            else if(Comando.charAt(0) == 'R'){
                if(Comando.charAt(1) == 'I'){
                    System.out.println("(R) "+lista.removerInicio());
                }
                else if(Comando.charAt(0) == 'R' && Comando.charAt(1) == 'F'){
                    System.out.println("(R) "+lista.removerFim());
                }
                else if(Comando.charAt(0) == 'R' && Comando.charAt(1) == '*'){
                    System.out.println("(R) "+lista.remover(Integer.parseInt(Comando.substring(3,5))));
                }
            }
        }
        lista.mostrar();
    }
}
