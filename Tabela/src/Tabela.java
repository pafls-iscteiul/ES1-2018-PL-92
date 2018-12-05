import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.TextArea;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollBar;


public class Tabela extends JFrame {

	private JPanel contentPane;
	private JScrollPane pane;
	private JTextField textField_3;
	private String search;
	private JTextArea tArea;

	private List<String> listaTweets;
	private List<String> listaMails;
	private List<String> listaPosts;
	File[] file = null;
	private boolean clickedTwitter = false;
	private boolean clickedMail = false;
	private boolean clickedFacebook= false;
	String pathemail = "C:/Users/gabrielaamaral/git/ES1-2018-PL-92/Tabela/src/mail.txt";
	String pathface = "C:/Users/gabrielaamaral/git/ES1-2018-PL-92/Tabela/src/postsFacebook.txt";
	String pathtwet = "C:/Users/gabrielaamaral/git/ES1-2018-PL-92/Tabela/src/tweets.txt";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabela frame = new Tabela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tabela() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogin = new JButton("Load");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tArea.setText("");
				if(isTwitter()) {
					
					ArrayList<String> lista =criaListaTwitter();
					for(String a : lista){
						tArea.append(a + "\n");
					}
					resetTwitterButton();
				}
				if (isMail()) {
					
					ArrayList<String> l =criaListaMail();
					for(String a : l){
						tArea.append(a + "\n");
					}
					resetMailButton();			
				}
				
				else if(isFacebook()) {
					
					ArrayList<String> l =criaListaFacebook();
					for(String a : l){
						tArea.append(a + "\n");
					}
					resetFacebookButton();			
				}
			}
		});	

		btnLogin.setBounds(638, 510, 89, 23);
		contentPane.add(btnLogin);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tArea.setText("");
				String s =textField_3.getText();
				ArrayList<String> a=procura(s);
				
				for(String bb : a){
					tArea.append(bb + "\n");
				}
				
			}
		});
		btnNewButton.setBounds(350, 31, 175, 31);
		contentPane.add(btnNewButton);


		textField_3 = new JTextField();
		textField_3.setBounds(10, 31, 310, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JRadioButton rdbtnTwitter = new JRadioButton("Twitter");
		rdbtnTwitter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedTwitter=true;
				
			}
		});
		rdbtnTwitter.setBounds(638, 350, 109, 23);
		contentPane.add(rdbtnTwitter);

		JRadioButton rdbtnFacebook = new JRadioButton("Facebook");
		rdbtnFacebook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedFacebook=true;
			}
		});
		rdbtnFacebook.setBounds(638, 204, 109, 23);
		contentPane.add(rdbtnFacebook);

		JRadioButton rdbtnEmail = new JRadioButton("E-mail");
		rdbtnEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedMail=true;
			}
		});
		rdbtnEmail.setBounds(638, 469, 109, 23);
		contentPane.add(rdbtnEmail);



		tArea =new JTextArea();
		tArea.setBounds(10, 97, 515, 436);	
		pane = new JScrollPane(tArea);
		pane.setBounds(10, 97, 515, 436);
		contentPane.add(pane);



		JLabel label = new JLabel("");
		java.awt.Image img = new ImageIcon (this.getClass().getResource("/fI.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(625, 114, 122, 113);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		java.awt.Image img2 = new ImageIcon (this.getClass().getResource("/tweetI.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(625, 251, 122, 119);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		java.awt.Image img3 = new ImageIcon (this.getClass().getResource("/GI.png")).getImage();
		label_2.setIcon(new ImageIcon(img3));
		label_2.setBounds(619, 397, 128, 95);
		contentPane.add(label_2);

		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		lblBomDiaAcademia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblBomDiaAcademia.setBounds(580, 49, 167, 35);
		contentPane.add(lblBomDiaAcademia);

		JLabel label_4 = new JLabel("");
		java.awt.Image img4 = new ImageIcon (this.getClass().getResource("/hat.png")).getImage();
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(732, 11, 92, 73);
		contentPane.add(label_4);


	}


	public String getSearch() {
		return search;
	}
	public List<String> readFileTwitter(File f) {
		String line = null;
		f = new File(pathtwet);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				line = s.nextLine();
				listaTweets.add(line);
			}
			s.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return listaTweets;
	}

	public List<String> readFileMail(File f) {
		String line = null;
		f = new File(pathtwet);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				line = s.nextLine();
				listaMails.add(line);
			}
			s.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return listaMails;
	}
	
	public List<String> readFileFacebook(File f) {
		String line = null;
		f = new File(pathface);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				line = s.nextLine();
				listaPosts.add(line);
			}
			s.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return listaPosts;
	}

	public boolean isTwitter() {
		if(clickedTwitter==true) {
			return true;
		}
		return false;
	}

	public boolean isMail() {
		if(clickedMail==true) {
			return true;
		}
		return false;
	}
	
	public boolean isFacebook() {
		if(clickedFacebook==true) {
			return true;
		}
		return false;
	}
	
	public void resetTwitterButton() {
		clickedTwitter=false;	
	}

	public void resetMailButton() {
		clickedMail=false;	
	}
	
	
	public void resetFacebookButton() {
		clickedFacebook=false;	
	}
	
	public ArrayList<String> criaListaTwitter() {
		ArrayList<String> arr = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(pathtwet))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				arr.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public ArrayList<String> criaListaMail() {
		ArrayList<String> d = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(pathemail))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				d.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public ArrayList<String> criaListaFacebook() {
		ArrayList<String> d = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(pathface))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				d.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public ArrayList<String> procura(String a){
		ArrayList<String> s = new ArrayList<String>();
		if(clickedTwitter==true) {
			for(String f: listaTweets) {
				if(f.equals(a)) {
					s.add(f);
				}
			}
		}
		if(clickedMail==true) {
			for(String f: listaMails) {
				if(f.equals(a)) {
					s.add(f);
				}
			}
		}
		if(clickedFacebook==true) {
			for(String f: listaPosts) {
				if(f.equals(a)) {
					s.add(f);
				}
			}
		}
		
		
		return s;
	}
}
