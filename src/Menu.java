import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {
	
	private Main juego;
	private Manejador manejador;
	private Vidas vida;
	public Menu(Main juego, Manejador manejador,Vidas vida) {
		this.vida = vida;
		this.juego =juego;
		this.manejador = manejador;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//72, 560, 371, 75
		if (juego.estado == Main.pantalla.Menu) {
			if (mouseen(mx, my,72,560,371,75)) {
				vida.vid(3);
				juego.estado = Main.pantalla.Juego;
				
				}
			if (mouseen(mx, my,896, 560, 371, 75)) System.exit(1);;
			if  (mouseen(mx, my,484, 560, 371, 75)) juego.estado = Main.pantalla.Informacion;
		}
		
		if (juego.estado == Main.pantalla.Informacion) {if  (mouseen(mx, my,484, 360, 371, 75)) juego.estado = Main.pantalla.Menu;}
		if (juego.estado == Main.pantalla.GameOver) {if  (mouseen(mx, my,484, 360, 371, 75)) juego.estado = Main.pantalla.Menu;}
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
		if(juego.estado == Main.pantalla.Menu){
		Font fnt = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.drawString("Menu", 610, 188);
		g.drawString("Jugar", 210, 605);
		g.drawString("Informacion", 590, 605);
		g.drawString("Salir", 1040, 605);
		
		g.drawRect(72, 560, 371, 75);
		g.drawRect(484, 560, 371, 75);
		g.drawRect(896, 560, 371, 75);
	}
		if(juego.estado == Main.pantalla.Informacion){
			Font fnt = new Font("arial",1,30);
			Font fnt1 = new Font("arial",1,15);
			
			g.setFont(fnt);
			g.drawString("Informacion", 590, 188);
			g.drawString("Volver", 620, 405);
			g.setFont(fnt1);
			g.drawString("Josue Araya Garcia", 590, 288);
			g.drawString("2017103205", 590, 328);
			
			g.drawRect(484, 360, 371, 75);
		}
		if(juego.estado == Main.pantalla.GameOver){
			Font fnt = new Font("arial",1,30);
			Font fnt1 = new Font("arial",1,15);
			g.setFont(fnt);
			g.drawString("GAME OVER", 590, 188);
			g.drawString("Volver", 620, 405);
			g.setFont(fnt1);
			g.drawString("Tu marcador fue de "+vida.getmarcador2()+" puntos", 590, 288);
			g.drawString("Lograste el nivel " + vida.getnivel(), 590, 328);
			g.drawRect(484, 360, 371, 75);
		}
	}
}
