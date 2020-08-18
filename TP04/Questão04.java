public void CopiarPfila(Celula topo, Celula primeiro, Celula ultimo){
	if(primeiro == null) ultimo = primeiro;
	inserir(topo,ultimo);
}

public void inserir(Celula atual, celula ultimo){
    if(atual.prox != null){
    	inserir(atual.prox);
  	}
	ultimo.prox = new Celula(atual.elemento);
	ultimo = ultimo.prox;
}



