import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.sjavac.Log;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login1 extends JFrame {
	  
	JLabel lblNewLabel_1;
	private JPanel contentPane;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	
	
	public Login1() {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot","root","");
//		Statement stmt=con.createStatement();
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 258);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				try {
					s=name.getText();
					Chat2 home = new Chat2();
					home.setVisible(true);
				}catch(Exception e1){
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnNewButton.setBounds(106, 154, 309, 57);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Arial Black", Font.PLAIN, 17));
		name.setBounds(183, 38, 297, 71);
		contentPane.add(name);
		name.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ENTER NAME");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(39, 47, 134, 62);
		contentPane.add(lblNewLabel_1);
	}
}
