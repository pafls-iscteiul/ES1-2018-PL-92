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

public class FacebookGUI extends JFrame {
	private JTextField textField;
	private JPanel contentPane;
	private JTextArea tArea;
	private JScrollPane pane;
	private JTextField procuraField;
	//private JList<String> jList;
	//private DefaultListModel<String> lista= new DefaultListModel<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacebookGUI frame = new FacebookGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FacebookGUI() {

		
		setBounds(500, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		jList=new JList<>();
//		jList.setBounds(10, 97, 515, 436);	
		tArea =new JTextArea();
		tArea.setBounds(10, 97, 515, 436);	
		pane = new JScrollPane(tArea);
		pane.setBounds(10, 97, 515, 436);
		contentPane.add(pane);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//		btnNewButton.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent arg0) {
		//				tArea.setText("");
		//				String s =textField_3.getText();
		//				ArrayList<String> a=procura(s);
		//				
		//				for(String bb : a){
		//					tArea.append(bb + "\n");
		//				}
		//				
		//			}
		//		});
		btnNewButton.setBounds(350, 31, 175, 31);
		contentPane.add(btnNewButton);

		procuraField = new JTextField();
		procuraField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		procuraField.setBounds(10, 31, 310, 31);
		contentPane.add(procuraField);
		procuraField.setColumns(10);

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
		java.awt.Image img2 = new ImageIcon (this.getClass().getResource("/fI.png")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(564, 182, 134, 135);
		contentPane.add(label2);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(564, 328, 242, 171);
		contentPane.add(textArea);

		JButton btnPartilhar = new JButton("Partilhar");
		btnPartilhar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPartilhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				enviaPost(a);
				textArea.setText("");
			}
		});
		btnPartilhar.setBounds(717, 510, 89, 23);
		getContentPane().add(btnPartilhar);

		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<String> lista =criaListaFacebook();
//				for(String a : lista){
//					tArea.append(a + "\n");
//				}
				ArrayList<String> lista2 =loadFeed();  
				for(String a : lista2){
				tArea.append(a + "\n");
				//lista.addElement(a);	
				}
			}
		});
		btnLoad.setBounds(717, 294, 89, 23);
		contentPane.add(btnLoad);
		
//		jList= new JList<>(lista);
//		System.out.println(lista);
		

	}

	public ArrayList<String> loadFeed() {
		Facebook a= new Facebook();
		return a.downloadFeed();
	}

	public void enviaPost(String a)   {
		SendPost b = new SendPost();
		b.PostingToFacebook(a); 
	}
}