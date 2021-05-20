package onlineFoodDelivery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyOrders extends JFrame {
	
	private Connection con;
	private Statement st,st1;
	private ResultSet rs,rs1;
	
	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JButton logout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOrders frame = new MyOrders(args[0]);
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
	public MyOrders(String pass) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,50,1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/online_food_delivery?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
				
				st=con.createStatement();
				String sqll="Select CustomerName from orders where CustomerName='"+pass+"'";
				rs= st.executeQuery(sqll);
				int length = 0;
				
				
				int i = 0;
				while(rs.next())
				{
					length++;
				}
				
				Object[][] data = new Object[length][6];
				st1=con.createStatement();
				String sql="Select OrderId,ItemId,RestaurentName,ItemName,Quantity,Amount from orders where CustomerName='"+pass+"'";
				rs1= st1.executeQuery(sql);
				while(rs1.next())
				{
					data[i][0] = rs1.getString(1);				
					data[i][1] = rs1.getString(2);
					data[i][2] = rs1.getString(3);
					data[i][3] = rs1.getString(4);
					data[i][4] = rs1.getString(5);
					data[i][5] = rs1.getString(6);
					i++;
				}
				String[] columns = {"OrderId","ItemId","RestaurentName","ItemName","No's","Amount"};
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(120, 116, 739, 416);
				contentPane.add(scrollPane);
				
				table = new JTable(data,columns);
				scrollPane.setViewportView(table);
						
				JLabel lblYourOrders = new JLabel("your orders");
				lblYourOrders.setForeground(new Color(255, 0, 255));
				lblYourOrders.setFont(new Font("Gabriola", Font.BOLD, 25));
				lblYourOrders.setBounds(120, 56, 268, 46);
				contentPane.add(lblYourOrders);
				
				btnBack = new JButton("back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] arr = new String[1];
						arr[0] = pass;
						OrderItem.main(arr);
						dispose();
					}
				});
				btnBack.setBounds(10, 11, 71, 31);
				contentPane.add(btnBack);
				
				logout = new JButton("logout");
				logout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CustomerLogin.main(null);
						dispose();
					}
				});
				logout.setBackground(new Color(255, 0, 0));
				logout.setForeground(new Color(255, 255, 255));
				logout.setFont(new Font("Tahoma", Font.BOLD, 11));
				logout.setBounds(777, 25, 76, 31);
				contentPane.add(logout);
							
		}catch(Exception ex) {
			System.out.println("Erro : "+ex);
		}
		
	}
}

