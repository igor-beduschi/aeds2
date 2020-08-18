public void mostrar(Celula a, Celula b){
    if(a != null){
        System.out.print(a.elemento + " ");
        a = a.prox;
    }
    if(b != null){
        System.out.print(b.elemento + " ");
       b = b.prox;
    }
    if(a != null || b != null) mostrar(a,b);
}

public void Chamarmostrar(Pilha a, Pilha b){
   mostrar(a.topo,b.topo);
}

//<------ Complexidade O(N+M)
/*
Seja nossa classe Pilha Flexível, faça um método
R.E.C.U.R.S.I.V.O
que recebe dois objetos do tipo Pilha e mostra na tela os elementos contidos nessas Pilhas de forma intercalada. Apresente a complexidade para execução desta operação.