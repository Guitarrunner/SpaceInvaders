import java.awt.Color;
import java.awt.Graphics;

public class Enemigo extends Objetos {

	public Enemigo(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		x += velx;
		y += vely;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
}
