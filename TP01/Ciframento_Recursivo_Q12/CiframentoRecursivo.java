 class CiframentoRecursivo {

   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static void Cesar (String s, int i){
      if(i < s.length()){
         MyIO.print((char)(s.charAt(i) + 3));
         Cesar(s,i+1);
      }
   }

   public static void Cesar (String s){
      Cesar(s,0);
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
      Cesar(entrada[i]);
      System.out.printf("\n");
      }
   }
}
