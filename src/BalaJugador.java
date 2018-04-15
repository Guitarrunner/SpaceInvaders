import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BalaJugador extends Objetos {
	Manejador manejador;
	
	public BalaJugador(int x, int y, ID id, Jugador J1,Manejador manejador) {
		super(x, y, id,J1);
		this.manejador=manejador;
		
		velx = 0;
		vely= -4;
	}
	
	
	public void tick() {
		x += velx;
		y += vely;
		
		//if (y<=0 || y>=(746)-60) vely = -vely;
		//if (x<=0 || x>=1350-32) velx *= -1;
		
		if (y <= 0) manejador.borrar(this,manejador.objetos);
	}
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, 6, 6);
	}
	public Rectangle rectcolision() {
		return new Rectangle(x,y,6,6);
	}
	
} 