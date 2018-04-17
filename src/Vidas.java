import java.awt.Graphics;
import java.awt.Color;

public class Vidas{
	private Main juego;
	private Manejador manejador;
	public Vidas(Main juego, Manejador manejador) {
		this.juego =juego;
		this.manejador = manejador;
	}
	int getvid() {
		return vidas;
	}
	void vid(int num) {
		vidas = num;
	}
	int vidas = 3;
	Color basic = Color.blue;
	public void tick() {
		marcador++;
		if (marcador%2000==0) {
			nivel++;
			marcador2 = marcador2 +1000;
		}
	}
	public void marcador(int marcador) {
		this.marcador = marcador;
	}
	public int getmarcador() {
		return marcador;
	}
	public void marcador2(int marcador) {
		this.marcador2 = marcador;
	}
	public int getmarcador2() {
		return marcador2;
	}
	public void nivel(int nivel) {
		this.nivel = nivel;
	}
	public int getnivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel=nivel;
	}
	private int marcador = 0;
	private int marcador2 = 0;
	private int nivel= 1;
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
			;
			int i=manejador.objetos.size();
			while(i>=1) {
				
				Objetos tmp= manejador.objetos.get(i);
				manejador.borrar(tmp, manejador.objetos);
				i--;
			}
			Musica.getMusic("Juego").stop();
			Musica.load("GameOver", "res/GameOver.ogg");
			Musica.getMusic("GameOver").loop();
			juego.estado = Main.pantalla.GameOver;
		}
		g.drawString("Marcador:" + getmarcador2(), 5, 700);
		g.drawString("Nivel:" + nivel, 5, 710);
	}
}
