import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableWindowDirector extends JFrame {

	public TableWindowDirector(String dName) {
		
		JFrame fram = new JFrame();
		TableModelDirector model = new TableModelDirector(dName);
		fram.setSize(1100,300);
		JTable t = new JTable(model);
		fram.add(new JScrollPane(t));

		
		fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		fram.setVisible(true);
	}
	
}
