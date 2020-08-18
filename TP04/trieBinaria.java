 private void inserir(String s, No no, int i) throws Exception {
    if(no.prox.GetProx(s.charAt(i)) == null){                    // Verificia se pode fazer a insercao e pegando o no
        no.prox.GetProx(s.charAt(i)) = new No(s.charAt(i));

        if(i == s.length() - 1){                            //Vericia se eh a folha
            no.prox.GetProx(s.charAt(i)).folha = true;
        }else{
            inserir(s, no.prox.GetProx(s.charAt(i)), i + 1);  //Se nao for, continua inserindo
        }

    } else if (no.prox.GetProx(s.charAt(i)).folha == false && i < s.length() - 1){ //Quando nao precisa inserir, mas deve chamar o proximo metodo
        inserir(s, no.prox.GetProx(s.charAt(i)), i + 1);

    } else {
        throw new Exception("Erro ao inserir!");
    } 
}

public No GetProx(int x) {
    return GetProx(x, raiz);
}

public No GetProx(Char x, No i) {
    No resp;
    if (i == null) {
     No = null;
    } 
    else if (x == i.elemento) {
     resp = i;
    } 
    else if (x < i.elemento) {
     resp = GetProx(x, i.esq);
    } 
    else {
     resp = GetProx(x, i.dir);
  }
  return resp;
}

//O(m) e m é o tamanho da cadeia a ser procurada O(lg(n)) para encontrar o n.
