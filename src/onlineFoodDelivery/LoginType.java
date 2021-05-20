package onlineFoodDelivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginType extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginType frame = new LoginType();
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
	public LoginType() {
		setBackground(new Color(138, 43, 226));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,50,1000,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(null);
				dispose();
			}
		});
		btnAdminLogin.setBackground(Color.BLUE);
		btnAdminLogin.setForeground(Color.WHITE);
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdminLogin.setBounds(387, 125, 220, 49);
		contentPane.add(btnAdminLogin);
		
		JButton btnRestaurentOwnerLogin = new JButton("Restaurent Owner Login");
		btnRestaurentOwnerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestraurentOwnerLogin.main(null);
				dispose();			
			}
			
		});
		btnRestaurentOwnerLogin.setBackground(Color.GREEN);
		btnRestaurentOwnerLogin.setForeground(Color.WHITE);
		btnRestaurentOwnerLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRestaurentOwnerLogin.setBounds(387, 251, 220, 49);
		contentPane.add(btnRestaurentOwnerLogin);
		
		JButton btnCustomerLogin = new JButton("Customer Login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin.main(null);
				dispose();
			}
		});
		btnCustomerLogin.setBackground(Color.MAGENTA);
		btnCustomerLogin.setForeground(Color.WHITE);
		btnCustomerLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCustomerLogin.setBounds(387, 375, 220, 49);
		contentPane.add(btnCustomerLogin);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(22, 25, 67, 23);
		contentPane.add(btnNewButton);
	}
}
