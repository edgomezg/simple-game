
public class BolaMagia {
	int x;
	int y;
	int posicion = 0;
	int direccion; 
	
	//Esquinas del cuadrado que ocupa
	int[][] esquinas = new int[4][2];
	
	
	
	public BolaMagia() {
		
	}


	public void actualizaEsquinas( int x, int y) {
		//Referencia la esquina 0, ha sido necesario meter un offset de 100 adicional a todas porque detectaba las coordenadas mal
		this.esquinas[0][0] = x + 100;
		this.esquinas[0][1] = y + 100;				
		
		this.esquinas[1][0] = x + 100 + 50;
		this.esquinas[1][1] = y + 100;
	
		this.esquinas[2][0] = x + 100 + 50;
		this.esquinas[2][1] = y + 100 + 50;
	
		this.esquinas[3][0] = x + 100;
		this.esquinas[3][1] = y + 100 + 50;
		

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



	public int getPosicion() {
		return posicion;
	}



	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}



	public int getDireccion() {
		return direccion;
	}



	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	public int[][] getEsquinas() {
		return esquinas;
	}


	public void setEsquinas(int[][] esquinas) {
		this.esquinas = esquinas;
	}
	
	
	
	
}
