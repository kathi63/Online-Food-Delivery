package onlineFoodDelivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,50,1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToKrap = new JLabel("Welcome to KRAP");
		lblWelcomeToKrap.setForeground(new Color(255, 255, 255));
		lblWelcomeToKrap.setFont(new Font("Gabriola", Font.BOLD, 45));
		lblWelcomeToKrap.setBounds(88, 102, 325, 77);
		contentPane.add(lblWelcomeToKrap);
		
		JLabel lblNewLabel_1 = new JLabel("--Online Food delivery and fast delivery");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(114, 110, 371, 106);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginType.main(null);
				dispose();
			}
		});
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setForeground(new Color(139, 0, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(568, 87, 113, 37);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterType.main(null);
				dispose();
			}
		});
		btnRegister.setBackground(new Color(50, 205, 50));
		btnRegister.setForeground(new Color(139, 0, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(703, 87, 113, 37);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yours\\Pictures\\10-Italian-Fun-Facts-The-Food-Fashion-and-Culture-of-Italy.jpg"));
		lblNewLabel.setBounds(21, 38, 923, 442);
		contentPane.add(lblNewLabel);
	}
}
