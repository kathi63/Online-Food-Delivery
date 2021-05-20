package onlineFoodDelivery;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class login {
//	DBConn dc = new DBConn();
	
	private Connection con;
	private Statement st,st1;
	private ResultSet rs,rs1;

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(200,50,1000,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		username = new JTextField();
		
		username.setBounds(481, 173, 231, 31);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnNewButton = new JButton("Signin");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/online_food_delivery?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
					st=con.createStatement();
					String sql= "Select * from adminlogin where username='"+username.getText()+"'and password='"+password.getText()+"'";
					rs=st.executeQuery(sql);
					
					if(rs.next()) {
						
						st1=con.createStatement();
						String sql1= "Select Name from adminlogin where username='"+username.getText()+"'";
						rs1=st1.executeQuery(sql1);
						
						if(rs1.next()) {
							String pass = rs1.getString(1);
							String[] arr = new String[1];
							arr[0] = pass;
							Admin.main(arr);
							frame.dispose();
							
						}
						
						
					}
					else
						JOptionPane.showMessageDialog(null, "username and password are incorrert........");
					
					
				
				}catch(Exception ex) {
					System.out.println("Erro"+ex);
				}
				
			}

			
		});
		btnNewButton.setBounds(409, 306, 231, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblLogin = new JLabel("Admin Login");
		lblLogin.setForeground(Color.MAGENTA);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(385, 95, 231, 45);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(372, 171, 90, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(372, 227, 99, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginType.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(22, 22, 69, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		password = new JPasswordField();
		password.setBounds(481, 227, 231, 31);
		frame.getContentPane().add(password);
	}
}
