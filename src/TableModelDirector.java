import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;


public class TableModelDirector extends AbstractTableModel {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	ResultSet resultSet2;
	ResultSetMetaData rsmd;
	private String name;

	
	
	public TableModelDirector(String Name) {
		// TODO Auto-generated constructor stub
		int id = 0;
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITS330Project","root","ITS330");
			statement = connection.createStatement();
			String getID = "select directorID from director where directorName = '" + Name + "';";
			statement = connection.createStatement();
			resultSet2 = statement.executeQuery(getID);
			
			while (resultSet2.next()) {
				id = resultSet2.getInt("directorID");
			}
			resultSet = statement.executeQuery("Select * from movie where Director_directorID = " + id + ";");
			rsmd = resultSet.getMetaData();

			fireTableStructureChanged();
			
		} catch(SQLException sqlException){
			System.out.println("Error: "+sqlException.getMessage());
		}
	}
	
	@Override
	public String getColumnName(int column) {
		
		try {
			return rsmd.getColumnLabel(column + 1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		int colCount=0;

		if(rsmd!=null){
			try {
				colCount = rsmd.getColumnCount();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return colCount;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(resultSet!=null){
			try{
				resultSet.last();
				int rc = resultSet.getRow();
				return rc;
			}catch(SQLException sqlException){
				System.out.println("Error: "+sqlException.getMessage());
			}
		}
		return 0;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		
		try {
			resultSet.absolute(row +1);
			
			return resultSet.getObject(col+1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void  setName(String name) {
		this.name = name;
	}
	
	

}
