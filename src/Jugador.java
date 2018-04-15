import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Jugador extends Objetos {
	Manejador manejador;

	public Jugador(int x, int y, ID id, Jugador J1, Manejador manejador) {
		super(x, y, id, J1);
		this.manejador = manejador;
		
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public void tick() {
		x += velx;
		y += vely;
		x = Main.clamp(x,0,1350-38);
		y = Main.clamp(y,0,747-60);
		colision();
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
	}
	public Rectangle rectcolision() {
		return new Rectangle(x,y,32,32);
	}
	private void colision() {
		int i=0;
		while(i<manejador.objetos.size()) {
			Objetos tmp= manejador.objetos.get(i);
			if(tmp.getId() == ID.Enemigo) {
				if (rectcolision().intersects(tmp.rectcolision())) {
					Vidas.vid(Vidas.getvid()-1);
				}
			}
			i+=1;
		}
	}
}

