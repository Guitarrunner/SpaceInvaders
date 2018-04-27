import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
public class Main  extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 1L;
	private static final int ancho = 1350, alto = 747;
	private Creador creador;
	private Menu menu;
	private Jugador J1;
	private EnemigoA A;
	public enum pantalla{
		Menu,
		GameOver,
		Informacion,
		Juego;
	}
	
	
	public pantalla estado =pantalla.Menu;
	public Main() {
		manejador = new Manejador();
		manejador1 = new Manejador();
		manejador2 = new Manejador();
		vidas = new Vidas(this,manejador);
		menu = new Menu(this, manejador,vidas);
		Musica.load("Menu","res/Menu.ogg");
		Musica.getMusic("Menu").loop();
		this.addKeyListener(new KeyInput(manejador,vidas));
		this.addMouseListener(menu);
		new Ventana(ancho,alto,"Space Invaders",this);
		
		
		J1 = new Jugador(100,700,ID.Jugador, null,manejador,vidas);
		creador = new Creador(manejador, vidas,J1);
		manejador.objetos.agregar(J1,manejador.objetos);
		if (estado==pantalla.Juego) {
			manejador.objetos.agregar(new Enemigo(10,10,ID.Enemigo,J1,manejador,vidas),manejador.objetos);
		}
		
		
		
	}
	private Thread thread;
	private boolean corriendo = false;
	private Vidas vidas;
	
	private Manejador manejador;
	static Manejador manejador1;
	static Manejador manejador2;
	public synchronized void empezar() {
		thread = new Thread(this);
		thread.start();
		corriendo = true;
	}
	public static int clamp(int var, int min, int max) {
		if (var>=max) return var=max;
		if (var<=min) return var=min;
		else {
			return var;
		}
	}
	public synchronized void parar() {
		try {
			thread.join();
			corriendo=false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run(){
		this.requestFocus();
		long ultimavez = System.nanoTime();
		double cantidadTicks = 60.0;
		double ns = 1000000000 / cantidadTicks;
		double delta = 0;
		long temporizador = System.currentTimeMillis();
		int frames = 0;
		while (corriendo) {
			long ya = System.nanoTime();
			delta += (ya - ultimavez) / ns;
			ultimavez = ya;
			while(delta>=1) {
				tick();
				delta--;
			}
			if (corriendo) 
				render();
			frames++;
			if(System.currentTimeMillis() - temporizador > 1000) {
				temporizador += 1000;
				frames=0;
			}
		}
		parar();
	}
	
	private void tick() {
		manejador2.tick();
		manejador1.tick();
		manejador.tick();
		if (estado == pantalla.Juego) {
			
			vidas.tick();
			creador.tick();
		} 
		if (estado == pantalla.Menu){
			menu.tick();
		}
		
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, ancho, alto);
		manejador2.render(g);
		manejador.render(g);
		manejador1.render(g);
		if (estado==pantalla.Juego) {
			vidas.render(g);
		}
		if (estado == pantalla.Menu || estado == pantalla.Informacion || estado == pantalla.GameOver){
			g.setColor(Color.white);
			menu.render(g);
		}
			
			
		
		g.dispose();
		bs.show();
		
		
	}
	public static void main(String[] args) {
		new Main();
}
	
	
}