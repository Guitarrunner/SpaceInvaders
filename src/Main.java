import java.awt.Canvas;

public class Main  extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 1L;
	private static final int ancho = 640, alto = ancho / 12 *9;
	public Main() {
		new Ventana(ancho,alto,"Joli",this);
	}
	private Thread thread;
	private boolean corriendo = false;
	public synchronized void empezar() {
		thread = new Thread(this);
		thread.start();
		corriendo = true;
	}
	public synchronized void parar() {
		try {
			thread.join();
			corriendo=false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void corriendo(){
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
				System.out.println("FPS: "+ frames);
				frames=0;
			}
		}
		parar();
	}
	
	private void tick() {
		
	}
	private void render() {
		
	}
	public static void main(String[] args) {
		new Main();
		
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}