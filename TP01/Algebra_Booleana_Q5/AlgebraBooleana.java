import java.io.*;

public class AlgebraBooleana{

    public static boolean isFim(String s){
        return (s.charAt(0) == '0');
    }

    public static int or(int[] y, int z){
        int i = 0, resp = 1;
        for (; i < z; i++) {
           if(y[i] == 1)i = z;
        }
        if (i == z) {
            resp = 0;
        }
        return(resp);
    }

    public static int not(int i){
        int resp = 0;
        if(i == 0)return 1;
        
        return(resp);
     }

    public static int and(int[] y, int z){
        int i = 0, resp = 0;
        for ( ; i < z; i++) {
           if(y[i] == 0)i = z;
        }
        if (i == z) {
           resp = 1;
        }
        return(resp);
    }

    public static void algbool(String s){
        int tamanho = s.length();
        int A = 9, B = 9, C = 9, x = 0, n = 0;
        int[] array = new int[1000];
  
        //Verificar numero de variaveis
        if(s.charAt(0) == 2){
           A = s.charAt(2);
           B = s.charAt(4);
           x = 4;
        }else{
           A = s.charAt(2);
           B = s.charAt(4);
           C = s.charAt(6);
           x = 6;
        }
        
        for( ; x < tamanho; x++){
            if (s.charAt(x) == ')') {
                for (int y = x; y > 0 ; y--) {
                    if (s.charAt(y) == '(') {
                        switch(s.charAt(y-1)){
                        case 't':
                            array[0] = not(array[n-1]);
                            break;
                        case'd':                     
                            array[0] = and(array, n);
                            break;
                        case'r':
                            array[0] = or(array, n);
                            break;
                        }
                        n = 0;
                        s = s.substring(0, y) + array[0] + " " + s.substring(y+2, tamanho);
                        y = 0;
                    }else{
                        switch(s.charAt(y)){
                        case 'A':
                            array[n] = (int)A-48;
                            n++;
                            s = s.substring(0, y) + " " + s.substring(y+1, tamanho);
                            break;
                        case'B':
                            array[n] = (int)B-48;
                            n++;
                            s = s.substring(0, y) + " " + s.substring(y+1, tamanho);
                            break;
                        case'C':
                            array[n] = (int)C-48;
                            n++;
                            s = s.substring(0, y) + " " + s.substring(y+1, tamanho);
                            break;
                        case'1':
                            array[n] = 1;
                            n++;
                            s = s.substring(0, y) + " " + s.substring(y+1, tamanho);
                            break;
                        case'0':
                            array[n] = 0;
                            n++;
                            s = s.substring(0, y) + " " + s.substring(y+1, tamanho);
                            break;
                        }
                    }
                }
           }   
        }
        MyIO.println(array[0] == 1 ? "1" : "0");

  }

    public static void main(String args[]) throws IOException{

        String[] s = new String[1000];
        int nums = 0;

        do {
            s[nums] = MyIO.readLine();
        } while (isFim(s[nums++]) == false);
        nums--; 

        
        for(int i = 0; i < nums; i++){
            algbool(s[i]);
        }
    }

}