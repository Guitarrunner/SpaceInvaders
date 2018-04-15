import java.awt.Canvas;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
public class Main  extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 1L;
	private static final int ancho = 640, alto = ancho / 12 *9;
	private Creador creador;
	public Main() {
		manejador = new Manejador();
		this.addKeyListener(new KeyInput(manejador));
		new Ventana(ancho,alto,"Space Invaders",this);
		vidas = new Vidas();
		Jugador J1 = new Jugador(100,500,ID.Jugador, null,manejador);
		creador = new Creador(manejador, vidas,J1);
		manejador.objetos.agregar(J1);
		manejador.objetos.agregar(new Enemigo(200,200,ID.Enemigo,J1));
		manejador.objetos.agregar(new EnemigoFollow(300,200,ID.Enemigo,J1));
		
	}
	private Thread thread;
	private boolean corriendo = false;
	private Vidas vidas;
	
	private Manejador manejador;
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
		manejador.tick();
		vidas.tick();
		creador.tick();
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
		
		manejador.render(g);
		vidas.render(g);
		
		g.dispose();
		bs.show();
		
		
	}
	public static void main(String[] args) {
		new Main();
}
	
}