import java.io.*;
public class ls{

    //Verificar se a palavra eh FIM
     public static boolean isFim(String s){
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Verificar se a frase tem somente numeros reais
    //verifica o resultado do metodo anterior para avaliar se precisa entrar no for
    public static void Real(String texto, boolean consoante, boolean vogais, boolean inter){
        boolean real = true;
        int contador = 0;
          
        if(!inter){
            if(consoante || vogais){
                real = false;
                }
            else{
                int i, n = texto.length();
                
                for (i=0; i<n; i++) { 
                    char L = texto.charAt(i);
                    if( L != '.' && L != ','){
                        if(L > '9' ||'0' > L){
                        real = false;
                        }
                    }
                        
                    if(L == '.' || L == ','){
                        contador++;
                    }
                }  
            }
        }
        if(contador >= 2){
            real = false;
        }
        System.out.printf(real ? " SIM" : " NAO");
        
    }

    //Verificar se a frase tem somente inteiros e chama o metodo que testa se a frase só possui numeros reais passando o resultado desse metodo e dos metodos anteriores como parametro
    //verifica o resultado do metodo anterior para avaliar se precisa entrar no for
    public static void Inteiro(String texto, boolean consoante, boolean vogais){
        boolean inter = true;
        if(consoante || vogais){
            System.out.printf(" NAO");
            inter = false;
        }
        else{
            int i, n = texto.length();
 
            for (i=0; i<n; i++) { 
                char L = texto.charAt(i);
                if( L > '9' || '0' > L){
                    inter = false;
                }
            }
 
            System.out.printf(inter ? " SIM" : " NAO");
        }
        Real(texto, consoante, vogais, inter);
    }
        
    //Verificar se a frase tem somente consoantes e chama o metodo que testa se a frase só possui numeros inteiros passando o resultado desse metodo e do metodo anterior como parametro
    //verifica o resultado do metodo anterior para avaliar se precisa entrar no for
    public static void Consoantes(String texto, boolean vogal) {
        boolean consoante = true;
        if(vogal){
            System.out.printf(" NAO");
            vogal = false;
        }
        else{
            int i, n = texto.length();
 
            for (i=0; i<n; i++) { 
                char L = texto.charAt(i);
                if( ( L < 'A' || L > 'z' || L == 'a' || L == 'e' ||
                    L == 'i' || L == 'o' || L == 'u' ||
                    L == 'A' || L == 'E' || L == 'I' || L == 'O' || L == 'U') ){
                    consoante = false;
                }
            }
 
           System.out.printf(consoante ? " SIM" : " NAO");
        }
        Inteiro(texto, vogal, consoante);
    }
        

    //Verificar se a frase tem somente vogais e chama o metodo que testa se a frase só possui consoantes passando o resultado desse metodo como parametro
    public static void Vogais(String texto) {
        int i, n = texto.length();
        boolean vogal = true;
 
        for (i=0; i<n; i++) { 
            char L = texto.charAt(i);
            if( ! ( L == 'a' || L == 'e' ||
            L == 'i' || L == 'o' || L == 'u' ||
            L == 'A' || L == 'E' || L == 'I' || L == 'O' || L == 'U') ){
                vogal = false;
            }
        }
 
        System.out.printf(vogal ? "SIM" : "NAO");
        Consoantes(texto,vogal);


    }   
        


    public static void main(String args[]) throws IOException{

        String[] entrada = new String[1000];
        int numEntrada = 0;
 
        //Le a entrada padrao e chama o metodo para verificar se chegou no FIM
        do {
           entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   

        //Chama o para testar vogais metodo para todas as entradas 
        for(int i = 0; i < numEntrada; i++){
            Vogais(entrada[i]);
            System.out.printf("\n");
        }

    }
}
    

