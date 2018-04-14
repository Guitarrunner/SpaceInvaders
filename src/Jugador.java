import java.awt.Color;
import java.awt.Graphics;

public class Jugador extends Objetos {

	public Jugador(int x, int y, ID id) {
		super(x, y, id);
		
	}
	public void tick() {
		x += velx;
		y += vely;
		x = Main.clamp(x,0,640/12*9+125);
		y = Main.clamp(y,0,640-223);
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
	}
}

