
public class ListaDCircular extends ListaSimple{
	Objetos Root = null;
	int cantidadNodos=0;
	void agregar(Objetos Nuevo, ListaDCircular L1) {
		if (L1.Root==null) {
			L1.Root = Nuevo;
			cantidadNodos+=1;
			L1.Root.setPrevious(L1.Root);
			L1.Root.setNext(L1.Root);
			//System.out.println(cantidadNodos);
			return;
		}
		else {
			Objetos tmp = L1.Root;
			while(tmp.getNext()!=L1.Root) {
				tmp=tmp.getNext();
			}
			tmp.setNext(Nuevo);
			tmp.getNext().setNext(L1.Root);
			Root.setPrevious(Nuevo);
			tmp.getNext().setPrevious(tmp);
			//System.out.println(tmp);
			//System.out.println(tmp.getNext());
			cantidadNodos+=1;
			//System.out.println(cantidadNodos);
			return;
		}
	}
	

	void borrar(Objetos objeto, ListaDCircular L1) {
		if (L1.size()==1){
			L1.Root=null;
			L1.cantidadNodos=0;
			return;
		}
		else {
		if (objeto == L1.Root) {
			L1.Root = L1.Root.getNext();
			L1.Root.setPrevious(Root.getPrevious().getPrevious());
			return;
		}
		else {
			Objetos tmp=L1.Root;
			while (tmp!=objeto && tmp.getNext() != Root) {
					tmp=tmp.getNext();
			}
			
				tmp.getPrevious().setNext(tmp.getNext());
				tmp.getNext().setPrevious(tmp.getPrevious());
				L1.cantidadNodos=L1.cantidadNodos-1;
				
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