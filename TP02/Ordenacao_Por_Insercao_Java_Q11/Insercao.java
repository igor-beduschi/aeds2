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

class Comparacoes{
    private int comparacoes;
    
    Comparacoes(){
        comparacoes = 0;
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

}

class Lista {
    private Personagens array[];
    private int n;
    private Comparacoes contador;
  
    public Lista () {
       this(6);
      
    }
    public Lista (int tamanho){
       array = new Personagens[tamanho];
       n = 0;
       contador = new Comparacoes();
    }
  
    public int getContador(){
        return contador.getComparacoes();
    }
  
    public void inserirFim(Personagens personagem) throws Exception {
  
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       }
  
       array[n] = personagem;
       n++;
    }

    public void contain(String Palavra){
        boolean existe = false;
        for(int i = 0; i < n; i++){
            if(Palavra.equals(array[i].getNome())){
                existe = true;
                i = n;
            }
            contador.incrementarComparacoes();
        }
        System.out.println(existe? "SIM" : "NAO");
    }

    public void mostrar (){
        for(int i = 0; i < n; i++){
           System.out.print("["+i+"] ");
           array[i].Printar();
        }
    }  
    public void mostrar2 (){
        for(int i = 0; i < n; i++){
           array[i].Printar();
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

    public void insercao() {
        for (int i = 1; i < n; i++) {
            Personagens tmp = array[i];
            int j = i - 1;
       
            while ((j >= 0) && diferenca(array[j].getAnoNascimento(), tmp.getAnoNascimento()) > 0) {
               array[j + 1] = array[j];
               j--;
               contador.incrementarComparacoes();
            }
            array[j + 1] = tmp;
            contador.incrementarComparacoes();
       
        }
        contador.incrementarComparacoes(3);
        mostrar2();
    }
}  
  

class Insercao {
       
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
        Lista lista = new Lista(1000); 
        String[] entrada = new String[1000];
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
       
        lista.insercao();

        long fim  = System.currentTimeMillis();
        FileWriter arq = new FileWriter("659318_insercao.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("659318\t%d\t%d",fim-inicio,lista.getContador());

        arq.close();
    }
}
