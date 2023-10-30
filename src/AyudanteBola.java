import java.util.ArrayList;

public class AyudanteBola implements Runnable{

	MiPanel fotografo;
	ArrayList<Bola> bolas;
	boolean out = false;

	
	
	public AyudanteBola(MiPanel fotografo, ArrayList<Bola> bolas) {
		this.fotografo = fotografo;
		this.bolas = bolas;
	}
	
	

	@Override
	public void run() {
		
		
		while (true) {
			out = false;
			fotografo.repaint();
			
			for (int i = bolas.size() - 1; i >= 0; i--) {
			
				Bola b = bolas.get(i);
				
				
				switch (b.getDireccion()) {
				
				case 0: //izquerda a derecha
					
					if (b.getX() > 920) {
						out = true;

					} else {
						b.setX(b.getX() + 5);
						//Actualizamos la posicion de la caja
						b.actualizaEsquinas(b.getX(), b.getY());
					}
					
					break;
					
				case 1: //derecha a izquierda
	
					if (b.getX() < -50) {
						out = true;
					} else {
						b.setX(b.getX() - 5);
						b.actualizaEsquinas(b.getX(), b.getY());
					}
					
					break;
					
				case 2: //arriba a abajo
					
					if (b.getY() > 670) {
						out = true;
					} else {
						b.setY(b.getY() + 5);
						b.actualizaEsquinas(b.getX(), b.getY());
					}
					
					break;
					
				case 3: //abajo a arriba

					if (b.getY() < -50) {
						out = true;
					} else{
						b.setY(b.getY() - 5);
						b.actualizaEsquinas(b.getX(), b.getY());
					}
					
					break;
					
				}
				
				
				//Ir cambiando fotos
				if (b.getImagen() == 9) {
					b.setImagen(0);
				} else {
					b.setImagen(b.getImagen() + 1);
				}
				
				if (out) {
					bolas.remove(i);
				} else {
					bolas.set(i, b);
				}
				
				
			}
			
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	


	public ArrayList<Bola> getBolas() {
		return bolas;
	}


	public void setBolas(ArrayList<Bola> bolas) {
		this.bolas = bolas;
	}


	
}
