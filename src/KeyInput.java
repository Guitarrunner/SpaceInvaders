import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Manejador manejador;
	private boolean[] keyDown = new boolean[4];
	public KeyInput(Manejador manejador) {
		this.manejador = manejador;
		keyDown[0] =false;
		keyDown[1] =false;
		keyDown[2] =false;
		keyDown[3] =false;
		
		
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int i=0;
		while(i<manejador.objetos.size()) {
			Objetos tmp= manejador.objetos.get(i);
			if(tmp.getId() == ID.Jugador) {
				//if (key == KeyEvent.VK_UP) {keyDown[0]=true;tmp.setVely(-5);}
				//if (key == KeyEvent.VK_DOWN) {keyDown[1]=true;tmp.setVely(5);}
				if (key == KeyEvent.VK_RIGHT) {keyDown[2]=true;tmp.setVelx(5);}
				if (key == KeyEvent.VK_LEFT) {keyDown[3]=true;tmp.setVelx(-5);}
				if (key == KeyEvent.VK_SPACE) {tmp.crearbalas1(true);}
				//if (key == KeyEvent.VK_UP) {tmp.setVely(-5);}
				//if (key == KeyEvent.VK_DOWN) {tmp.setVely(5);}
				//if (key == KeyEvent.VK_RIGHT) {tmp.setVelx(5);}
				//if (key == KeyEvent.VK_LEFT) {tmp.setVelx(-5);}
			}
			i+=1;
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(1); 
		if (key == KeyEvent.VK_T) Vidas.vid(Vidas.getvid()-1); 
	} 
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
			int i=0;
			while(i<manejador.objetos.size()) {
				Objetos tmp= manejador.objetos.get(i);
				if(tmp.getId() == ID.Jugador) {
					if (key == KeyEvent.VK_UP) keyDown[0]=false;//tmp.setVely(0);
					if (key == KeyEvent.VK_DOWN) keyDown[1]=false;//tmp.setVely(0);
					if (key == KeyEvent.VK_RIGHT) keyDown[2]=false;//tmp.setVelx(0);
					if (key == KeyEvent.VK_LEFT) keyDown[3]=false;//tmp.setVelx(0);
					if (key == KeyEvent.VK_SPACE) {tmp.crearbalas1(false);}
					//if (key == KeyEvent.VK_UP) {tmp.setVely(0);}
					//if (key == KeyEvent.VK_DOWN) {tmp.setVely(0);}
					//if (key == KeyEvent.VK_RIGHT) {tmp.setVelx(0);}
					//if (key == KeyEvent.VK_LEFT) {tmp.setVelx(-0);}
					if(!keyDown[0] && !keyDown[1])tmp.setVely(0);
					if(!keyDown[2] && !keyDown[3])tmp.setVelx(0);
				}
				i+=1;
				
				
			}
	}
}
