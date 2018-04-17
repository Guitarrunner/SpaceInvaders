public class Nodo {
	private int valor = 0;
	private Nodo next = null;
	private Nodo previous = null;
	
	public Nodo getNext() {
		return next;
	}
	
	public void setNext(Nodo next) {
		this.next = next;
	}
	public Nodo getPrevious() {
		return previous;
	}
	
	public void setPrevious(Nodo previous) {
		this.previous = previous;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	
}
}