
public class Creador {
	private Manejador manejador;
	private Vidas vida;
	private Jugador J1;
	private int contador=0;
	//private int marcador1;
	public Creador(Manejador manejador, Vidas vida,Jugador J1) {
		this.manejador = manejador;
		this.vida = vida;
		this.J1 =J1;
	}
	public void tick() {
		//marcador1++;
		if (vida.getnivel()==2) {
			if (contador==0) {
				manejador.objetos.agregar(new Enemigo(100,200,ID.Enemigo,J1));
				contador++;
			}
			}
	}
}
