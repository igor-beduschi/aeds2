 class Palindromo_recursivo {

   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static boolean IsPalindromo (String s, int counter){
      boolean resp = true;

      if(counter >= s.length()){
          resp = true;
      }
      else if(s.charAt(counter) != s.charAt(s.length() - 1 - counter)){
          resp = false;
      }
      else{
         if(counter <= s.length()) resp = IsPalindromo(s,counter+1);
      }

      return resp;
   }

   public static boolean IsPalindromo(String s){
      return IsPalindromo(s, 0);
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
         MyIO.println(IsPalindromo(entrada[i]) ? "SIM" : "NAO");
      }
   }
}
