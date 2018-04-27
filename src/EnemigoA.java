
public class EnemigoA{
	private Vidas vida;
	private Manejador manejador;
	private Jugador J1;
	public EnemigoA(Jugador J1, Manejador manejador, Vidas vida) {
		this.manejador = manejador;
		this.J1 = J1;
		this.vida=vida;
		
	}
	void crear() {
		manejador.objetos.agregar(new Enemigo(40,40,ID.Enemigo,J1,manejador,vida),manejador.objetos);
		manejador.objetos.agregar(new Enemigo(80,40,ID.Enemigo,J1,manejador,vida),manejador.objetos);
		manejador.objetos.agregar(new Enemigo(120,40,ID.Enemigo,J1,manejador,vida),manejador.objetos);
		manejador.objetos.agregar(new Enemigo(160,40,ID.Enemigo,J1,manejador,vida),manejador.objetos);
		manejador.objetos.agregar(new Enemigo(200,40,ID.Enemigo,J1,manejador,vida),manejador.objetos);
	}

}
