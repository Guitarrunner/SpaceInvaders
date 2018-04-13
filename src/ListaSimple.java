

public class ListaSimple {
	Objetos Root = null;
	int cantidadNodos;
	void agregar(Objetos Nuevo) {
		if (Root==null) {
			Root = Nuevo;
			cantidadNodos=1;
			return;
		}
		else {
			Objetos tmp = Root;
			while(tmp.getNext()!=null) {
				tmp=tmp.getNext();
			}
			tmp.setNext(Nuevo);
			cantidadNodos+=1;
			return;
		}
	}
	
	void imprimirLista() {
		Objetos tmp = Root;
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
				Objetos tmp=Root;
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
	
	Objetos get(int i) {
		if(i>cantidadNodos) {
			throw new IllegalArgumentException("Index out of range");
		}
		else {
			Objetos tmp= Root;
			int tmppos=0;
			while(i!=tmppos) {
				tmp=tmp.getNext();
				tmppos=+1;
			}
		return tmp;
		}
	}
}







