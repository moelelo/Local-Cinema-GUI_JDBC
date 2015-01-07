import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableWindowActor {
public TableWindowActor(String dName) {
		
		JFrame fram = new JFrame();
		TableModelActor model = new TableModelActor(dName);
		fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fram.setSize(1100,300);
		JTable t = new JTable(model);
		fram.add(new JScrollPane(t));
		fram.setVisible(true);
	}
}
