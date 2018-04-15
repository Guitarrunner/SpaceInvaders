import java.awt.Color;
import java.awt.Graphics;

public class EnemigoFollow extends Enemigo{
	Manejador manejador;
	public EnemigoFollow(int x, int y, ID id, Jugador J1,Manejador manejador) {
		super(x, y, id,J1,manejador);
		velx=0;
		vely=0;
	}
	public void tick() {
		if (Math.abs(J1.getx()-(x+1))>Math.abs(J1.getx()-(x-1)))
			x=x-2;
		else x=x+2;
		//if (Math.abs(J1.gety()-(y+1))>Math.abs(J1.gety()-(y-1)))
			//y=y-2;
		///else y=y+2;
		x += velx;
		y += vely;
		
		if (y<=0 || y>=(747)-60) vely = -vely;
		if (x<=0 || x>=1350-32) velx = -velx;
		
	}
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(x, y, 32, 32);
	}
} 