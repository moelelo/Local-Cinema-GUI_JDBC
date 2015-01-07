import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableWindowYear {

	public TableWindowYear(String dName) {
		
		JFrame fram = new JFrame();
		TableModelYear model = new TableModelYear(dName);
		fram.setSize(1100,300);
		JTable t = new JTable(model);
		fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		fram.add(new JScrollPane(t));
		fram.setVisible(true);
	}
}
