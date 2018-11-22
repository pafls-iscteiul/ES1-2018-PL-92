import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
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

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tweets extends JFrame {

	private JPanel contentPane;
	private JScrollPane pane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private String search;
	private JTextArea tArea;

	private List<String> listaTexto;
	File[] file = null;
	private boolean clickedTwitter = false;

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

	public Tweets() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAccount.setBounds(553, 114, 75, 14);
		contentPane.add(lblAccount);

		textField = new JTextField();
		textField.setBounds(691, 111, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(553, 148, 75, 14);
		contentPane.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setBounds(691, 145, 133, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(622, 284, 89, 23);
		contentPane.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemove.setBounds(622, 318, 89, 23);
		contentPane.add(btnRemove);

		JButton btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModify.setBounds(622, 352, 89, 23);
		contentPane.add(btnModify);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isTwitter()) {
					ArrayList<String> lista =criaLista();
					for(String a : lista){
						tArea.append(a + "\n");
					}
				}
			}
		});	

		btnLogin.setBounds(622, 229, 89, 23);
		contentPane.add(btnLogin);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


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




		rdbtnTwitter.setBounds(701, 188, 109, 23);
		contentPane.add(rdbtnTwitter);

		JRadioButton rdbtnFacebook = new JRadioButton("Facebook");
		rdbtnFacebook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFacebook.setBounds(567, 188, 109, 23);
		contentPane.add(rdbtnFacebook);

		tArea =new JTextArea();
		tArea.setBounds(10, 114, 515, 419);
		//pane=new JScrollPane(tArea);
		contentPane.add(tArea);
	}


	public String getSearch() {
		return search;
	}
	public List<String> readFile(File f) {
		String line = null;
		f = new File("C:/Users/Sofia Cordeiro/git/ES1-2018-PL-92/Tabela/src/tweets.txt");
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				line = s.nextLine();
				listaTexto.add(line);
			}
			s.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return listaTexto;
	}

	public boolean isTwitter() {
		if(clickedTwitter==true) {
			return true;
		}
		return false;
	}

	public ArrayList<String> criaLista() {
		ArrayList<String> arr = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Sofia Cordeiro/git/ES1-2018-PL-92/Tabela/src/tweets.txt"))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				arr.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
//	public ArrayList<String> getDate(){
//		ArrayList<String> lista = criaLista();
//		ArrayList<String> arr = new ArrayList<String>();
//		
//		for(String a : lista){
//			String first_word = a.split("|")[0];	
//			tArea1.append(first_word+ "\n");
//		}
//		
//		return arr;
//	}

	public final class TwitterMain  {
		public void main(String[] args) throws TwitterException {
			
	        try {
	        	ConfigurationBuilder cb = new ConfigurationBuilder();
	        	
	        	cb.setDebugEnabled(true)
	        	  .setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
	        	  .setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
	        	  .setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
	        	  .setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
	        	
	        	TwitterFactory tf = new TwitterFactory(cb.build());
	        	Twitter twitter = tf.getInstance();        		
	           
	            int counter = 0;
	            
	            List<Status> status = twitter.getHomeTimeline();
	            for (Status st : status) {
	            	
	            	int a = st.getUser().getCreatedAt().getYear();
	    			int ano = a+1900;
	    			counter++;
	    			
	    			ArrayList <String> tweets1 = new ArrayList <String>();
	    			CharSequence cs = "RT @";
	    			if (st.getUser().getName() != null && st.getUser().getName().contains(textField_3.getText())) {//filtrar por nome
						
						String[] s = st.getText().split("@");
						String mensagem = s[1];
						System.out.println(counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + mensagem);
						String x = counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + mensagem;
						tweets1.add(x);
					}
	    			else {
	    				
	    				if(st.getText().contains(cs)) { //Retweets
							String[] s = st.getText().split("@");
							String mensagem = s[1];
							System.out.println(counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + mensagem);
							String x = counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + mensagem;
							tweets1.add(x);
						}
						if(st.getText().startsWith("RT @")==false) { //Tweets
							
							String y = counter + "|" + st.getUser().getCreatedAt().getDay() + "/" + st.getUser().getCreatedAt().getMonth() + "/" + ano + "|" + "@" +st.getUser().getScreenName() + "|" + st.getText();
							tweets1.add(y);
						}
	    				
	    			}
	            }
	    		
	        } catch (Exception e) { System.out.println(e.getMessage()); }
	     }
	}








}