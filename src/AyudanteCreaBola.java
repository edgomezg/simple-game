import java.util.ArrayList;

public class AyudanteCreaBola implements Runnable{
	
	
	int tiempo;
	ArrayList<Bola> bolas;
	AyudanteBola ayB;
	
	
	public AyudanteCreaBola(ArrayList<Bola> bolas, AyudanteBola ayB) {
		this.bolas = bolas;
		this.ayB = ayB;
	}
	
	public ArrayList<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(ArrayList<Bola> bolas) {
		this.bolas = bolas;
	}

	public AyudanteBola getAyB() {
		return ayB;
	}

	public void setAyB(AyudanteBola ayB) {
		this.ayB = ayB;
	}

	@Override
	public void run() {
		
		while (true) {
			
			
			Bola b = new Bola();
			bolas.add(b);
			
			ayB.setBolas(bolas);
			
			tiempo = (int)(2000 + Math.random()*1000);
			
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
