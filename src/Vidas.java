public class Vidas {

	int num;
	
	public Vidas(int num) {
		this.num = num;
	}
	
	public void quitaVida () {
		num = num - 1;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}	
}
