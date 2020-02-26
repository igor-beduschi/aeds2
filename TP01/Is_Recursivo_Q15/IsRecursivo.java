import java.io.*;
public class IsRecursivo{

    //Verificar se a palavra eh FIM
     public static boolean isFim(String s){
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Verifica se a frase tem somente reais

    public static boolean Real(String texto,int counter, int ViPo){
        boolean real= true;

        if(counter >= texto.length()){
            real = true;
        }
        else if(texto.charAt(counter) == '.' || texto.charAt(counter) == ','){
            ViPo++;
            if(ViPo > 1){
                real = false;
            }
            else{
                real = Real(texto, counter+1, ViPo);
            }
        }
        else if(texto.charAt(counter) > '9' ||'0' > texto.charAt(counter)){
            real = false;
        }       
        else{
            real = Real(texto, counter+1, ViPo);
        }
        return real;
        
    }

    public static boolean ChamarReal(String Texto){
        boolean real = Real(Texto, 0, 0);
        return real;
    }


    //Verifica se a frase tem somente inteiros
    public static boolean Inteiro(String texto, int counter){
        boolean inter = false;
        
        if(counter >= texto.length()){
            inter = true;
        }
        else if( ! (texto.charAt(counter) <= '9' && texto.charAt(counter) >= '0')){
            inter = false;
        }
        else{
            inter = Inteiro(texto,1+counter);
        }

        return inter;
    }

    public static boolean ChamarInteiro(String Texto){
        return Inteiro(Texto, 0);
    }

    //Verifica se a frase tem somente consoantes
    public static boolean Consoantes(String texto, int counter) {
        boolean consoante;
        if(counter >= texto.length()){
            consoante = true;
        }
        else if(! ( texto.charAt(counter) == 'a' || texto.charAt(counter) == 'e' ||
        texto.charAt(counter) == 'i' || texto.charAt(counter) == 'o' || 
        texto.charAt(counter) == 'u')){
            consoante = false;
           
        }
        else{
            consoante = Consoantes(texto,counter+1);
        }
        
        return consoante;
    }

    public static boolean ChamarConsoantes(String Texto){
        boolean consoante = Consoantes(Texto, 0);
        return consoante;
    }

    //Verifica se a frase tem somente vogais
    public static boolean Vogais(String texto, int counter) {
        boolean vogal;
 
        if(counter >= texto.length()){
            vogal = true;
        }
        else if( ! ( texto.charAt(counter) == 'a' || texto.charAt(counter) == 'e' ||
         texto.charAt(counter) == 'i' || texto.charAt(counter) == 'o' || 
         texto.charAt(counter) == 'u' )){
            vogal = false;
        }
        else{
            vogal = Vogais(texto,counter+1);
        }

        return vogal;
        
    }   

    public static boolean ChamarVogais(String Texto){
        boolean vogal = Vogais(Texto, 0);
        return vogal;
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
            System.out.printf( ChamarVogais(entrada[i]) ? "SIM" : "NAO");
            System.out.printf( ChamarConsoantes(entrada[i]) ? " SIM" : " NAO");
            System.out.printf( ChamarInteiro(entrada[i]) ? " SIM" : " NAO");
            System.out.printf( ChamarReal(entrada[i]) ? " SIM\n" : " NAO\n");
        }

    }
}
    

