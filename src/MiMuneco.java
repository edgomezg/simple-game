import java.lang.reflect.Array;

public class MiMuneco {
	int x, y, direccion;
	int posicion = 0;
	//Esquinas del cuadrado que ocupa
	int[][] esquinas = new int[4][2];
	
	//Direccion 1 = Abajo
	//Direccion 2 = Arriba
	//Direccion 3 = izquierda
	//Direccion 4 = derecha
	
	public MiMuneco() {
		//this.x=(int)(Math.random()*720);
		//this.y=(int)(Math.random()*720);
		this.x = 500;
		this.y = 300;
		direccion =(int)(Math.random()*4);
		
		
		actualizaEsquinas(this.x, this.y);
	}
	
	
	public void actualizaEsquinas( int x, int y) {
		//Referencia la esquina 0
		this.esquinas[0][0] = x;
		this.esquinas[0][1] = y;				
		
		this.esquinas[1][0] = x + 70;
		this.esquinas[1][1] = y;
		
		this.esquinas[2][0] = x + 70;
		this.esquinas[2][1] = y + 89;
		
		this.esquinas[3][0] = x - 70;
		this.esquinas[3][1] = y - 89;
	
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
