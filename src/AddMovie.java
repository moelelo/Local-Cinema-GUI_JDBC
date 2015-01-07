import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;


public class AddMovie extends JFrame {

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

	public AddMovie() {
		MovieDatabase d = new MovieDatabase();

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

		directorCombo = new JComboBox(d.populateDir());
		
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
		
		certificate = new JComboBox(d.populateCert());
		
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
		btnSubmit.setIcon(new ImageIcon(AddMovie.class.getResource("/res/OK.gif")));
		
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (title.getText().isEmpty() || releaseDate.getText().isEmpty() || rating.getText().isEmpty() || genreList.getSelectedIndex() < 0 || time.getText().isEmpty()
						|| language.getText().isEmpty() || certificate.getSelectedIndex() < 0 || plot.getText().isEmpty() || directorCombo.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(null, "All fields are necessary", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/Alert.gif")));
				}
				else if (validateNumber(rating.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Ratings AND Date must be numbers", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/Alert.gif")));					
				}
				else if (!dateValidation() == true) {
					JOptionPane.showMessageDialog(null, "Date must be in YYYY-MM-DD format ", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/Alert.gif")));					
				}
				else {
					MovieDatabase d2 = new MovieDatabase();
					d2.addMovie (title.getText(), releaseDate.getText(), rating.getText(), 
							genreList.getSelectedIndex(), plot.getText(), time.getText(), 
							language.getText(), certificate.getSelectedIndex(), (directorCombo.getSelectedIndex()));
					JOptionPane.showMessageDialog(null, "Thank You!", "Add Movie", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/OK.gif")));

				}
			}
			
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setIcon(new ImageIcon(AddMovie.class.getResource("/res/Close.gif")));
		
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
		

		genreList = new JList(d.populateGenre());
		scrollPane.setViewportView(genreList);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
				 
	}
	
	public boolean validateNumber(String dt) {
		String clr;
		clr = dt.replace("-", "");
		clr = dt.replace(".", "");
		for (int i = 0 ; i < clr.length() ; i ++) {
			if (!Character.isDigit(clr.charAt(i))) {
			return false;
			}
		}
		return true;
	}
	
	public boolean dateValidation() {
		boolean flag = false;
		for (int i = 0 ;  i < releaseDate.getText().length(); i ++) {
			if (releaseDate.getText().length() == 10) {
			if (releaseDate.getText().charAt(i) == '-' && (i >= 4));
				if (releaseDate.getText().charAt(i) == '-' && (i >= 7) )
						return flag = true;
			}
		}
		return flag;
	}
		
}
