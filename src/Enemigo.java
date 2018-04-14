import java.awt.Color;
import java.awt.Graphics;

public class Enemigo extends Objetos {

	public Enemigo(int x, int y, ID id, Jugador J1) {
		super(x, y, id,J1);
		
		//velx = 5;
		//vely= 5;
	}
	public void tick() {
		if (Math.abs(J1.getx()-(x+1))>Math.abs(J1.getx()-(x-1)))
			velx=-2;
		else velx=2;
		if (Math.abs(J1.gety()-(y+1))>Math.abs(J1.gety()-(y-1)))
			vely=-2;
		else vely=2;
		x += velx;
		y += vely;
		
		if (y<=0 || y>=(640/12*9)-60) vely = -vely;
		if (x<=0 || x>=640-32) velx = -velx;
		
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
} 
