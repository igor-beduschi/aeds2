import java.util.Random;
import java.io.*;
import java.nio.charset.*;

class MyIO {

  private static BufferedReader in = new BufferedReader(
      new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
  private static String charset = "ISO-8859-1";

  public static void setCharset(String charset_) {
    charset = charset_;
    in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
  }

  public static void print() {
  }

  public static void print(int x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(double x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(String x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(boolean x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(char x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println() {
  }

  public static void println(int x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(double x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(String x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(boolean x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(char x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void printf(String formato, double x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.printf(formato, x);// "%.2f"
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static double readDouble() {
    double d = -1;
    try {
      d = Double.parseDouble(readString().trim().replace(",", "."));
    } catch (Exception e) {
    }
    return d;
  }

  public static double readDouble(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readDouble();
  }

  public static float readFloat() {
    return (float) readDouble();
  }

  public static float readFloat(String str) {
    return (float) readDouble(str);
  }

  public static int readInt() {
    int i = -1;
    try {
      i = Integer.parseInt(readString().trim());
    } catch (Exception e) {
    }
    return i;
  }

  public static int readInt(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readInt();
  }

  public static String readString() {
    String s = "";
    char tmp;
    try {
      do {
        tmp = (char) in.read();
        if (tmp != '\n' && tmp != ' ' && tmp != 13) {
          s += tmp;
        }
      } while (tmp != '\n' && tmp != ' ');
    } catch (IOException ioe) {
      System.out.println("lerPalavra: " + ioe.getMessage());
    }
    return s;
  }

  public static String readString(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readString();
  }

  public static String readLine() {
    String s = "";
    char tmp;
    try {
      do {
        tmp = (char) in.read();
        if (tmp != '\n' && tmp != 13) {
          s += tmp;
        }
      } while (tmp != '\n');
    } catch (IOException ioe) {
      System.out.println("lerPalavra: " + ioe.getMessage());
    }
    return s;
  }

  public static String readLine(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readLine();
  }

  public static char readChar() {
    char resp = ' ';
    try {
      resp = (char) in.read();
    } catch (Exception e) {
    }
    return resp;
  }

  public static char readChar(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readChar();
  }

  public static boolean readBoolean() {
    boolean resp = false;
    String str = "";

    try {
      str = readString();
    } catch (Exception e) {
    }

    if (str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || str.equals("verdadeiro")
        || str.equals("VERDADEIRO") || str.equals("V")) {
      resp = true;
    }

    return resp;
  }

  public static boolean readBoolean(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readBoolean();
  }

  public static void pause() {
    try {
      in.read();
    } catch (Exception e) {
    }
  }

  public static void pause(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    pause();
  }
}

class Celula {
  int elemento;
  Celula prox, ant, inf, sup;

  public Celula() {
    this(0);
  }

  public Celula(int elemento) {
    this.elemento = elemento;
    prox = ant = inf = sup = null;
  }
}

class Matriz {
  int linha, coluna;
  Celula inicio;
  Random gerador = new Random();

  public Matriz() {
    this(3, 3);
  }

  public Matriz(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
    int x = 0;

    Celula i, j;
    int lin, col;

    inicio = new Celula(x++);

    for (j = inicio, col = 1; col < coluna; j = j.prox, col++) {
      j.prox = new Celula(x++);
      j.prox.ant = j;
    }

    for (i = inicio, lin = 1; lin < linha; i = i.inf, lin++) {
      i.inf = new Celula(x++);
      i.inf.sup = i;
      for (j = i.inf, col = 1; col < coluna; j = j.prox, col++) {
        j.prox = new Celula();
        j.prox.ant = j;
        j.prox.sup = j.sup.prox;
        j.sup.prox.inf = j.prox;
      }
    }
  }

  public void gerar(int[] valor) {
    int a = 0;
    for (Celula i = inicio; i != null; i = i.inf) {
      for (Celula j = i; j != null; j = j.prox, a++) {
        j.elemento = valor[a];
      }
    }
  }

  public void mostrar() {
    for (Celula i = inicio; i != null; i = i.inf) {
      for (Celula j = i; j != null; j = j.prox) {
        System.out.printf("%d ", j.elemento);
      }
      System.out.printf("\n");
    }
  }

  public void PaodeQueijo() {
    for (Celula i = inicio; i != null; i = i.inf) {
      for (Celula j = i; j != null; j = j.prox) {
        if (j.elemento == 1)
          System.out.printf("9");
        else {
          int count = 0;
          if (j.sup != null && j.sup.elemento == 1)
            count++;
          if (j.prox != null && j.prox.elemento == 1)
            count++;
          if (j.ant != null && j.ant.elemento == 1)
            count++;
          if (j.inf != null && j.inf.elemento == 1)
            count++;
          System.out.printf("%d", count);
        }
      }
      System.out.printf("\n");
    }
  }
}

class Main {
  public static boolean isFim(String s) {
    return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static void main(String[] args) {
    int a = 0;
    Matriz matrizes[] = new Matriz[100];
    String entrada = new String();

    entrada = MyIO.readLine();
    do {
      String array[] = new String[2];
      array = entrada.split(" ");
      int linha = Integer.parseInt(array[0]);
      int col = Integer.parseInt(array[1]);
      matrizes[a] = new Matriz(linha, col);

      int[] valores = new int[col * linha];

      for (int x = 0; x < linha * col; x++) {
        valores[x] = MyIO.readInt();
      }

      matrizes[a].gerar(valores);
      matrizes[a].PaodeQueijo();
      entrada = MyIO.readLine();
    } while (isFim(entrada) == false);
  }
}