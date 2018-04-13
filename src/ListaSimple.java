

public class ListaSimple {
	Nodo Root = null;
	
	void agregar(Nodo Nuevo) {
		if (Root==null) {
			Root = Nuevo;
			return;
		}
		else {
			Nodo tmp = Root;
			while(tmp.getNext()!=null) {
				tmp=tmp.getNext();
			}
			tmp.setNext(Nuevo);
			return;
		}
	}
	
	void imprimirLista() {
		Nodo tmp = Root;
		while(tmp.getNext()!=null) {
			System.out.println(tmp.getValor());
			tmp=tmp.getNext();
		}
		System.out.println(tmp.getValor());
		return;
	}
	
	void borrarporposicion(int posicion) {
		if (posicion==0) {
			Root = Root.getNext();
			return;
		}
		else {
				int puntero = 0;
				Nodo tmp=Root;
				while(puntero!=posicion-1) {
					if (tmp.getNext()!= null) {
						tmp=tmp.getNext();
						puntero=puntero+1;
					}
					else{
						throw new IllegalArgumentException("Index out of range");
					}
					
				}
				tmp.setNext(tmp.getNext().getNext());
				return;
		}
	}
}
