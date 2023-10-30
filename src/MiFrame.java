import javax.swing.JFrame;

public class MiFrame extends JFrame{

	public MiFrame() {
		setSize(1100,800);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		
		MiPanel l = new MiPanel();
		add(l);
		
		l.addKeyListener(l);
		l.setFocusable(true);
	}
	
}
