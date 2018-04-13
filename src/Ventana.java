import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
public class Ventana extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana (int ancho, int alto, String Nombre, Main Juego) {
		JFrame frame = new JFrame(Nombre);
		
		frame.setPreferredSize(new Dimension(ancho,alto));
		frame.setMaximumSize(new Dimension(ancho,alto));
		frame.setMinimumSize(new Dimension(ancho,alto));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(Juego);
		frame.setVisible(true);
		Juego.empezar();
	}
}
