
public class AyudanteExplosion implements Runnable{

	MiPanel l;
	int posicion, x, y;
	boolean choque;
	
	public AyudanteExplosion (MiPanel l) {
		this.l = l;
		this.choque = false;
		this.posicion = 0;
		this.x = 10000;
		this.y = 10000;
	}
	
	
	@Override
	public void run() {
		
		while (true) {

				if (this.posicion == 7) {
					this.posicion = 0;
				} else {
					this.posicion++;
				}
				
				l.repaint();
				
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
	}

	
	public int getPosicion() {
		return posicion;
	}


	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}


	public boolean isChoque() {
		return choque;
	}


	public void setChoque(boolean choque) {
		this.choque = choque;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}

	
	
}
