public boolean pesquisar(int numero) {
    boolean resp = false;
    resp = pesquisarT1(numero);
    return resp;
}	

public boolean pesquisarT1(int numero) {
    boolean resp = false;
    int posicao = executarHash(numero);

    if (numero == tabelaHashT1[posicao]) {
      resp = true;
    } else {
      resp = pesquisarT2(numero);
    }
    return resp;
}

public boolean pesquisarT2(int numero) {
    boolean resp = false;
    int posicao = executarHash(numero);

    if (numero == tabelaHashT2[posicao]) {
      resp = true;
    } else {
      posicao = executarReHash(numero);

      if (numero == tabelaHash[posicao]) {
        contemPersonagem = true;
      }

      else {
        resp = caminhoT3(numero);
      }
    }
    return resp;
}

public boolean caminhoT3(int numero) {
	boolean resp = false;
	if (numero % 2 == 0) {
	  resp = pesquisarT3(numero);
	} else if (numero % 2 == 1) {
	  resp = pesquisarArvore(numero);
	}
	return resp;
}

pesquisarT3{
//igual pesquisar lista dinamica
}

