
public class Creador {
	private Manejador manejador;
	private Vidas vida;
	private Jugador J1;
	private int contador=0;
	private int contador1=0;
	private int nivel;
	//private int marcador1;
	public Creador(Manejador manejador, Vidas vida,Jugador J1) {
		this.manejador = manejador;
		this.vida = vida;
		this.J1 =J1;
	}
	public void tick() {
		//marcador1++;
		nivel=vida.getnivel();
		//System.out.println(contador);
		//System.out.println(nivel);
		if (nivel%2!=0) {
			contador=0;
			//System.out.println(contador+"000000");
		}
		if (nivel%5!=0) {
			contador1=0;
			//System.out.println(contador1+"000000");
		}
		if (nivel%2==0) {
			if (contador==0) {
				manejador.objetos.agregar(new Enemigo(100,200,ID.Enemigo,J1));
				contador=contador+1;
				//System.out.println("sup");;
			}
		
			}
		if (nivel%5==0) {
			if (contador1==0) {
				manejador.objetos.agregar(new EnemigoFollow(100,200,ID.Enemigo,J1));
				contador1=contador1+1;
			}
		}	
	}
}
