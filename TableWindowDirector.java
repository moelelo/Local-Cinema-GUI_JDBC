import javax.swing.JFrame;
import javax.swing.JTable;


public class TableWindowDirector extends JFrame {

	public TableWindowDirector(String dName) {
		
		JFrame fram = new JFrame();
		TableModelDirector model = new TableModelDirector(dName);
		fram.setSize(500,500);
		JTable t = new JTable(model);
		fram.add(t);

		
		
		fram.setVisible(true);
	}
	
}
