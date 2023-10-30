import java.util.ArrayList;

public class AyudanteMagia implements Runnable {
	
	ArrayList<BolaMagia>bolas;
	MiPanel l;
	
	
	public AyudanteMagia(ArrayList<BolaMagia> bolas,MiPanel l) {
		this.bolas=bolas;
		this.l=l;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			for (int i = 0; i < bolas.size(); i++) {
				BolaMagia b = bolas.get(i);
				int posicion = b.getPosicion();

				if (posicion == 3) {
					posicion = 0;
				} else {
					posicion++;
				}
				
				int x = b.getX();
				int y = b.getY();
				
				int direccion = b.getDireccion();
				
				switch (direccion) {
				case 1 : 
					b.setY(y + 7);
					b.actualizaEsquinas(b.getX(), b.getY());
					break;
					
				case 2 : 
					b.setY(y - 7);
					b.actualizaEsquinas(b.getX(), b.getY());
					break;
					
				case 3 : 
					b.setX(x - 7);
					b.actualizaEsquinas(b.getX(), b.getY());
					break;
				
				case 4 :
					b.setX(x + 7);
					b.actualizaEsquinas(b.getX(), b.getY());
					break;
				}
					
				b.setPosicion(posicion);
				bolas.set(i, b);				
			}
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			l.repaint();
		}
	}

	public ArrayList<BolaMagia> getBolas() {
		return bolas;
	}

	public void setBolas(ArrayList<BolaMagia> bolas) {
		this.bolas = bolas;
	}
	
}