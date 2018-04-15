import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemigo extends Objetos {
	Manejador manejador;
	private int contador2 =100;
	private int creap =0;
	private int crono=5;
	private int crono2 =300;
	private int contador=0;
	
	public Enemigo(int x, int y, ID id, Jugador J1, Manejador manejador) {
		super(x, y, id,J1);
		this.manejador=manejador;
		
		velx = 0;
		vely= 2;
	}
	public int setvelx(int vel) {
		if (x<=0 || x>=1350-32) vel = -vel;
		return vel;
	}
	public void crearbalas() {
		
		if (contador2<=0 && creap==0) {manejador.objetos.agregar(new Bala(x,y+32,ID.Bala,J1,manejador));contador2=50;creap++;}
		
		else contador2--;creap=0;;
	}
	public void tick() {
		crearbalas();
		x += velx;
		y += vely;
		
		
		if (crono<=0)vely=0;
		else crono--;
		
		if(crono<=0) {
			
		crono2--;if(contador==0&&velx==0) {velx=-5;contador++;}if (contador==0 && velx>0) {velx=5;contador++;}if (contador==1 && velx<0) {velx=-5;contador++;} }
	
		
		if(crono2<=0) {
			if(vely==0) {vely=10;crono=5;crono2=300;contador=0;}
		}
		
		if (y<=0 || y>=(746)-60) vely = -vely;
		if (x<=0 || x>=1350-32) velx *= -1;
		//System.out.println(manejador.objetos.size());
		if (y >= 650) {manejador.borrar(this, manejador.objetos);}
		
		
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	public Rectangle rectcolision() {
		return new Rectangle(x,y,32,32);
	}
} 
