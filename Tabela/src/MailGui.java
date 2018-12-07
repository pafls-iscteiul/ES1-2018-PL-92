import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import twitter4j.TwitterException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class MailGui extends JFrame {
	private JPanel contentPane;
	private JTextArea tArea;
	private JScrollPane pane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailGui frame = new MailGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MailGui() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		tArea =new JTextArea();
		tArea.setBounds(10, 97, 515, 436);	
		pane = new JScrollPane(tArea);
		pane.setBounds(10, 97, 515, 436);
		contentPane.add(pane);

		JLabel label1 = new JLabel("");
		java.awt.Image img1 = new ImageIcon (this.getClass().getResource("/hat.png")).getImage();
		label1.setIcon(new ImageIcon(img1));
		label1.setBounds(721, 11, 103, 96);
		contentPane.add(label1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(564, 328, 242, 171);
		contentPane.add(textArea);
		

		
		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		lblBomDiaAcademia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblBomDiaAcademia.setBounds(564, 72, 156, 35);
		contentPane.add(lblBomDiaAcademia);

		JLabel label2 = new JLabel("");
		java.awt.Image img2 = new ImageIcon (this.getClass().getResource("/GI.png")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(574, 118, 134, 135);
		contentPane.add(label2);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				try {
					enviaMails(a);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				textArea.setText("");
			}
		});
		btnEnviar.setBounds(717, 510, 89, 23);
		getContentPane().add(btnEnviar);

	
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<String> lista = loadFeed();
					for(String a : lista){
						tArea.append(a + "\n");
					}	
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnLoad.setBounds(717, 294, 89, 23);
		contentPane.add(btnLoad);
	}


	public ArrayList<String> loadFeed() throws FileNotFoundException {
		Mail a= new Mail();
		return a.downloadEmails();
	}

	public void enviaMails(String a)  throws FileNotFoundException {
		Mail m= new Mail();
		m.sendEmails(a); 
	}

}