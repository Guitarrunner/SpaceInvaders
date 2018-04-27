import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Jugador extends Objetos {
	Manejador manejador;
	Manejador mbalas= Main.manejador2;
	private Vidas vida;
	private int creap =0;
	public Jugador(int x, int y, ID id, Jugador J1, Manejador manejador, Vidas vida) {
		super(x, y, id, J1);
		this.vida =vida;
		this.manejador = manejador;
		
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public void crearbalas(boolean b) {
		if (b==true) {
		if (contador2<=0 && creap==0) {manejador.objetos.agregar(new Bala(x,y,ID.Bala,J1,manejador),manejador.objetos);contador2=15;creap++;}
		
		else contador2--;creap=0;}
	}
	public void tick() {
		crearbalas(b);
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
			if(tmp.getId() == ID.EnemigoFollow ) {
				if (rectcolision().intersects(tmp.rectcolision())) {
					{manejador.objetos.borrar(tmp, manejador.objetos);vida.vid(0);}
				}
			}
			i+=1;
		}
	}
}

