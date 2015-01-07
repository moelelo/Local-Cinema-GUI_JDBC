import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;


public class Search_Edit_Movie extends JFrame {

	private JPanel contentPane;
	private JComboBox certificate;
	private JTextArea plot;
	private JComboBox directorCombo;
	private String formatedDate;
	private JTextField title;
	private JTextField releaseDate;
	private JTextField time;
	private JTextField rating;
	private JTextField language;
	private JButton btnSubmit;
	private JList genreList;
	private JButton cancelButton;

	private String driverName = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql://";
	private String serverName = "localhost";
	private String port = "3306";
	private String dataBaseName = "ITS330Project";
	
	private String url=protocol+serverName+":"+port+"/"+dataBaseName;

	private int certificate_Box ;
	private int director_id;
	private int movie_genre;
	private String movie_date;
	private String movie_rate;
	private String movie_lang;
	private String movie_plot;
	private String movie_time;
	private String moive_title;
	private String movie_title;
	private int movie_id;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private String search_movie;
	private String edit_movie;
	
	private String directorList[];
	private String certifcateMovies[];
	private String genreMovies[];
	

	public Search_Edit_Movie() {
		setTitle("Add Movie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Title");
		
		title = new JTextField();
		title.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director");
		
		populateDir();
		directorCombo = new JComboBox(directorList);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		
		releaseDate = new JTextField();
		releaseDate.setColumns(10);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		
		time = new JTextField();
		time.setColumns(10);
		
		JLabel lblImdbRating = new JLabel("IMDB Rating");
		
		rating = new JTextField();
		rating.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Language");
		
		language = new JTextField();
		language.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCertificate = new JLabel("Certificate");
		
		populateCert();
		certificate = new JComboBox(certifcateMovies);
		
		JLabel lblPlot = new JLabel("Plot");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel moviePicturePanel = new JPanel();
		moviePicturePanel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		moviePicturePanel.setBackground(new Color(246, 221, 185));;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(246, 221, 185));;

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPlot, Alignment.TRAILING)
						.addComponent(lblGenre, Alignment.TRAILING)
						.addComponent(lblImdbRating, Alignment.TRAILING)
						.addComponent(lblReleaseDate, Alignment.TRAILING)
						.addComponent(lblTitle, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRunningTime)
								.addComponent(lblLanguage)
								.addComponent(lblCertificate))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(language, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(certificate, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(moviePicturePanel, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
							.addGap(451))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addComponent(title, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDirector)
					.addGap(18)
					.addComponent(directorCombo, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addComponent(releaseDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(568, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDirector)
							.addComponent(directorCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitle))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(releaseDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblReleaseDate)
								.addComponent(lblRunningTime)
								.addComponent(time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblImdbRating)
								.addComponent(rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLanguage)
								.addComponent(language, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGenre)
								.addComponent(lblCertificate)
								.addComponent(certificate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPlot)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(54, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(moviePicturePanel, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(30))))
		);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(Search_Edit_Movie.class.getResource("/res/OK.gif")));
		
		cancelButton = new JButton("Cancel");
		cancelButton.setIcon(new ImageIcon(Search_Edit_Movie.class.getResource("/res/Close.gif")));
		
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cancelButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSubmit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		plot = new JTextArea();
		scrollPane_1.setViewportView(plot);
		
		populateGenre();
		genreList = new JList(genreMovies);
		scrollPane.setViewportView(genreList);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
				 
		
		
	}
	
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
	
	public void searchMovie () {
		search_movie = "select movieTitle, movieID, movieReleaseDate,  movieRunningTime, imdbRating, language, " +
					"plot from movie where movieTitle = '" + moive_title +"';";
			int movie_id = 0;
			establishConnection();

			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(search_movie);
				
				while (resultSet.next()) {
					
					movie_id = resultSet.getInt("movieID");
					movie_date = resultSet.getString("movieReleaseDate");
					movie_rate = resultSet.getString("imdbRating");
					movie_lang = resultSet.getString("language");
					movie_plot = resultSet.getString("plot");
					movie_time = resultSet.getString("movieRunningTime");
					movie_title = resultSet.getString("movieTitle");
				
					releaseDate.setText(movie_date);
					rating.setText(movie_rate);
					language.setText(movie_lang);
					plot.setText(movie_plot);
					time.setText(movie_time);
					title.setText(movie_title);
					title.setEditable(false);
					
				}
				
				resultSet = statement.executeQuery("select genreID from movie, genre, movie_has_genre where " + "movie_has_genre.movie_movieId = " + movie_id +
					" and movie_has_genre.genre_genreId = genre.genreId;");
				establishConnection();

				while (resultSet.next()) {
					movie_genre = resultSet.getInt("genreID");
					
					genreList.setSelectedIndex(movie_genre-1);
					genreList.ensureIndexIsVisible(movie_genre-1);
				}
				
				resultSet = statement.executeQuery("select Director_directorID from movie where movieId = " + movie_id + ";");
				establishConnection();

				
				while (resultSet.next()) {
					director_id = resultSet.getInt("Director_directorID");
					
					directorCombo.setSelectedIndex(director_id-1);

				}
				
				resultSet = statement.executeQuery("select ratingID from movie, rating, movie_has_rating where " + "movie_has_rating.movie_movieId = " + movie_id +
						" and movie_has_rating.rating_ratingID = rating.ratingID;");
				establishConnection();

				while (resultSet.next()) {
						certificate_Box = resultSet.getInt("ratingID");
						certificate.setSelectedIndex(certificate_Box-1 );
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}	

	}
	
	public void EditMovie() {
		
		search_movie = "select movieTitle, movieID from movie where movieTitle = '" + moive_title + "';";
		establishConnection();
		movie_id = 0;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(search_movie);
			
			while (resultSet.next()) {
				
				movie_id = resultSet.getInt("movieID");
				movie_title = resultSet.getString("movieTitle");
				title.setText(movie_title);
				title.setEditable(false);
				
			} 	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}	
		
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				edit_movie = "update movie set movieReleaseDate = '" + releaseDate.getText() +
						"', movieRunningTime = '" + time.getText() + "', imdbRating = '" + rating.getText() +
						"', language = '" + language.getText() + "', plot = '" + plot.getText() + "', Director_directorID = '" +  (directorCombo.getSelectedIndex()+1) + 
						"' where movieTitle = '" + moive_title + "';";
				
						try {
							statement.executeUpdate(edit_movie);
							establishConnection();

							statement.executeUpdate("update movie_has_genre set genre_genreID =  '" + (genreList.getSelectedIndex()+1) + "' where Movie_movieID = " + movie_id + ";");

							establishConnection();

							
							statement.executeUpdate("update Movie_has_Rating set Rating_ratingID =  '" + (certificate.getSelectedIndex()+1) + "' where Movie_movieID = " + movie_id + ";");
							establishConnection();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
			
		});
	}

	public void setMovieTitle2(String title) {
		this.moive_title = title;
	}
	
	public void populateDir() {
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
	}

	
	public void populateCert() {
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
	}
	

	public void populateGenre() {
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
	}
	
	
}
