 class LAB04 {
   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static void Paranteses (String s){
      boolean certo = true;
      int counter = 0;
      for(int i = 0; i <= s.length()-1; i++){
         if(s.charAt(i) == ')' && counter <= 0){
            certo = false;
            i = s.length()-1;
         }
         else if(s.charAt(i) == '(' ) counter++;
         else if(s.charAt(i) == ')' ) counter--;
      }
      if(counter != 0) certo = false;
      MyIO.println(certo ? "correto" : "incorreto");
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
         Paranteses(entrada[i]);
      }
   }
}
