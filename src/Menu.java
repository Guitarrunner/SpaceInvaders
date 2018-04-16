import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {
	
	private Main juego;
	private Manejador manejador;
	
	public Menu(Main juego, Manejador manejador) {
		this.juego =juego;
		this.manejador = manejador;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//72, 560, 371, 75
		if (mouseen(mx, my,72,560,371,75)) {
			juego.estado = Main.pantalla.Juego;
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	public void tick() {
		
	}
	
	private boolean mouseen(int mx, int my, int x, int y, int ancho, int alto) {
		if (mx > x && mx < x + ancho) {
			if (my > y && my < y + alto){
				return true;
				}
			else return false;
		}
		else return false;
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.drawString("Menu", 610, 188);
		g.drawString("Jugar", 210, 605);
		g.drawString("Opciones", 600, 605);
		g.drawString("Salir", 1040, 605);
		
		g.drawRect(72, 560, 371, 75);
		g.drawRect(484, 560, 371, 75);
		g.drawRect(896, 560, 371, 75);
	}
}
