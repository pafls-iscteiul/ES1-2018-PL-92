import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
import javax.swing.JList;

public class TwitterGUI extends JFrame {
	private JTextField textField;
	private JPanel contentPane;
	private JTextArea tArea;
	private JScrollPane pane;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwitterGUI frame = new TwitterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TwitterGUI() {


		setBounds(500, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		tArea =new JTextArea();
		//jList=new JList<String>();
		tArea.setBounds(10, 97, 515, 436);	
		//jList.setBounds(10, 97, 515, 436);	
		pane = new JScrollPane(tArea);
		pane.setBounds(10, 97, 515, 436);
		contentPane.add(pane);

		JLabel label1 = new JLabel("");
		java.awt.Image img1 = new ImageIcon (this.getClass().getResource("/hat.png")).getImage();
		label1.setIcon(new ImageIcon(img1));
		label1.setBounds(721, 11, 103, 96);
		contentPane.add(label1);

		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		lblBomDiaAcademia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblBomDiaAcademia.setBounds(564, 72, 156, 35);
		contentPane.add(lblBomDiaAcademia);

		JLabel label2 = new JLabel("");
		java.awt.Image img2 = new ImageIcon (this.getClass().getResource("/tweetI.png")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(574, 163, 134, 135);
		contentPane.add(label2);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(564, 328, 242, 171);
		contentPane.add(textArea);

		JButton btnTweet = new JButton("Tweetar");
		btnTweet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				try {
					enviaTweet(a);
				} catch (TwitterException e) {
					e.printStackTrace();
				}	
			}
		});
		btnTweet.setBounds(717, 510, 89, 23);
		getContentPane().add(btnTweet);

		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<String> lista2 = loadFeedTwitter();
					for(String a : lista2){
						tArea.append(a + "\n");
						//jList.add(a);
						//lista.addElement(a);	
					}	
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//jList= new JList<>(lista);
		btnLoad.setBounds(717, 275, 89, 23);
		contentPane.add(btnLoad);

	}

	public ArrayList<String> loadFeedTwitter() throws TwitterException {
		TwitterP a= new TwitterP();
		return a.downloadTweets();
	}

	public void enviaTweet(String a) throws TwitterException {
		SendTweets b = new SendTweets();
		b.PostingToTwitter(a); 
	}

}
