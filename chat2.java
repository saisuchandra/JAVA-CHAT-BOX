import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Chat2 extends JFrame {
	JButton btnNewButton;
	JTextArea textarea;
//	String[] strArray1 = {" 1 WHERE CAN I INFO OF STUDENTS PLACED ?"," 2 WHERE CAN I GET THE SYLLABUS BOOK?"," 3 DETAILS OF ALL STAFF MEMBERS?"," 4 WHERE CAN I GET THE DETAILS ABOUT TRANSPORT",
//            " 5 INFO ABOUT ADMISSIONS"," 6 WHERE DO I GET THE INFO ABOUT HOSTELS"," 7 INFO ABOUT THE ED CELL"," 8 ABOUT FOUNDERS"," 9 CONTACT US"};
//    String[] strArray2 = {"http://www.vnrvjiet.ac.in/placement.php","http://www.vnrvjiet.ac.in/bsb.php","http://www.vnrvjiet.ac.in/csefaculty.php",
//            "http://www.vnrvjiet.ac.in/transport.php","http://www.vnrvjiet.ac.in/admission.php","http://www.vnrvjiet.ac.in/hostel.php","http://www.vnrvjiet.ac.in/ed.php","http://www.vnrvjiet.ac.in/founders.php#","http://www.vnrvjiet.ac.in/contactus.php"};
	private JPanel contentPane;
	private JTextField quesno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat2 frame = new Chat2();
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
	public Chat2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD A NEW QUES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Newques help= new Newques();
				help.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.setBounds(293, 452, 196, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ENTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				int n=Integer.parseInt(quesno.getText());
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot","root","");
						Statement stmt=con.createStatement();
				 String qry="SELECT ANSWERS FROM chatbot where sno=n;";
//				 ResultSet rs=stmt.executeQuery(qry);
		         
				 }
				 catch(Exception f) {
		             System.out.println("error");
		         }
				
//				JOptionPane.showMessageDialog(null,rs );
			}
		});
		btnNewButton_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_1.setBounds(35, 451, 206, 57);
		contentPane.add(btnNewButton_1);
		
		JTextArea textarea = new JTextArea();
		textarea.setBackground(new Color(240, 255, 240));
		textarea.setBounds(35, 27, 443, 328);
		contentPane.add(textarea);
		 textarea.append("THESE ARE THE FREQUENTLY ASKED QUESTIONS :"+"\n");
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot","root","");
				Statement stmt=con.createStatement();
		 String qry="SELECT SNo,QUESTIONS FROM chatbot;";
		 ResultSet rs=stmt.executeQuery(qry);
         while(rs.next())
         {
             textarea.append("  "+rs.getString(1)+"\n");
         }

         rs.close();
         stmt.close();
         con.close();
		 }
		 catch(Exception e) {
             System.out.println("error");
         }
		quesno = new JTextField();
		quesno.setToolTipText("ENTER THE QUESTION NUMBER");
		quesno.setBounds(231, 382, 248, 44);
		contentPane.add(quesno);
		quesno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ENTER THE QUES NO. ");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 379, 206, 44);
		contentPane.add(lblNewLabel);
	}
}
