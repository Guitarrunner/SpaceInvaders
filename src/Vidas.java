import java.awt.Graphics;
import java.awt.Color;

public class Vidas {
	static int getvid() {
		return vidas;
	}
	static void vid(int num) {
		vidas = num;
	}
	static int vidas = 3;
	Color basic = Color.blue;
	public void tick() {
		
		
	}
	public void render(Graphics g) {
		if (vidas==3) {
		g.setColor(basic);
		g.fillRect(15, 15, 12, 12);
		g.setColor(basic);
		g.fillRect(28, 15, 12, 12);
		g.setColor(basic);
		g.fillRect(41, 15, 12, 12);
		}
		if (vidas==2) {
			g.setColor(basic);
			g.fillRect(15, 15, 12, 12);
			g.setColor(basic);
			g.fillRect(28, 15, 12, 12);
		}
		if (vidas==1) {
			g.setColor(basic);
			g.fillRect(15, 15, 12, 12);
		}
		if (vidas==0) {
			System.exit(1);
		}
	}
}
