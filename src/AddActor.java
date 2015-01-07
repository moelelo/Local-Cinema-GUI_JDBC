import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddActor extends JFrame {

	private JPanel contentPane;
	private JTextField actorFName;
	private JTextField actorLName;
	private JTextField actorGender;
	private JButton submitActor;
	private JButton cancelActor;

	public AddActor() {
		
		setTitle("Add Actor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("First Name");
		
		actorFName = new JTextField();
		actorFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		
		actorLName = new JTextField();
		actorLName.setColumns(10);
		
		JLabel lblGenderMf = new JLabel("Gender M/F");
		
		actorGender = new JTextField();
		actorGender.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246, 221, 185));
		
		submitActor = new JButton("Submit");
		submitActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (actorFName.getText().isEmpty() || actorLName.getText().isEmpty() || actorGender.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields are necessary", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/Alert.gif")));
				}
				else {
					MovieDatabase data = new MovieDatabase();
					data.addActor(actorFName.getText(), actorLName.getText(), actorGender.getText());
					JOptionPane.showMessageDialog(null, "Thank You!", "Add Actor", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(AddDirector.class.getResource("/res/OK.gif")));

				}
			}
		});
		submitActor.setIcon(new ImageIcon(AddActor.class.getResource("/res/OK.gif")));
		
		cancelActor = new JButton("Cancel");
		
		cancelActor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		
		cancelActor.setIcon(new ImageIcon(AddActor.class.getResource("/res/Close.gif")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 310, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(submitActor, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(cancelActor, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 71, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cancelActor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(submitActor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGenderMf, Alignment.TRAILING)
						.addComponent(lblLastName, Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.TRAILING))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(actorGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(actorLName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addComponent(actorFName, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(233, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(actorFName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(actorLName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenderMf)
						.addComponent(actorGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(231)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);

	}

}
