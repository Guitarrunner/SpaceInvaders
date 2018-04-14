import java.awt.Graphics;

public class Manejador extends ListaSimple {
	ListaSimple objetos = new ListaSimple();
	public void tick() {
		int i=0;
		while(i<objetos.size()) {
			Objetos tmp= objetos.get(i);
			tmp.tick();
			i+=1;
		}
			
	}
	public void render(Graphics g) {
		int i=0;
		while(i<objetos.size()) {
			Objetos tmp = objetos.get(i);
			tmp.render(g);
			i+=1;
		}
	}
	


}

