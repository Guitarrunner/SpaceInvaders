import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemigo extends Objetos {
	Manejador manejador;
	private int contador2 =100;
	private int creap =0;
	private int crono=5;
	private int crono2 =300;
	private int contador=0;
	private Vidas vida;
	Random r = new Random();
	
	public Enemigo(int x, int y, ID id, Jugador J1, Manejador manejador,Vidas vida) {
		super(x, y, id,J1);
		this.vida =vida;
		this.manejador=manejador;
		
		velx = 0;
		vely= 5;
	}
	public int setvelx(int vel) {
		if (x<=0 || x>=1350-32) vel = -vel;
		return vel;
	}
	public void crearbalas() {
	
		if (contador2<=0 && creap==0) {manejador.objetos.agregar(new Bala(x,y+32,ID.Bala,J1,manejador));contador2=50;creap++;}
		
		else contador2--;creap=0;
		
	}
	
	public void cambiodireccion() {
		int decision = r.nextInt(30);
		if (decision==9) velx = -velx;
	}
	public void tick() {  
		//crearbalas();
		x += velx;
		y += vely;
		
		colision();
		cambiodireccion();
		if (crono<=0)vely=0;
		else crono--;
		
		if(crono<=0) {
			
		crono2--;if(contador==0&&velx==0) {velx=-5;contador++;}if (contador==0 && velx>0) {velx=5;contador++;}if (contador==1 && velx<0) {velx=-5;contador++;} }
	
		
		if(crono2<=0) {
			if(vely==0) {vely=5;crono=5;crono2=50;contador=0;}
		}
		
		if (y<=0 || y>=(746)-60) vely = -vely;
		if (x<=10 || x>=1350-42) velx *= -1;
		//System.out.println(manejador.objetos.size());
		if (y >= 650) {manejador.borrar(this, manejador.objetos);vida.vid(vida.getvid()-1);}
		
		
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	public Rectangle rectcolision() {
		return new Rectangle(x,y,32,32);
	}
	protected void colision() {
		int i=0;
		while(i<manejador.objetos.size()) {
			Objetos tmp= manejador.objetos.get(i);
			if(tmp.getId() == ID.Bala ) {
				if (rectcolision().intersects(tmp.rectcolision())) {
					{manejador.objetos.borrar(this, manejador.objetos);manejador.objetos.borrar(tmp, manejador.objetos);vida.marcador2(vida.getmarcador2()+100);}
				}
			}
			i+=1;
		}
	}
} 
