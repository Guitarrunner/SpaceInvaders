import java.awt.Color;
import java.awt.Graphics;

public class Jugador extends Objetos {

	public Jugador(int x, int y, ID id) {
		super(x, y, id);
		
	}
	public void tick() {
		x += velx;
		y += vely;
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
	}
}

