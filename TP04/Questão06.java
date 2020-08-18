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

public void Chamarmostrar(Fila a, Fila b){
     mostrar(a.primeiro,b.primeiro);
}

//<------ Complexidade O(N+M)