import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class TableModelGenre extends AbstractTableModel {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	ResultSet resultSet2;
	ResultSetMetaData rsmd;

	
	
	public TableModelGenre(String Name) {
		// TODO Auto-generated constructor stub
		int id = 0;
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITS330Project","root","ITS330");
			statement = connection.createStatement();
			String getID = "select genreID from genre where genre = '" + Name + "';";
			statement = connection.createStatement();
			resultSet2 = statement.executeQuery(getID);
			
			while (resultSet2.next()) {
				id = resultSet2.getInt("genreID");
			}
			
			
			resultSet = statement.executeQuery("select * from movie, genre, movie_has_genre where movie_has_genre.movie_movieId = movie.movieID" +
					" and movie_has_genre.genre_genreId = genre.genreID and genre.genreID = " + id + ";");
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
	

	
	

}
