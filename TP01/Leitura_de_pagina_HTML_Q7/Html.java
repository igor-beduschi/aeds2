import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
 
public class Html{

    //Verificar se a palavra eh FIM
    public static boolean isFim(String s){
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Metodo que testa se eh uma tag do tipo br e retorna um booleano
    public static boolean BR(String html, int x){
        return (html.charAt(x) == '<' && html.charAt(x+1) == 'b' && html.charAt(x+2) == 'r' && html.charAt(x+3) == '>');
    }

     //Metodo que testa se eh uma tag do tipo table e retorna um booleano
    public static boolean TABLE(String html, int x){
        return (html.charAt(x) == '<' && html.charAt(x+1) == 't' && html.charAt(x+2) == 'a' && html.charAt(x+3) == 'b' && html.charAt(x+4) == 'l' && html.charAt(x+5) == 'e' && html.charAt(x+6) == '>');
    }

    //Metodo que conta as vogais, consoantes e tags br e table para exibir na tela
    public static void Contador(String html, String nome){

        int tamanho = html.length();
        int a = 0, e = 0, i = 0, o = 0, u = 0, aAgudo = 0, eAgudo = 0, iAgudo = 0, oAgudo = 0, uAgudo = 0;
        int aGrave = 0, eGrave= 0, iGrave = 0, oGrave = 0, uGrave = 0, aTil = 0, oTil = 0;
        int aCircunflexo = 0, eCircunflexo = 0, iCircunflexo = 0, oCircunflexo = 0, uCircunflexo = 0;
        int consoante = 0, br = 0, table = 0;
        
        for(int x = 0; x < tamanho; x++){
            char L = html.charAt(x);
            boolean isTable = TABLE(html,x);
            boolean isBr = BR(html,x);
            if(isTable){
                table++;
                x += 6;
            }
            if(isBr){
                br++;
                x += 3;
            }
            if(isBr == false && isTable == false){
                 //Contar o numero de vogais
                 switch(L){
                    case 'a':
                        a++;
                    break;
                    case 'e':
                        e++;
                    break;
                    case 'i':
                        i++;
                    break;
                    case 'o':
                        o++;
                    break;
                    case 'u':
                        u++;
                    break;
                    case 'á':
                        aAgudo++;
                    break;
                    case 'é':
                        eAgudo++;
                    break;
                    case 'í':
                        iAgudo++;
                    break;
                    case 'ú':
                        uAgudo++;
                    break;
                    case 'ó':
                        oAgudo++;
                    break;
                    case 'à':
                        aGrave++;
                    break;
                    case 'è':
                        eGrave++;
                    break;
                    case 'ì':
                        iGrave++;
                    break;
                    case 'ò':
                        oGrave++;
                    break;
                    case 'ù':
                        uGrave++;
                    break;
                    case 'ã':
                        aTil++;
                    break;
                    case 'õ':
                        oTil++;
                    break;
                    case 'â':
                        aCircunflexo++;
                    break;
                    case 'ê':
                        eCircunflexo++;
                    break;
                    case 'î':
                        iCircunflexo++;
                    break;
                    case 'ô':
                        oCircunflexo++;
                    break;
                    case 'û':
                        uCircunflexo++;
                    break;
                    default:
                        if(L > 'a' && 'z' >= L){
                            consoante++;
                        }
                }

            }

        }

        System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í(%d) ó(%d) ú(%d) à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) consoante(%d) <br>(%d) <table>(%d) %s", 
        a,e,i,o,u,aAgudo,eAgudo,iAgudo,oAgudo,uAgudo,aGrave,eGrave,iGrave,oGrave,uGrave,aTil,oTil,aCircunflexo,eCircunflexo,iCircunflexo,oCircunflexo,uCircunflexo,consoante,br,table,nome
        );
    }

    public static void PegarHtml(String nome, String link){
        String line = "";
        String resp = "";

        try {
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            line = br.readLine();
            while (line != null) {
                    resp += line;
                    line = br.readLine();
            }
            br.close();
        } catch (MalformedURLException excecao) {
            excecao.printStackTrace();
        } catch (IOException excecao) {
            excecao.printStackTrace();
        }
        
        Contador(resp,nome);
    }

    public static void main(String[] args) throws Exception {
        String[] nome = new String[1000];
        String[] link = new String[1000];
        int numEntrada = 0;
        MyIO.setCharset("ISO-8859-1");
    
        //Le a entrada padrao e chama o metodo para verificar se chegou no FIM
        do {
            nome[numEntrada] = MyIO.readLine();
            if(isFim(nome[numEntrada]) == false){
                link[numEntrada] = MyIO.readLine();
            }
        } while (isFim(nome[numEntrada++]) == false);
        numEntrada--;   

        for(int x = 0; x < numEntrada; x++ ) {
            PegarHtml(nome[x],link[x]);
            System.out.printf("\n");
        }
    }
}