
public class AyudanteTotem implements Runnable{

	MiPanel fotografo;
	int tiempo, x, y;
	Totem totem;
	
	public AyudanteTotem(MiPanel fotografo, Totem totem) {
		this.fotografo = fotografo;
		this.totem = totem;
	}
	
	@Override
	public void run() {
		
		while (true) {
		
			fotografo.repaint();
			
			x = 50 + (int)(Math.random() * 900);
			y = 30 + (int)(Math.random() * 679);
			
			//Mientras el totem caiga encima de barriles o cofre volvemos a generar las coordenadas
			while (((x + 80 >= 330 && x <= 420) && (y + 91 >= 165 && y <= 245)) || ((x + 80 >= 740 && x <= 800) && (y + 91 >= 185 && y <= 245))) {
				x = (int)(Math.random() * 1020);
				y = (int)(Math.random() * 709);
				//System.out.println("in");
			}
			totem.setX(x);
			totem.setY(y);
			
			totem.actualizaEsquinas(totem.getX(), totem.getY());
			
			tiempo = 5000 + (int)(Math.random() * 2000);
			
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	public Totem getTotem() {
		return totem;
	}

	public void setTotem(Totem totem) {
		this.totem = totem;
	}


}
