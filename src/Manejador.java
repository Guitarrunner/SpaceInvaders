import java.awt.Graphics;

//import java.util.LinkedList;

public class Manejador extends ListaDCircular {
	ListaDCircular objetos = new ListaDCircular();
	//LinkedList<Objetos> objetos = new LinkedList<Objetos>();
	public void tick() {
		int i=0;
		while(i<objetos.size() && objetos.size()!=0) {
			
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

