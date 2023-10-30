
public class Puntuacion {

	int puntos = 0; 
	
	public Puntuacion (int puntos) {
		this.puntos = puntos;
	}
	
	public void sumaPuntos (int num) {
		puntos += num;
	}
	
	public void restaPuntos (int num) {
		puntos -= num;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
