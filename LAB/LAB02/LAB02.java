 class LAB02 {
   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static String Combinador (String s){
      String resp = " ";
      int i = 0;
      
      while(s.charAt(i) != ' '){
         i++;
      }
 
      for(int x = 0; x < i; x++){
         resp += s.charAt(x);
         if(i+x+1 < s.length()){
            resp += s.charAt(i+x+1);
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
         MyIO.println(Combinador(entrada[i]));
      }
   }
}
