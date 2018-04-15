import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Objetos extends Nodo {
	protected int x,y;
	protected ID id;
	protected int velx,vely;
	private int valor = 0;
	private Objetos next ;
	private Objetos previous;
	protected Jugador J1;
	
	public Objetos getNext() {
		return next;
	}
	
	public void setNext(Objetos next) {
		this.next = next;
	}
	public Objetos getPrevious() {
		return previous;
	}
	
	public void setPrevious(Objetos previous) {
		this.previous = previous;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	
}
	public void crearbalas() {
		
	}
	public Objetos(int x, int y, ID id,Jugador J1) {
		this.x =x;
		this.y = y;
		this.id = id;
		this.J1 =J1;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle rectcolision();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getVelx() {
		return velx;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public int getVely() {
		return vely;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}

	public boolean crearbalas1(boolean b) {
		return false;
	}
	
	
	
}
