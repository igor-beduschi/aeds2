 class LAB03 {
   public static boolean isFim(String s){
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static void Espelho (String s){
      String num[] = s.split(" ");
      int inicial = Integer.parseInt(num[0]);
      int fim = Integer.parseInt(num[1]);
 
      int i = inicial;
      for(; i <= fim; i++){
         System.out.printf("%d", i);
      }
      i--;
      for(; i >= inicial; i--){
         if(i > 9){
            String inverso = Integer.toString(i);
            for(int x = inverso.length()-1; x >= 0; x-- ){
               System.out.printf("%c",inverso.charAt(x));
            }
         }
         else System.out.printf("%d", i);
      }
      MyIO.println("");


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
         Espelho(entrada[i]);
      }
   }
}
