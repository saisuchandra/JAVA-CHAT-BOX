import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Newques extends JFrame {

	private JPanel contentPane;
	private JTextField questions;
	private JButton btnNewButton;
	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newques frame = new Newques();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Newques() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 274);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questions = new JTextField();
		questions.setFont(new Font("Arial Black", Font.PLAIN, 14));
		questions.setBounds(140, 34, 272, 113);
		contentPane.add(questions);
		questions.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NEW QUES:");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 34, 120, 113);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = questions.getText();
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot","root","");
						Statement stmt=con.createStatement();
				 String qry="insert into newques values(x);";
				 ResultSet rs=stmt.executeQuery(qry);
		         
				 }
				 catch(Exception s) {
		             System.out.println("error");
		         }
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setBounds(118, 186, 184, 41);
		contentPane.add(btnNewButton);
	}

}
