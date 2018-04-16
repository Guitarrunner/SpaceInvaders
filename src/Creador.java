import java.util.Random;

public class Creador {
	private Manejador manejador;
	private Vidas vida;
	private Jugador J1;
	private int contador=0;
	private int contador1=0;
	private int nivel;

	private int contador2 =0;
	private int creap =0;
	private int contador3 =0;
	private int creap2 =0;
	Random r = new Random();
	
	//private int marcador1;
	public Creador(Manejador manejador, Vidas vida, Jugador J1) {
		this.manejador = manejador;
		this.vida = vida;
		this.J1 = J1;
		
		
	}
	
	public void tick() {

		
		if (contador2<=0 && creap==0) {manejador.objetos.agregar(new Enemigo(r.nextInt(1300),r.nextInt(100),ID.Enemigo,J1,manejador,vida));contador2=50;creap++;}
		
		else contador2--;creap=0;
		
		if (contador3<=0 && creap2==0) {manejador.objetos.agregar(new EnemigoFollow(r.nextInt(1300),r.nextInt(100),ID.EnemigoFollow,J1,manejador,vida));contador3=150;creap2++;}
		
		else contador3--;creap2=0;
		
		
		//marcador1++;
		nivel=vida.getnivel();
		//System.out.println(contador);
		//System.out.println(nivel);
		if (nivel%5!=0) {
			contador=0;
			//System.out.println(contador+"000000");
		}
		if (nivel%10!=0) {
			contador1=0;
			//System.out.println(contador1+"000000");
		}
		if (nivel%5==0) {
			if (contador==0) {
				manejador.objetos.agregar(new Enemigo(10,200,ID.Enemigo,J1,manejador,vida));
				contador=contador+1;
				//System.out.println("sup");;
			}
		
			}
		if (nivel%10==0) {
			if (contador1==0) {
				manejador.objetos.agregar(new EnemigoFollow(100,200,ID.EnemigoFollow,J1,manejador,vida));
				contador1=contador1+1;
			}
		}	
	}
}
