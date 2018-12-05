import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;


public class BaseApp extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private boolean clickedTwitter = false;
	private boolean clickedMail = false;
	private boolean clickedFacebook= false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseApp frame = new BaseApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BaseApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 408, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		lblUser.setBounds(33, 117, 55, 35);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblPassword.setBounds(33, 163, 90, 35);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(158, 126, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				Tabela frame = new Tabela();
				//				frame.setVisible(true);

				if(isTwitter()) {
					TwitterGUI frame = new TwitterGUI();
					frame.setVisible(true);
					resetTwitterButton();
				}
				if (isMail()) {
					MailGui frame = new MailGui();
					frame.setVisible(true);
					resetMailButton();			
				}
				else if(isFacebook()) {
					FacebookGUI frame = new FacebookGUI();
					frame.setVisible(true);
					resetFacebookButton();			
				}
			}
		});

		btnLogin.setBounds(228, 203, 96, 31);
		contentPane.add(btnLogin);

		JLabel label_1 = new JLabel("");
		java.awt.Image img2 = new ImageIcon (this.getClass().getResource("/hat.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(279, 11, 103, 67);
		contentPane.add(label_1);


		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		lblBomDiaAcademia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblBomDiaAcademia.setBounds(33, 37, 224, 35);
		contentPane.add(lblBomDiaAcademia);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnAdd.setBounds(33, 242, 72, 20);
		contentPane.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnRemove.setBounds(115, 242, 90, 20);
		contentPane.add(btnRemove);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 172, 166, 20);
		contentPane.add(passwordField);

		JRadioButton rdbtnT = new JRadioButton("");
		rdbtnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedTwitter=true;

			}
		});
		rdbtnT.setBounds(33, 335, 29, 23);
		contentPane.add(rdbtnT);

		JRadioButton rdbtnF = new JRadioButton("");
		rdbtnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedFacebook=true;
			}
		});
		rdbtnF.setBounds(158, 335, 29, 23);
		contentPane.add(rdbtnF);

		JRadioButton rdbtnG = new JRadioButton("");
		rdbtnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedMail=true;
			}
		});
		rdbtnG.setBounds(279, 335, 29, 23);
		contentPane.add(rdbtnG);

		JLabel labelT = new JLabel("");
		java.awt.Image img4 = new ImageIcon (this.getClass().getResource("/twitter-ICOOON.png")).getImage();
		labelT.setIcon(new ImageIcon(img4));
		labelT.setBounds(33, 286, 72, 72);
		contentPane.add(labelT);

		JLabel labelF = new JLabel("");
		java.awt.Image img5 = new ImageIcon (this.getClass().getResource("/ficn.png")).getImage();
		labelF.setIcon(new ImageIcon(img5));
		labelF.setBounds(158, 286, 72, 72);
		contentPane.add(labelF);

		JLabel labelG = new JLabel("");
		java.awt.Image img6 = new ImageIcon (this.getClass().getResource("/gg.png")).getImage();
		labelG.setIcon(new ImageIcon(img6));
		labelG.setBounds(279, 286, 72, 72);
		contentPane.add(labelG);

	}

	public boolean isTwitter() {
		if(clickedTwitter==true) {
			return true;
		}
		return false;
	}

	public void resetTwitterButton() {
		clickedTwitter=false;	
	}

	public boolean isFacebook() {
		if(clickedFacebook==true) {
			return true;
		}
		return false;
	}

	public void resetFacebookButton() {
		clickedFacebook=false;	
	}
	public boolean isMail() {
		if(clickedMail==true) {
			return true;
		}
		return false;
	}

	public void resetMailButton() {
		clickedMail=false;	
	}



}
