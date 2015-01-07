import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MovieDatabase {

	private String driverName = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql://";
	private String serverName = "localhost";
	private String port = "3306";
	private String dataBaseName = "ITS330Project";
	
	private String url=protocol+serverName+":"+port+"/"+dataBaseName;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	String user_query;
	String add_movie_query;
	String add_director_query;
	String add_actor_query;
	String search_movie;
	
	private String directorList[];
	private String certifcateMovies[];
	private String genreMovies[];
	
	
	public boolean establishConnection(){
		try{
			Class.forName(driverName);
			connection=DriverManager.getConnection(url,"root","ITS330");
		}
		catch(SQLException sqlException){
			JOptionPane.showMessageDialog(null, "SQLException: "+ sqlException.getMessage());
			return false;
		}
		catch(ClassNotFoundException cnfException){
			JOptionPane.showMessageDialog(null, "Driver not found: "+ cnfException.getMessage());
			return false;
		}
		return true;
	}
	
	public void addActor(String act_name, String act_lname, String act_gender) {
		add_actor_query = "insert into Actor(ActorFirstName, ActorLastName, ActorGender) values ('" + act_name + "','" + act_lname + "','" + act_gender + "');";
		establishConnection();
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(add_actor_query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Driver not found: "+ e.getMessage());
		}
	}
	
	public void addDirector(String dir_name, String dir_gender) {
		add_director_query = "insert into director(directorName, directorGender) values ('" + dir_name + "','" + dir_gender + "');";
		establishConnection();
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(add_director_query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Driver not found: "+ e.getMessage());
		}	
	}
	
	public void addMovie (String mov_title, String mov_date, String mov_rate, 
			int mov_genre, String mov_plot, String mov_time, 
			String mov_lang, int mov_cert, int mov_dir) {
		
		add_movie_query = "insert into movie(movieTitle, movieReleaseDate, movieRunningTime, imdbRating, language, plot, Director_directorID) values ('" + mov_title + "','" + mov_date + "','" + mov_time + "','" + mov_rate + "','" + mov_lang +
				"','" + mov_plot + "'," + (mov_dir+1) + ");";
		establishConnection();
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(add_movie_query, statement.RETURN_GENERATED_KEYS);
			ResultSet keys = statement.getGeneratedKeys(); 
			int key = 0;
			if (keys.next()) {
				key = keys.getInt(1);
			}	
			
			statement.executeUpdate("insert into movie_has_genre (Movie_movieID, Genre_genreID) values ("+key+ "," + ((mov_genre) +1) + ");");
			statement.executeUpdate("insert into Movie_has_Rating (Movie_movieID, Rating_ratingID) values ("+key+ "," + ((mov_cert) +1) + ");");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}	
				
	}
	public boolean varifyLogin(String user_Name, String user_password){
		String x;
		String y;
		user_query="select * from Users;";
		establishConnection();
	
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(user_query);

		while (resultSet.next()) {
			x=resultSet.getString("userName");
			y=resultSet.getString("password");
			
			if (x.equals(user_Name) && y.equals(user_password)) {
				Menu g = new Menu();
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Driver not found: "+ e.getMessage());
		}
		return false;
	}
	
	public String[] populateDir() {
		String dirQuery = "Select * from director;";
		establishConnection();
		
		try {
			statement = connection.createStatement();
			ResultSet Set = statement.executeQuery(dirQuery);
			Set.last();
			int rowNumber = Set.getRow();
			Set.beforeFirst();
			directorList = new String[rowNumber];
			int c = 0;
			while (Set.next()) {
				String Name  = Set.getString("directorName");
				directorList[c] = Name;
				c++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return directorList;
	}

	
	public String[] populateCert() {
		String dirQuery = "Select * from rating;";
		establishConnection();
		
		try {
			statement = connection.createStatement();
			ResultSet Set = statement.executeQuery(dirQuery);
			Set.last();
			int rowNumber = Set.getRow();
			Set.beforeFirst();
			certifcateMovies = new String[rowNumber];
			int c = 0;
			while (Set.next()) {
				String Name  = Set.getString("rating");
				certifcateMovies[c] = Name;
				c++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return certifcateMovies;
	}
	

	public String[] populateGenre() {
		String dirQuery = "Select * from genre;";
		establishConnection();
		
		try {
			statement = connection.createStatement();
			ResultSet Set = statement.executeQuery(dirQuery);
			Set.last();
			int rowNumber = Set.getRow();
			Set.beforeFirst();
			genreMovies = new String[rowNumber];
			int c = 0;
			while (Set.next()) {
				String Name  = Set.getString("genre");
				genreMovies[c] = Name;
				c++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genreMovies;
	}
	
	
}
