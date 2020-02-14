import java.util.Random;
class AlteracaoAleatoria {

   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static String Alteracao(String s, int contador) {
        int i, n = s.length();
        String resp = "";

        Random gerador = new Random();
        gerador.setSeed(4);
        
        char NovaLetra = ' ';
        char velhaLetra = ' ';
        for(int z = 0; z < contador; z++){            
            velhaLetra = (char) ('a' + Math.abs(gerador.nextInt() % 26));
            NovaLetra = (char) ('a' + Math.abs(gerador.nextInt() % 26));
        }
    
        for (i=0; i<n; i++) { 
            if(s.charAt(i) == velhaLetra){
               resp = resp + NovaLetra;
            }
            else{
             resp = resp + s.charAt(i);
            }
        }
 
      return resp;  
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
      for(int i = 0; i < numEntrada; i++){
         MyIO.println(Alteracao(entrada[i],i+1));
      }
   }
}
