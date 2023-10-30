
public class Bola {

	int x, y, direccion, imagen;
	
	//Esquinas del cuadrado que ocupa
	int[][] esquinas = new int[4][2];

	public Bola() {
		this.direccion = (int)(Math.random()*4);
		//this.direccion = 1;
		
		switch (this.direccion) {
		case 0: //izquerda a derecha
			
			this.x = -30;
			this.y = 50 + (int)(Math.random()*560);
			
			break;
			
		case 1: //derecha a izquierda
			
			this.x = 1050;
			this.y = 50 + (int)(Math.random()*560);
			
			break;
			
		case 2: //arriba a abajo
			
			this.x = (int)(Math.random()*950);
			this.y = -50;
			
			break;
			
		case 3: //abajo a arriba
			
			this.x = (int)(Math.random()*950);
			this.y = 770;
			
			break;
			
		}
		
		actualizaEsquinas(this.x, this.y);
		
	}
	
	
	
	public void actualizaEsquinas( int x, int y) {
		//Referencia la esquina 0
		this.esquinas[0][0] = x + 40;
		this.esquinas[0][1] = y + 40;				
		
		this.esquinas[1][0] = x + 70;
		this.esquinas[1][1] = y + 40;
		
		this.esquinas[2][0] = x + 70;
		this.esquinas[2][1] = y + 71;
		
		this.esquinas[3][0] = x + 40;
		this.esquinas[3][1] = y + 71;
	
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
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	public int getImagen() {
		return imagen;
	}

	public void setImagen(int imagen) {
		this.imagen = imagen;
	}



	public int[][] getEsquinas() {
		return esquinas;
	}



	public void setEsquinas(int[][] esquinas) {
		this.esquinas = esquinas;
	}
	
	
}
