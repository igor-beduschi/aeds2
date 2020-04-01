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

    public int getMov(){
        return contador.getMovimentacoes();
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
    public void mostrar2(){
        for(int i = 0; i < n; i++){
           array[i].Printar();
        }
    }  

    public boolean Maior(Personagens a,Personagens b){
        boolean resp = false;
        if(a.getAltura() == b.getAltura() && a.getNome().compareTo(b.getNome()) > 0) resp = true;
        if(a.getAltura() > b.getAltura()) resp = true;
        return resp;
    }

    public void Swap(int i, int j) {
        Personagens temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        contador.incrementarMovimentacoes(3);
     }

    public void sort()
    {
        mergeSort(array,n);
        mostrar2();
    }

    public void mergeSort(Personagens[] arranjo, int num)
    {
        if (num < 2) 
        {
            return;
        }
        contador.incrementarComparacoes();
        int meio = num / 2;
        Personagens[] l = new Personagens[meio];
        Personagens[] r = new Personagens[num - meio];
     
        for (int i = 0; i < meio; i++) 
        {
            l[i] = arranjo[i];
            contador.incrementarMovimentacoes();contador.incrementarComparacoes();
        }
        contador.incrementarComparacoes();
        for (int i = meio; i < num; i++) 
        {
            r[i - meio] = arranjo[i];
            contador.incrementarMovimentacoes();contador.incrementarComparacoes();
        }
        contador.incrementarComparacoes();
        mergeSort(l, meio);
        mergeSort(r, num - meio);
        merge(arranjo, l, r, meio, num - meio);
    }

    public void merge(Personagens[] arranjo, Personagens[] l, Personagens[] r, int left, int right) 
    {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) 
        {
            if (l[i].getHomeworld().compareTo(r[j].getHomeworld()) <= 0) 
            {
                arranjo[k++] = l[i++];
                contador.incrementarMovimentacoes();
                contador.incrementarComparacoes();
            }
            else {
                arranjo[k++] = r[j++];
                contador.incrementarMovimentacoes();
            }
            contador.incrementarComparacoes();contador.incrementarComparacoes();contador.incrementarComparacoes();
        }
        contador.incrementarComparacoes();contador.incrementarComparacoes();

        while (i < left) 
        {
            arranjo[k++] = l[i++];
            contador.incrementarMovimentacoes();
            contador.incrementarComparacoes();
        }
        contador.incrementarComparacoes();

        while (j < right) 
        {
            arranjo[k++] = r[j++];
            contador.incrementarMovimentacoes();
            contador.incrementarComparacoes();
        }
        contador.incrementarComparacoes();
    }


}  

class Merge {
       
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
       
        lista.sort();

        long fim  = System.currentTimeMillis();
        FileWriter arq = new FileWriter("659318_mergesort.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("659318\t%d\t%d\t%d",fim-inicio,lista.getContador(),lista.getMov());

        arq.close();
    }
}
