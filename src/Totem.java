
public class Totem {

	int x,y;
	
	//Esquinas del cuadrado que ocupa
	int[][] esquinas = new int[4][2];
	
	public Totem () {
		actualizaEsquinas(this.x, this.y);
	}

	
	public void actualizaEsquinas( int x, int y) {
		//Referencia la esquina 0
		this.esquinas[0][0] = x;
		this.esquinas[0][1] = y;				
		
		this.esquinas[1][0] = x + 80;
		this.esquinas[1][1] = y;
		
		this.esquinas[2][0] = x + 80;
		this.esquinas[2][1] = y + 90;
		
		this.esquinas[3][0] = x - 80;
		this.esquinas[3][1] = y - 90;
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

	public int[][] getEsquinas() {
		return esquinas;
	}

	public void setEsquinas(int[][] esquinas) {
		this.esquinas = esquinas;
	}

	
	
	
	
}
