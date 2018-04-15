

public class ListaSimple {
	Objetos Root = null;
	int cantidadNodos=0;
	void agregar(Objetos Nuevo) {
		if (Root==null) {
			Root = Nuevo;
			cantidadNodos+=1;
			//System.out.println(cantidadNodos);
			return;
		}
		else {
			Objetos tmp = Root;
			while(tmp.getNext()!=null) {
				tmp=tmp.getNext();
			}
			tmp.setNext(Nuevo);
			//System.out.println(tmp);
			//System.out.println(tmp.getNext());
			cantidadNodos+=1;
			//System.out.println(cantidadNodos);
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
			Objetos tmp = Root;
			int e=0;
			while (e!=i) {
				tmp=tmp.getNext();
				e++;
			}
			return tmp;
		}
		}
	
	
	int size() {
		Objetos tmp=Root;
		int size=0;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			size++;
		}
		size=size+1;
		//System.out.println(size);
		return size;
	}
}







