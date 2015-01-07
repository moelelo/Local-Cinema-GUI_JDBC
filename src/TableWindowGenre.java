import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableWindowGenre {

		public TableWindowGenre(String dName) {
			
			JFrame fram = new JFrame();
			TableModelGenre model1 = new TableModelGenre(dName);
			fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			fram.setSize(1100,300);			
			JTable t2 = new JTable(model1);
			
			fram.add(new JScrollPane(t2));
			fram.setVisible(true);
	}
}
	
