import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MiPanel extends JPanel implements KeyListener{

	Image fondo, elfo_vida, totem_image, gameover;
	Vidas vi;
	Puntuacion puntos;
	
	Image [] numeros_punt = new Image[10];
	Image [] bolafuego = new Image[10];
	Image munecosabajo []= new Image[10];
	Image munecosarriba []= new Image[10];
	Image munecosderecha []= new Image[10];
	Image munecosizquierda []= new Image[10];
	Image [] disparo = new Image[4];
	Image [] explosion = new Image [8];
	
	Totem totem = new Totem();
	AyudanteTotem ayT = new AyudanteTotem(this, totem);
	
	ArrayList<Bola> bolas = new ArrayList<Bola>();
	AyudanteBola ayB = new AyudanteBola(this, bolas);
	AyudanteCreaBola ayCB = new AyudanteCreaBola(bolas, ayB);
	ArrayList<BolaMagia> bolasmag = new ArrayList<BolaMagia>();
	
	MiMuneco muneco = new MiMuneco();
	
	AyudanteMagia aym = new AyudanteMagia(bolasmag, this);
	AyudanteExplosion ayE = new AyudanteExplosion(this);
	


	
	public MiPanel () {
						
		//Carga de imagenes
		Toolkit t = Toolkit.getDefaultToolkit();
		fondo = t.getImage(getClass().getResource("/material/fondo/fondo.jpg"));
		elfo_vida = t.getImage(getClass().getResource("/material/elfos/vida.png"));
		totem_image = t.getImage(getClass().getResource("/material/totem/totem.png"));
		vi = new Vidas(3);
		puntos = new Puntuacion(0);
		gameover = t.getImage(getClass().getResource("/material/gameover/gameover.png"));
		
		for (int i = 0; i < 10; i++) {
			
			if (i == 9) {
				munecosabajo[i]= t.getImage(getClass().getResource("/material/elfos/abajo"+(i+1)+".png"));
				munecosarriba[i]= t.getImage(getClass().getResource("/material/elfos/arriba"+(i+1)+".png"));
				munecosderecha[i]= t.getImage(getClass().getResource("/material/elfos/derecha"+(i+1)+".png"));
				munecosizquierda[i]= t.getImage(getClass().getResource("/material/elfos/izquierda"+(i+1)+".png"));
			} else {
				munecosabajo[i]= t.getImage(getClass().getResource("/material/elfos/abajo0"+(i+1)+".png"));
				munecosarriba[i]= t.getImage(getClass().getResource("/material/elfos/arriba0"+(i+1)+".png"));
				munecosderecha[i]= t.getImage(getClass().getResource("/material/elfos/derecha0"+(i+1)+".png"));
				munecosizquierda[i]= t.getImage(getClass().getResource("/material/elfos/izquierda0"+(i+1)+".png"));
			}
			
			if (i < 4) {
				disparo[i] = t.getImage(getClass().getResource("/material/disparo/disparo0"+(i+1)+".png"));
			}
			
			if (i < 7) {
				explosion[i] = t.getImage(getClass().getResource("/material/explosion/explosion0"+(i+1)+".png"));
			}
				
			numeros_punt[i] = t.getImage(getClass().getResource("/material/puntuacion/" + i + ".png"));
			bolafuego[i] = t.getImage(getClass().getResource("/material/bola de fuego/bola0" + i + ".png"));

		}

		
		//Hilo AyudanteTotem
		Thread tot = new Thread(ayT);
		tot.start();
		
		//Hilo AyudanteBola
		Thread bol = new Thread(ayB);
		bol.start();
		Thread Cbol = new Thread(ayCB);
		Cbol.start();
		
		//Hilo AyudanteMagia
		Thread mag = new Thread(aym);
		mag.start();
		
		//Hilo AyudanteExplosion
		Thread exp = new Thread(ayE);
		exp.start();

	}
	
	@Override
	public void paint (Graphics g) {

		super.paint(g);
				
		//Dibujo fondo
		g.drawImage(fondo, -30, -50, this);
		
		//Dibujo vidas
		switch (vi.getNum()) {

		case 1:
			
			g.drawImage(elfo_vida, 5, 5, this);
			
			break;
		case 2:
			
			g.drawImage(elfo_vida, 5, 5, this);
			g.drawImage(elfo_vida, 35, 5, this);
			
			break;
		case 3:
			
			g.drawImage(elfo_vida, 5, 5, this);
			g.drawImage(elfo_vida, 35, 5, this);
			g.drawImage(elfo_vida, 65, 5, this);
			
			break;
		}
		
		//Dibujo puntuacion
		if (puntos.getPuntos() < 10) {
			g.drawImage(numeros_punt[puntos.getPuntos()], 1050, 20, this);
		} else {
			String p = String.valueOf(puntos.getPuntos());
			
			for (int i = p.length() - 1; i >= 0; i--) {
				g.drawImage(numeros_punt[Character.getNumericValue(p.charAt(i))], 1050-20*(p.length() - 1 - i), 20, this);
			}
		}
		
				
		//Muneco
		//Datos del muneco
		int posicion = muneco.getPosicion();
		int dir = muneco.getDireccion();
		int auxx = muneco.getX();
		int auxy = muneco.getY();		

		
		switch (dir) {
		case 1:
			g.drawImage(munecosabajo[posicion], auxx, auxy, this);
			//g.drawImage(munecosabajo[posicion], auxx, auxy, 70, 93, this);
			break;
			
		case 2:
			//g.drawImage(munecosarriba[posicion], auxx, auxy, this);
			g.drawImage(munecosarriba[posicion], auxx, auxy, 70, 93, this);
			break;
		
		case 3:
			g.drawImage(munecosizquierda[posicion], auxx, auxy, this);
			//g.drawImage(munecosizquierda[posicion], auxx, auxy, 90, 86, this);
			break;
		
		case 4:
			//g.drawImage(munecosderecha[posicion], auxx, auxy, this);
			g.drawImage(munecosderecha[posicion], auxx, auxy, 100, 101, this);
			break;
		}
		//g.drawRect(muneco.getEsquinas()[0][0], muneco.getEsquinas()[0][1], muneco.getEsquinas()[1][0] - muneco.getEsquinas()[0][0], muneco.getEsquinas()[2][1] - muneco.getEsquinas()[1][1]);
		
		
		//Bolas magia
		for (int i = 0; i < bolasmag.size(); i++) {
			
			int x2 = aym.getBolas().get(i).getX() + 100;
			int y2 = aym.getBolas().get(i).getY() + 100;
			int pos2 = aym.getBolas().get(i).getPosicion();
			
			g.drawImage(disparo[pos2], x2, y2, this);	
			//g.drawRect(aym.getBolas().get(i).getEsquinas()[0][0], aym.getBolas().get(i).getEsquinas()[0][1], aym.getBolas().get(i).getEsquinas()[1][0] - aym.getBolas().get(i).getEsquinas()[0][0], aym.getBolas().get(i).getEsquinas()[3][1] - aym.getBolas().get(i).getEsquinas()[1][1]);
		}
		
	
		//Totem
		g.drawImage(totem_image, ayT.getTotem().getX(), ayT.getTotem().getY(), this);
		//g.drawRect(ayT.getTotem().getEsquinas()[0][0], ayT.getTotem().getEsquinas()[0][1], ayT.getTotem().getEsquinas()[1][0] - ayT.getTotem().getEsquinas()[0][0], ayT.getTotem().getEsquinas()[2][1] - ayT.getTotem().getEsquinas()[1][1]);
		
		//Bolas de fuego
		for (int i = ayB.getBolas().size() - 1; i >= 0; i--) {
			if (i < ayB.getBolas().size()) {
				g.drawImage(bolafuego[ayB.getBolas().get(i).getImagen()], ayB.getBolas().get(i).getX(), ayB.getBolas().get(i).getY(), this);
				//g.drawRect(ayB.getBolas().get(i).getEsquinas()[0][0], ayB.getBolas().get(i).getEsquinas()[0][1], ayB.getBolas().get(i).getEsquinas()[1][0] - ayB.getBolas().get(i).getEsquinas()[0][0], ayB.getBolas().get(i).getEsquinas()[3][1] - ayB.getBolas().get(i).getEsquinas()[1][1]);
			} 
		}
		
		//Explosiones
		if (ayE.isChoque()) { //Solo hago la foto si hay un choque entre bolas de fuego y magia
			
			g.drawImage(explosion[ayE.getPosicion()], ayE.getX(), ayE.getY(), this);
			
			if (ayE.getPosicion() == 7) {
				ayE.setChoque(false);
			}
		}
		
		
		

		//Choques muneco-totem
		
		//Muneco entra por la izquierda		
		if ((Math.abs(muneco.getEsquinas()[1][0] - ayT.getTotem().getEsquinas()[0][0]) <= 3) && (Math.abs(muneco.getEsquinas()[1][1] - ayT.getTotem().getEsquinas()[0][1]) <= 70)) { 
			//System.out.println("toque-i");
			//Llevo el totem fuera			
			ayT.getTotem().setX(10000);
			ayT.getTotem().setY(10000);
			ayT.getTotem().actualizaEsquinas(ayT.getTotem().getX(), ayT.getTotem().getY());
			
			//Sumo puntos
			puntos.setPuntos(puntos.getPuntos() + 50);
			
			this.repaint();
		}
		
		//Muneco entra por derecha
		else if ((Math.abs(muneco.getEsquinas()[0][0] - ayT.getTotem().getEsquinas()[1][0]) <= 3) && (Math.abs(muneco.getEsquinas()[0][1] - ayT.getTotem().getEsquinas()[1][1]) <= 70)){
			//System.out.println("toque-d");
			//Llevo el totem fuera
			ayT.getTotem().setX(10000);
			ayT.getTotem().setY(10000);
			ayT.getTotem().actualizaEsquinas(ayT.getTotem().getX(), ayT.getTotem().getY());
			
			//Sumo puntos
			puntos.setPuntos(puntos.getPuntos() + 50);
			
			this.repaint();
		}
		
		//Muneco entra por abajo
		else if ((muneco.getEsquinas()[0][0] - ayT.getTotem().getEsquinas()[3][0] >= -10) && (muneco.getEsquinas()[0][0] - ayT.getTotem().getEsquinas()[3][0] <= 140) && (Math.abs(muneco.getEsquinas()[0][1] - ayT.getTotem().getEsquinas()[3][1]) <= 3)){
			//System.out.println("toque-ab");
			//Llevo el totem fuera
			ayT.getTotem().setX(10000);
			ayT.getTotem().setY(10000);
			ayT.getTotem().actualizaEsquinas(ayT.getTotem().getX(), ayT.getTotem().getY());
			
			//Sumo puntos
			puntos.setPuntos(puntos.getPuntos() + 50);
			
			this.repaint();
		}
		
		//Muneco entra por arriba
		else if ((muneco.getEsquinas()[3][0] - ayT.getTotem().getEsquinas()[0][0] <= 20) && (muneco.getEsquinas()[3][0] - ayT.getTotem().getEsquinas()[0][0] >= -140) && (Math.abs(muneco.getEsquinas()[3][1] - ayT.getTotem().getEsquinas()[0][1]) <= 3)){
			//System.out.println("toque-ar");
			//Llevo el totem fuera
			ayT.getTotem().setX(10000);
			ayT.getTotem().setY(10000);
			ayT.getTotem().actualizaEsquinas(ayT.getTotem().getX(), ayT.getTotem().getY());
			
			//Sumo puntos
			puntos.setPuntos(puntos.getPuntos() + 50);
			
			this.repaint();
		}
		
		
		//Choques muneco-bolafuego
		
		for( int i = ayB.getBolas().size() - 1; i >= 0; i--) {
			if (i < ayB.getBolas().size() && i != -1) {
				
				Bola bolaF= ayB.getBolas().get(i);
				
				//g.drawRect(bolaF.getEsquinas()[0][0] + 15, bolaF.getEsquinas()[0][1] + 15, 10, 10);
				
				if ((bolaF.getEsquinas()[0][1] + 15 >= muneco.getEsquinas()[0][1] && bolaF.getEsquinas()[0][1] + 15 <= muneco.getEsquinas()[3][1] + 190) && (bolaF.getEsquinas()[0][0] + 15 >= muneco.getEsquinas()[0][0] && bolaF.getEsquinas()[0][0] + 15 <= muneco.getEsquinas()[1][0])) {
					
					//System.out.println(muneco.getEsquinas()[3][1] + " bol " + (bolaF.getEsquinas()[0][1] + 15));
					
					//Elimino la bola
					ayB.getBolas().remove(bolaF);
		
					//Quito 1 vida
					int vida=vi.getNum();
					
					if (vida > 0) {
						vi.quitaVida();
					}
	
					this.repaint();
				}
			}
		}
			
				
		//Choques bola magia con bolas fuego
		for (int i = bolasmag.size() - 1; i >= 0; i--) { 
		
			if (i < bolasmag.size() && i != -1) {
				
				BolaMagia bolaM = aym.getBolas().get(i);
				
				for (int j = ayB.getBolas().size() - 1; j >= 0; j--) {
					
					if (j < ayB.getBolas().size() && j != -1) {
						
						Bola bolaF = ayB.getBolas().get(j);
					
						if ((bolaM.getEsquinas()[1][1] >= bolaF.getEsquinas()[0][1] && bolaM.getEsquinas()[1][1] <= bolaF.getEsquinas()[3][1]) && (bolaM.getEsquinas()[1][0] >= bolaF.getEsquinas()[0][0] && bolaM.getEsquinas()[1][0] <= bolaF.getEsquinas()[1][0])) { 
							
							//Eliminar bola de fuego
							ayB.getBolas().remove(bolaF);
							
							//Explosion
							ayE.setX(bolaF.getX() + 40);
							ayE.setY(bolaF.getY() + 40);
							ayE.setPosicion(0);
							ayE.setChoque(true);
							
							//Sumo puntos
							puntos.setPuntos(puntos.getPuntos() + 5);
							
							this.repaint();
						}
					} 
				}
			}
		}		
		
		//g.drawRect(330, 165, 80, 90); //barril
		//g.drawRect(740, 185, 60, 60); //cofre
		
		//Al morir pantalla de fin
		if (vi.getNum() == 0) {
			g.drawImage(gameover, 0, 0, 1100, 800, this);
		}
	}
	
	

	@Override       
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	boolean toqueI = false, toqueD = false, toqueAr = false, toqueAb = false; //variables usadas para choques con objetos
	
	@Override
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		int x = muneco.getX();
		int y = muneco.getY();
		
		
		switch (tecla) {
		
		case 48: //Pulsacion de 0 para volver a jugar
			
			if (vi.getNum() == 0) {
				vi.setNum(3);
				puntos.setPuntos(0);
				muneco.setX(500);
				muneco.setY(300);
			}
			
		break;
		
		case 49: //Pulsacion de 1 para salir
			
			if (vi.getNum() == 0) {
				System.exit(0);
			}
			
		break;
		
		case 32 : 
			//Pulsamos la barra espaciadora
			BolaMagia b = new BolaMagia();
			
			switch (muneco.getDireccion()) {
			case 1:
				b.setX(x - 80);
				b.setY(y);
				b.actualizaEsquinas(b.getX(), b.getY());
				break;
				
			case 2:
				b.setX(x - 80);
				b.setY(y - 140);
				b.actualizaEsquinas(b.getX(), b.getY());
				break;
				
			case 3:
				b.setX(x - 120);
				b.setY(y - 70);
				b.actualizaEsquinas(b.getX(), b.getY());
				break;
				
			case 4: 
				b.setX(x);
				b.setY(y - 70);
				b.actualizaEsquinas(b.getX(), b.getY());
				break;
			}

			b.setDireccion(muneco.getDireccion());
			b.setPosicion(0);
			bolasmag.add(b);

			break;
			 
		case 37 :   
			
			//System.out.println(toqueI + " " + toqueD +  " " + toqueAr + " " + toqueAb);

			//Izquierda 
			if (x > 45) {
				if (((x >= 410) || (y >= 250 || y + 85 <= 165)) && ((x >= 800) || (y >= 240 || y + 85 <= 185))) {
					
					muneco.setX(x - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					toqueI = false;
					
				} 
	
				else if (toqueD || toqueAr || toqueAb) {
					
					muneco.setX(x - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				} 
				
				else if (x + 70 <= 325) {
					
					muneco.setX(x - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
				
				else if (x + 70 <= 740 && x >= 410 ) {
					
					muneco.setX(x - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
				
				else {
					toqueI = true;
				}
			}
			
			muneco.setDireccion(3);
			break;
			
		case 38 : 
			
			//System.out.println(toqueI + " " + toqueD +  " " + toqueAr + " " + toqueAb);
			
			//Arriba
			if (y > 10) {
				if (((y >= 250) || (x >= 405 || x + 70 <= 335)) && ((y >= 240) || (x >= 800 || x + 70 <= 740))) {
					
					muneco.setY(y - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					toqueAr = false;
					
				} 
				
				else if (toqueD || toqueI || toqueAb) {
					
					muneco.setY(y - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
				
				} 
				
				else if (y + 89 <= 165) {
					
					muneco.setY(y - 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
							
				
				else {
					toqueAr = true;
				}
			}				
			muneco.setDireccion(2);
			break;
			
		case 39 : 
			
			//System.out.println(toqueI + " " + toqueD +  " " + toqueAr + " " + toqueAb);
			//System.out.println("X: "+ muneco.getX() + " Y: " + muneco.getY());
			//Derecha
			if (x < 950) {
				if (((x + 70 <= 325) || (y >= 250 || y + 89 <= 165) || x > 420) && ((x + 70 <= 740) || (y >= 240 || y + 89 <= 190))) {
					
					muneco.setX(x + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					toqueD = false;
				} 
				
				else if (toqueAr || toqueI || toqueAb) {
					muneco.setX(x + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
				
				else if (x >= 410 && x + 70 <= 740) {
				
					muneco.setX(x + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
				
				else if (x >= 800) {
					
					muneco.setX(x + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
				
				else {
					toqueD = true;
				}
			}
			muneco.setDireccion(4);
			break;
			
		case 40 :
			
			//System.out.println(toqueI + " " + toqueD +  " " + toqueAr + " " + toqueAb);

			//Abajo
			if (y < 600) {
				if (((y + 89 <= 165) || (x >= 405 || x + 70 <= 335)) && ((y + 89 <= 185) || (x >= 800 || x + 70 <= 740))) {
					
					muneco.setY(y + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					toqueAb = false;
				}  
				
				else if (toqueAr || toqueI || toqueD) {
			
					muneco.setY(y + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
			
					
				}
				
				else if (y >= 250) {
					
					muneco.setY(y + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
			
					
				}
				
				else if (y >= 245) {
					
					muneco.setY(y + 7);
					muneco.actualizaEsquinas(muneco.getX(), muneco.getY());
					
				}
				
				else {
					toqueAb = true;
				}
			}				
			muneco.setDireccion(1);
			break;
		}

		
		int posicion = muneco.getPosicion();
		
		if (posicion == 9) {
			muneco.setPosicion(0);
		} else {
			muneco.setPosicion(posicion + 1);
		}
		
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
