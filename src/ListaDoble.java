
public class ListaDoble {
	Nodo Root = null;
	
	void agregar(Nodo Nuevo) {
		if (Root==null) {
			Root = Nuevo;
			Root.setPrevious(null);
			return;
		}
		else {
			Nodo tmp = Root;
			while(tmp.getNext()!=null) {
				tmp=tmp.getNext();
			}
			tmp.setNext(Nuevo);
			Nuevo.setPrevious(tmp);
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
			Root.setPrevious(null);
			return;
		}
		else {
				int puntero = 0;
				Nodo tmp=Root;
				while(puntero!=posicion) {
					if (tmp.getNext()!= null) {
						tmp=tmp.getNext();
						puntero=puntero+1;
					}
					else{
						throw new IllegalArgumentException("Index out of range");
					}
					
				}
				if (tmp.getNext()==null) {
					tmp.getPrevious().setNext(null);
				}
				else {
					tmp.getPrevious().setNext(tmp.getNext());
					tmp.getNext().setPrevious(tmp.getPrevious());
					return;
				}
				
		}
	}
	
}
