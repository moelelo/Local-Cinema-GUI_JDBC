import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;


public class Menu extends JFrame {

	private JPanel contentPane;
	private String movi_name;
	private String movie_title;
	private String driverName = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql://";
	private String serverName = "localhost";
	private String port = "3306";
	private String dataBaseName = "ITS330Project";
	private String url=protocol+serverName+":"+port+"/"+dataBaseName;

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public Menu() {
		setTitle("Database Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add");
		mnAdd.setIcon(new ImageIcon(Menu.class.getResource("/res/Add.gif")));
		menuBar.add(mnAdd);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Movie");
		mntmNewMenuItem.setIcon(new ImageIcon(Menu.class.getResource("/res/Film.gif")));
		mnAdd.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddMovie g = new AddMovie();
			}
			
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Actor");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Menu.class.getResource("/res/Male.gif")));
		mnAdd.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddActor g = new AddActor();
			}
			
		});
		
		JMenuItem mntmAdd = new JMenuItem("Add Director");
		mntmAdd.setIcon(new ImageIcon(Menu.class.getResource("/res/Person.gif")));
		mnAdd.add(mntmAdd);
		
		mntmAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDirector g = new AddDirector();
			}
			
		});
		
		JMenu mnSearch = new JMenu("Search");
		mnSearch.setIcon(new ImageIcon(Menu.class.getResource("/res/Search.gif")));
		menuBar.add(mnSearch);
		
		JMenuItem mntmByMovieName = new JMenuItem("By Movie Name");
		mntmByMovieName.setIcon(new ImageIcon(Menu.class.getResource("/res/Film.gif")));
		mnSearch.add(mntmByMovieName);
			
		mntmByMovieName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				movi_name = JOptionPane.showInputDialog("Enter Movie Name to Search in database");
				Search_Edit_Movie d = new Search_Edit_Movie();
				d.setMovieTitle2(movi_name);
				d.searchMovie();		
			}
			
		});
		
		JMenuItem mntmByDirector = new JMenuItem("By Director");
		mntmByDirector.setIcon(new ImageIcon(Menu.class.getResource("/res/Person.gif")));
		mnSearch.add(mntmByDirector);
		
		mntmByDirector.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String director_name = JOptionPane.showInputDialog("Please Enter the director Name");
				TableWindowDirector t = new TableWindowDirector(director_name);
			}
			
		});
		
		JMenuItem mntmByGenre = new JMenuItem("By Genre");
		mntmByGenre.setIcon(new ImageIcon(Menu.class.getResource("/res/Zoom.gif")));
		mnSearch.add(mntmByGenre);
		
		JMenuItem searchByYear = new JMenuItem("By Year");
		searchByYear.setIcon(new ImageIcon(Menu.class.getResource("/res/Zoom.gif")));
		mnSearch.add(searchByYear);
		
		searchByYear.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String year = JOptionPane.showInputDialog("Please Enter the year you want to search on");
				TableWindowYear t2 = new TableWindowYear(year);	

				
			}
			
		});
		
		JMenuItem actorSearch = new JMenuItem("By Actor");
		actorSearch.setIcon(new ImageIcon(Menu.class.getResource("/res/Zoom.gif")));
		mnSearch.add(actorSearch);
		
		actorSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String actor = JOptionPane.showInputDialog("Please Enter the actor you want to search on");
				TableWindowActor t2 = new TableWindowActor(actor);	
			}
			
		});
		mntmByGenre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String genre_name = JOptionPane.showInputDialog("Please Enter the genre Name");
				TableWindowGenre t2 = new TableWindowGenre(genre_name);	
			}
			
		});
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setIcon(new ImageIcon(Menu.class.getResource("/res/About.gif")));
		menuBar.add(mnEdit);
		
		JMenuItem editMovie = new JMenuItem("Update a movie");
		editMovie.setIcon(new ImageIcon(Menu.class.getResource("/res/Create.gif")));
		mnEdit.add(editMovie);
		
		editMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				movie_title = JOptionPane.showInputDialog("Please Insert the Title of the movie you want to edit!");
				Search_Edit_Movie s = new Search_Edit_Movie();
				s.setMovieTitle2(movie_title);
				s.EditMovie();
			}
			
		});
		
		JMenuItem deleteMovie = new JMenuItem("Delete a movie");
		deleteMovie.setIcon(new ImageIcon(Menu.class.getResource("/res/Delete.gif")));
		mnEdit.add(deleteMovie);
		
		deleteMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String movie_ID = null;
				movie_title = JOptionPane.showInputDialog("Please Insert the Title of the movie you want to edit!");
				
				try {
					String id_query="Select movieID from movie where movieTitle = '" + movie_title + "';";
					connection = DriverManager.getConnection(url,"root","ITS330");
					statement = connection.createStatement();
					resultSet=statement.executeQuery(id_query);
					
					while(resultSet.next()){
						movie_ID=resultSet.getString("movieID");
					}
					
					statement.executeUpdate("delete from movie_has_genre where Movie_movieID = '" + movie_ID + "';");
					statement.executeUpdate("delete from movie_has_rating where Movie_movieID = '" + movie_ID + "';");
					String delete_query = "delete from movie where movieID = '" + movie_ID + "';";
					statement.executeUpdate(delete_query);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
			
		});
		
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon(Menu.class.getResource("/res/User group.gif")));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		
		mntmAboutUs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Awesome Movie DB. Copyright 2014", "About Us", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/People.gif")));
			}
			
		});
		mnHelp.add(mntmAboutUs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/res/Movie_MainPicutre.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 541, Short.MAX_VALUE)
		);
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
}
