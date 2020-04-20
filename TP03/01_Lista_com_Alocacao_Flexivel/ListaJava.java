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

class Celula {
	public Personagens elemento;
	public Celula prox; 
	
	public Celula() { this(null); }

	public Celula(Personagens elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

class Lista {
    private Celula primeiro;
	private Celula ultimo;
  
    public Lista () {
        primeiro = new Celula();
		ultimo = primeiro;
    }
  
    public void inserirInicio(Personagens x) {
		Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) ultimo = tmp;
        tmp = null;
    }
    
    public void inserirFim(Personagens x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
    }
    
    public int tamanho() {
        int tamanho = 0; 
        for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
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
             // Caminhar ate a posicao anterior a insercao
           Celula i = primeiro;
           for(int j = 0; j < pos; j++, i = i.prox);
          
           Celula tmp = new Celula(x);
           tmp.prox = i.prox;
           i.prox = tmp;
           tmp = i = null;
        }
    }
  
    public String remover(int pos) throws Exception {
        String resp;
        int tamanho = tamanho();
  
          if (primeiro == ultimo){
              throw new Exception("Erro ao remover (vazia)!");
  
        } else if(pos < 0 || pos >= tamanho){
              throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0){
           resp = removerInicio();
        } else if (pos == tamanho - 1){
           resp = removerFim();
        } else {
             // Caminhar ate a posicao anterior a insercao
           Celula i = primeiro;
           for(int j = 0; j < pos; j++, i = i.prox);
          
           Celula tmp = i.prox;
           resp = tmp.elemento.getNome();
           i.prox = tmp.prox;
           tmp.prox = null;
           i = tmp = null;
        }
        return resp;
    }
  
    public String removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

        Celula tmp = primeiro;
		primeiro = primeiro.prox;
		String resp = primeiro.elemento.getNome();
        tmp.prox = null;
        tmp = null;
		return resp;
    }
    
    public String removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      String resp = ultimo.elemento.getNome(); 
      ultimo = i; 
      i = ultimo.prox = null;
      
		return resp;
	}
  
    public void mostrar() {
        int a = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox, a++) {
            System.out.print("["+a+"] ");
			i.elemento.Printar();
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

    public static void main (String[] args)throws Exception{
        String[] entrada = new String[1000];
        Lista lista = new Lista();
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
                    personagem[i].lerArquivo(ISO88591toUTF8(Comando.substring(3,Comando.length())));
                    lista.inserirInicio(personagem[i]);
                }
                else if(Comando.charAt(1) == 'F'){
                    personagem[i].lerArquivo(ISO88591toUTF8(Comando.substring(3,Comando.length())));
                    lista.inserirFim(personagem[i]);
                }
                else if(Comando.charAt(1) == '*'){
                    personagem[i].lerArquivo(ISO88591toUTF8(Comando.substring(6,Comando.length())));
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
