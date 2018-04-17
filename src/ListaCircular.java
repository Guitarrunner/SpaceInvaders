

public class ListaCircular extends ListaSimple{
	Objetos Root = null;
	int cantidadNodos=0;
	void agregar(Objetos Nuevo) {
		if (Root==null) {
			Root = Nuevo;
			Root.setNext(Root);
			cantidadNodos+=1;
			//System.out.println(cantidadNodos);
			return;
		}
		else {
			Objetos tmp = Root;
			while(tmp.getNext()!=Root) {
				tmp=tmp.getNext();
			}
			tmp.setNext(Nuevo);
			tmp.getNext().setNext(Root);
			tmp.getNext().setPrevious(tmp);
			//System.out.println(tmp);
			//System.out.println(tmp.getNext());
			cantidadNodos+=1;
			//System.out.println(cantidadNodos);
			return;
		}
	}

	void borrar(Objetos objeto, ListaCircular L1) {
		if (objeto == L1.Root) {
			L1.Root = L1.Root.getNext();
			return;
		}
		else {
			Objetos tmp=L1.Root;
			while (tmp.getNext()!= Root) {
				if (tmp.getNext()!=objeto) {
					tmp=tmp.getNext();
				}
				else {tmp.setNext(tmp.getNext().getNext());cantidadNodos=cantidadNodos-1;break;}
			}
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
		if(cantidadNodos!=0) {
		Objetos tmp=Root;
		int size=0;
		while(tmp.getNext()!=Root) {
			tmp=tmp.getNext();
			size++;
		}
		size=size+1;
		//System.out.println(size);
		return size;
	}
		else return 0;
	}
	
}

