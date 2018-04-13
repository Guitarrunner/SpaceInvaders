import java.awt.Graphics;

public class Manejador {
	ListaSimple objetos = new ListaSimple();
	public void tick() {
		for(int i=0; i<objetos.cantidadNodos; i++) {
			Objetos tmp= objetos.get(i);
			tmp.tick();
		}
	}
	public void render(Graphics g) {
		for(int i=0; i<objetos.cantidadNodos; i++) {
			Objetos tmp = objetos.get(i);
			tmp.render(g);
		}
	}
}

