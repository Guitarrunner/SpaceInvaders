import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {
	private Manejador manejador;
	public Teclado(Manejador manejador) {
		this.manejador = manejador;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int i=0;
		while(i<manejador.objetos.size()) {
			Objetos tmp= manejador.objetos.get(i);
			if(tmp.getId() == ID.Jugador) {
				if (key == KeyEvent.VK_UP) tmp.setVely(5);
				if (key == KeyEvent.VK_DOWN) tmp.setVely(-5);
				if (key == KeyEvent.VK_RIGHT) tmp.setVelx(5);
				if (key == KeyEvent.VK_LEFT) tmp.setVelx(-5);
			}
			i+=1;
		}
		 
	} 
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
			int i=0;
			while(i<manejador.objetos.size()) {
				Objetos tmp= manejador.objetos.get(i);
				if(tmp.getId() == ID.Jugador) {
					if (key == KeyEvent.VK_UP) tmp.setVely(0);
					if (key == KeyEvent.VK_DOWN) tmp.setVely(0);
					if (key == KeyEvent.VK_RIGHT) tmp.setVelx(0);
					if (key == KeyEvent.VK_LEFT) tmp.setVelx(0);
				}
				i+=1;
			}
	}
}
